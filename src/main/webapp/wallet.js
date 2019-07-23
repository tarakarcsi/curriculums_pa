function onWalletclicked(){
    showContents(['navbar', 'wallet']);
}

function onUploadButtonClicked() {
    
    const walletDivEl = document.getElementById('wallet');
    const amountInputEl = walletDivEl.querySelector('input[name = "amount"]');
    
    const amount = amountInputEl.value;

    const params = new URLSearchParams();
    params.append('credit', amount);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onUploadResponse);
    xhr.addEventListener('error', onNetworkError);

    xhr.open('POST', 'user');
    xhr.send(params);
}

function onUploadResponse() {
    if(this.status === OK) {
        const text = JSON.parse(this.responseText);
    } else {
        const buttonEl = document.getElementById('upload-button');
        onOtherResponse(buttonEl, this);
    }
}
