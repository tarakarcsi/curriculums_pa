function displayCredits(user){
    const creditsDivEl = document.getElementById("credits");
    const pEl = document.createElement('p');
    removeAllChildren(creditsDivEl);
    pEl.textContent = user.credit;
    creditsDivEl.appendChild(pEl);
    //creditsDivEl.textContent = user.credit;
}

function onCreditsResponse() {
    if(this.status === OK) {
        const text = JSON.parse(this.responseText);
        displayCredits(text);
    }
}

function onCreditsLoad() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onCreditsResponse);
    xhr.addEventListener('error', onNetworkError);

    xhr.open('GET', 'user');
    xhr.send();
}