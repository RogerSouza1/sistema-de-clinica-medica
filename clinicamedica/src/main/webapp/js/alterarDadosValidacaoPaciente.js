window.onload = function () {
    var emailField = document.getElementById('alterar-email-paciente');
    var confirmEmailField = document.getElementById('paciente-confirmar-email');
    var passwordField = document.getElementById('alterar-senha-paciente');
    var confirmPasswordField = document.getElementById('paciente-confirmar-senha');

    emailField.addEventListener('input', function () {
        document.getElementById('confirmarEmailError').textContent = '';
    });

    confirmEmailField.addEventListener('input', function () {
        document.getElementById('confirmarEmailError').textContent = '';
    });

    passwordField.addEventListener('input', function () {
        document.getElementById('senhaError').textContent = '';
    });

    confirmPasswordField.addEventListener('input', function () {
        document.getElementById('confirmarSenhaError').textContent = '';
    });

    document.getElementById('forms-alterar-dados-paciente').addEventListener('submit', function (event) {
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
            document.getElementById('senhaError').textContent = 'A senha deve ter pelo menos 8 caracteres, uma letra maiúscula, um número e um caractere especial!';
        } else {
            // If everything is fine, clear error messages and submit the form
            document.getElementById('confirmarEmailError').textContent = '';
            document.getElementById('senhaError').textContent = '';
            document.getElementById('confirmarSenhaError').textContent = '';
            document.getElementById('forms-alterar-dados-paciente').submit();
        }
    });
}