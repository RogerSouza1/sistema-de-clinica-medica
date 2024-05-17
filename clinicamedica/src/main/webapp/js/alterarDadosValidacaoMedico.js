window.onload = function () {
    var emailField = document.getElementById('alterar-email-medico');
    var confirmEmailField = document.getElementById('medico-confirmar-email');
    var passwordField = document.getElementById('alterar-senha-medico');
    var confirmPasswordField = document.getElementById('medico-confirmar-senha');

    emailField.addEventListener('input', function () {
        document.getElementById('confirmarEmailError').textContent = '';
    });

    confirmEmailField.addEventListener('input', function () {
        document.getElementById('confirmarEmailError').textContent = '';
    });

    passwordField.addEventListener('input', function () {
        document.getElementById('confirmarSenhaError').textContent = '';
    });

    confirmPasswordField.addEventListener('input', function () {
        document.getElementById('confirmarSenhaError').textContent = '';
    });

    document.getElementById('forms-alterar-dados-medico').addEventListener('submit', function (event) {
        event.preventDefault();
        event.stopPropagation();

        var email = emailField.value;
        var confirmarEmail = confirmEmailField.value;
        var senha = passwordField.value;
        var confirmarSenha = confirmPasswordField.value;

        var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d!@#$%^&*]{8,}$/;

        if (!emailRegex.test(email) || email !== confirmarEmail) {
            document.getElementById('confirmarEmailError').textContent = 'Os e-mails digitados não são iguais!';
        } else if (senha !== confirmarSenha) {
            document.getElementById('confirmarSenhaError').textContent = 'As senhas digitadas não são iguais!';
        } else if (!passwordRegex.test(senha)) {
            document.getElementById('confirmarSenhaError').textContent = 'A senha deve ter pelo menos 8 caracteres, uma letra maiúscula, um número e um caractere especial!';
        } else {
            // If everything is fine, clear error messages and submit the form
            document.getElementById('confirmarEmailError').textContent = '';
            document.getElementById('confirmarSenhaError').textContent = '';
            document.getElementById('forms-alterar-dados-medico').submit();
        }
    });
}