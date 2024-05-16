window.onload = function() {
  const validacaoFalhou = document.getElementById('validacaoFalhou').textContent;
  if (validacaoFalhou === 'true') {
    document.getElementById('validacaoError').textContent = 'E-mail ou CPF inválidos!';
  }
}