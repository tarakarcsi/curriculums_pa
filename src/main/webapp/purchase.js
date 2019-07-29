function onBuyButtonLoad(curriculumId) {
    const xhr = new XMLHttpRequest();
    
    const params = new URLSearchParams();

    params.append('id', curriculumId);

    xhr.addEventListener('load', onBuyButtonResponse);
    xhr.addEventListener('error', onNetworkError);

    xhr.open('POST', 'purchase');
    xhr.send(params);
}

function onBuyButtonResponse() {
    if(this.status === OK) {
        alert('Curriculum successfully added to your Library!')
        onLoginButtonClicked();
    }else{
        alert(this.responseText);
        onOtherResponse(buyButtonEl, this);
    }
}
