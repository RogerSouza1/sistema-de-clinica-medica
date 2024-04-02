const form = document.getElementById('passwordForm');
const newPassword = document.getElementById('newPassword');
const confirmPassword = document.getElementById('confirmPassword');

form.addEventListener('submit', function (e) {
  if (
    !meetsPasswordRequirements(newPassword.value) ||
    newPassword.value !== confirmPassword.value
  ) {
    e.preventDefault();

    if (!meetsPasswordRequirements(newPassword.value)) {
      alert('A senha deve conter no mínimo 8 caracteres, sendo uma letra maiúscula e um número.');
    }

    if (newPassword.value !== confirmPassword.value) {
      alert('As senhas devem ser iguais.');
    }
  }
});

function meetsPasswordRequirements(password) {
  return (
    password.length >= 8 &&
    /[A-Z]/.test(password) &&
    /\d/.test(password)
  );
}

newPassword.addEventListener('input', function (e) {
  if (newPassword.value === confirmPassword.value) {
    confirmPassword.setCustomValidity('');
  } else {
    confirmPassword.setCustomValidity('As senhas devem ser iguais.');
  }

  if (meetsPasswordRequirements(newPassword.value)) {
    confirmPassword.setCustomValidity('');
  } else {
    confirmPassword.setCustomValidity('');
  }
});

confirmPassword.addEventListener('input', function (e) {
  if (newPassword.value === confirmPassword.value) {
    confirmPassword.setCustomValidity('');
  } else {
    confirmPassword.setCustomValidity('As senhas devem ser iguais.');
  }
});