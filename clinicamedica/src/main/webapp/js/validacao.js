document.getElementById('password-form').addEventListener('submit', function (event) {
    var senha = document.getElementById('nova-senha').value;
    var confirmarSenha = document.getElementById('confirmar-senha').value;

    if (senha !== confirmarSenha) {
        alert('As senhas digitadas não são iguais!');
        event.preventDefault();
    }
});