document.getElementById('password-form').addEventListener('submit', function (event) {
  var senha = document.getElementById('nova-senha').value;
  var confirmarSenha = document.getElementById('confirmar-senha').value;

  var regex = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;

  if (senha !== confirmarSenha) {
    document.getElementById('senhaError').textContent = 'As senhas digitadas não são iguais!';
    event.preventDefault();
  } else if (!regex.test(senha)) {
    document.getElementById('senhaError').textContent = 'A senha deve ter pelo menos 8 caracteres, uma letra maiúscula, um número e um caractere especial!';
    event.preventDefault();
  } else {
    document.getElementById('senhaError').textContent = '';
  }
});