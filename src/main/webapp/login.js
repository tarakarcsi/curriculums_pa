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
        showContents(['navbar', 'topics']);
        onProfileLoad();
        onTopicsLoad();
    } else {
        onOtherResponse(loginPageDivEl, this);
    }
}

function onLoginButtonClicked() {
    const loginFormEl = document.getElementById('login-form');

    const emailInputEl = loginFormEl.querySelector('input[name="email"]');
    const passwordInputEl = loginFormEl.querySelector('input[name="password"]');

    const email = emailInputEl.value;
    const password = passwordInputEl.value;

    const params = new URLSearchParams();

    params.append('email', email);
    params.append('password', password);

    console.log("test");
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onLoginResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'login');
    xhr.send(params);
}

function displayUserName(user) {
    const profileEl = document.getElementById('profile');
    profileEl.textContent = user.name;
    profileEl.textContent.style="text-align:left;";
    profileEl.textContent.style="vertical-align:bottom;";
}

function onProfileResponse() {
    if(this.status === OK) {
        const text = JSON.parse(this.responseText);
        displayUserName(text);
        displayCredits(text);
    }
}

function onProfileLoad() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onProfileResponse);
    xhr.addEventListener('error', onNetworkError);

    xhr.open('GET', 'user');
    xhr.send();
}

function onLogoutClicked() {
    showContents(['login-page']);
}