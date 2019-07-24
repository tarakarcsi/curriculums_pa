let curriculumsTableEl;
let curriculumsTbodyEl;
let topicTitleEl;

function onTopicClicked(topicId) {
    const params = new URLSearchParams();
    params.append('topicId', topicId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onCurriculumsResponse);
    xhr.addEventListener('error', onNetworkError);
    showContents(['navbar', 'topics', 'curriculums']);

    xhr.open('POST', 'curriculums');
    xhr.send(params);
}

function onCurriculumsResponse() {
    if(this.status === OK) {
        const text = JSON.parse(this.responseText) 
        displayCurriculums(text);
    }else {
        const curriculumDivEl = doc.getElementById('curriculums');
        onOtherResponse(curriculumDivEl, this);
    }
}

function displayCurriculums(curriculums) {
    curriculumsTableEl = document.getElementById('curriculums-table');
    curriculumsTbodyEl = curriculumsTableEl.querySelector('tbody');
    removeAllChildren(curriculumsTbodyEl);
    for(let i = 0; i < curriculums.length; i++) {
        
        const curriculum = curriculums[i];
        const curriculumTitleEl = document.createElement('td');
        const priceDivEl = document.createElement('div');
        priceDivEl.setAttribute('id', 'cur-price');
        priceDivEl.textContent = "(" + curriculum.price;
        priceDivEl.style.textAlign = "right";
        priceDivEl.style.color = "gold";

        const creditIconEl = document.createElement('img');
        creditIconEl.setAttribute('src', 'https://cdn1.iconfinder.com/data/icons/cash-coin-essentials-colored/48/JD-09-512.png');
        creditIconEl.style.width = "25px";
        creditIconEl.style.verticalAlign = "bottom";
        priceDivEl.appendChild(creditIconEl);

        curriculumTitleEl.textContent = curriculum.title;
        curriculumTitleEl.setAttribute('id', curriculum.id);

        const trEl = document.createElement('tr');
        trEl.appendChild(curriculumTitleEl);
        trEl.appendChild(priceDivEl);

        curriculumsTbodyEl.appendChild(trEl);
    }

}




function onCurriculumsLoad() {
    const xhr = new XMLHttpRequest();


    xhr.addEventListener('error', onNetworkError);

    xhr.open('GET', 'curriculums');
    xhr.send();
}