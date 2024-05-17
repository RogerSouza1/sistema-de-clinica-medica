window.onload = function() {
    const loginFailed = document.getElementById('loginFailed').textContent;
    if (loginFailed === 'true') {
        document.getElementById('loginError').textContent = 'Login ou senha incorretas!';
    }
}