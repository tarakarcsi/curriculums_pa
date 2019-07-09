function onCreateAccountClicked() {
    onCreateAccountLoad();
}

function onCreateAccountLoad(){
    const loginFormEl = document.getElementById('login-form');
    loginFormEl.style.display='none';
    const registerFormEl = document.getElementById('register-form');
    registerFormEl.style.display = 'block';
}

function onSignInClicked() {
    const loginFormEl = document.getElementById('login-form');
    loginFormEl.style.display='block';
    const registerFormEl = document.getElementById('register-form');
    registerFormEl.style.display = 'none';
}

function onLoginResponse() {
    if (this.status === OK) {
        const user = JSON.parse(this.responseText);
        setAuthorization(user);
        showContents(['main', 'banner']);
    } else {
        onOtherResponse(loginContentDivEl, this);
    }
}

function onLoginButtonClicked() {
    

    const emailInputEl = loginFormEl.querySelector('input[name="email"]');
    const passwordInputEl = loginFormEl.querySelector('input[name="password"]');

    const email = passwordInputEl.value;
    const password = passwordInputEl.value;

    const params = new URLSearchParams();

    params.append('email', email);
    params.append('password', password);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onLoginResponse);
    xhr.addEventListener('error', onNetworkError);
    showContents('login-form');
    xhr.open('POST', 'login');
    xhr.send(params);
}