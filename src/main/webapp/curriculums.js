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
        console.log(text);
    }else {
        const curriculumDivEl = document.getElementById('curriculums');
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
        priceDivEl.textContent = curriculum.price;
        priceDivEl.style.textAlign = "right";
        priceDivEl.style.color = "gold";

        const creditIconEl = document.createElement('img');
        creditIconEl.setAttribute('src', 'https://cdn1.iconfinder.com/data/icons/cash-coin-essentials-colored/48/JD-09-512.png');
        creditIconEl.style.width = "25px";
        creditIconEl.style.verticalAlign = "bottom";
        priceDivEl.appendChild(creditIconEl);

        const buyButtonEl = document.createElement('img');
        buyButtonEl.setAttribute('src', 'https://icons-for-free.com/iconfiles/png/512/buy+citycons+mall+shopping+icon-1320136423977087098.png');
        buyButtonEl.style.width = "35px";
        buyButtonEl.style.verticalAlign = "bottom";
        buyButtonEl.style.alignItems = "flex-end";
        buyButtonEl.addEventListener('click', function(){onBuyButtonLoad(curriculum.id)});

        curriculumTitleEl.textContent = curriculum.title;
        curriculumTitleEl.setAttribute('id', curriculum.id);

        const trEl = document.createElement('tr');
        trEl.appendChild(curriculumTitleEl);
        trEl.appendChild(priceDivEl);
        trEl.appendChild(buyButtonEl);

        curriculumsTbodyEl.appendChild(trEl);
    }

}
function addNewCurriculum() {
    const addCurriculumFormEl = document.forms['add-curriculum'];
    const typeSelector = document.getElementById("type");

    const pNameInputEl = loginFormEl.querySelector('input[name="name"]');
    const brandInputEl = loginFormEl.querySelector('input[name="brand"]');
    const priceInputEl = loginFormEl.querySelector('input[name="price"]');

    const typeValue = typeSelector.options[typeSelector.selectedIndex].value;
    const name = pNameInputEl.value;
    const brand = brandInputEl.value;
    const price = priceInputEl.value;

    const params = new URLSearchParams();
    params.append('name', name);
    params.append('type', typeValue);
    params.append('brand', brand);
    params.append('price', price);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', addProductResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'product?' + params.toString());
    xhr.send();
}