function onCreateButtonClicked() {
    const emailInputEl = registerFormEl.querySelector('input[name="email"]');
    const nameInputEl = registerFormEl.querySelector('input[name="name"]');
    const passwordInputEl = registerFormEl.querySelector('input[name="password"]');

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
    xhr.open('POST', 'register');
}

function onRegisterResponse() {
    if (this.status === OK) {
        const text = JSON.parse(this.responseText);
    }
}

