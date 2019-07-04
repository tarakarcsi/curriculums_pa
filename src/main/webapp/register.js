function onCreateButtonClicked() {
    const emailInputEl = registerFormEl.querySelector('input[name="email"]');
    const nameInputEl = registerFormEl.querySelector('input[name="name"]');
    const passwordInputEl = registerFormEl.querySelector('input[name="password"]');
    debugger;
    const email = emailInputEl.value;
    const name = nameInputEl.value;
    const password = passwordInputEl.value;

    const params = new URLSearchParams();

    params.append('email', email);
    params.append('name', name);
    params.append('password', password);

    const xhr = new XMLHttpRequest();

    xhr.addEventListener('load', onRegisterResponse);
    xhr.addEventListener('error', onNetworkError);
    debugger;
    xhr.open('POST', register);

}

function onRegisterResponse() {
    if (this.status === OK) {
        const text = JSON.parse(this.responseText);
    }else {
        onOtherResponse(registerContentDivEl, this);
    }
}

