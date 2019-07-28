let userCurriculumsTableEl;
let userCurriculumsTbodyEl;

function displayUsersCurriculums(curriculums) { //displaying curriculums bought by user
    userCurriculumsTableEl = document.getElementById('user-curriculums');
    userCurriculumsTbodyEl = userCurriculumsTableEl.querySelector('tbody');

    //removeAllChildren(userCurriculumsTbodyEl);
    
    for(let i = 0; i < curriculums.length; i++) {
        const curriculum = curriculums[i];
        const curriculumTitleEl = document.createElement('td');

        curriculumTitleEl.textContent = curriculum.title;
        curriculumTitleEl.setAttribute('id', curriculum.id);

        const aEl = document.createElement('a');
        aEl.setAttribute('href', curriculum.content);
        aEl.textContent = "View";

        curriculumTitleEl.appendChild(aEl);

        const trEl = document.createElement('tr');
        
        trEl.appendChild(curriculumTitleEl);

        userCurriculumsTbodyEl.appendChild(trEl);
    }
}

function onCurriculumResponse() {
    if(this.status === OK){
        const text = JSON.parse(this.responseText);
        displayUsersCurriculums(text);
        showContents(['navbar', 'library']);
    }else{
        const libraryDivEl = document.getElementById('library');
        onOtherResponse(libraryDivEl, this);
    }
}

function onLibraryLoad() {
    const xhr = new XMLHttpRequest();

    xhr.addEventListener('load', onCurriculumResponse);
    xhr.addEventListener('error', onNetworkError);

    xhr.open('GET', 'library');
    xhr.send();
}