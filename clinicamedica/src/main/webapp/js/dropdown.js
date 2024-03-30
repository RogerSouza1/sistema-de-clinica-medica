document.addEventListener("DOMContentLoaded", function () {
    var cadastreSeLink = document.getElementById("cadastre-se");
    var dropdownContentCadastro = document.getElementById("dropdown-content-cadastro");
  
    // Função para fechar o dropdown quando clicar fora dele
    function closeDropdown(event) {
      if (!event.target.closest('.dropdown-cadastro')) {
        dropdownContentCadastro.classList.remove("show");
        document.removeEventListener('click', closeDropdown);
      }
    }
  
    cadastreSeLink.addEventListener("click", function (event) {
      event.preventDefault(); // Evita que o link seja seguido
  
      // Verifica se o dropdown está visível
      var isVisible = dropdownContentCadastro.classList.contains("show");
  
      // Adiciona ou remove a classe 'show' para mostrar ou ocultar o dropdown
      if (!isVisible) {
        dropdownContentCadastro.classList.add("show");
        // Adiciona um evento para fechar o dropdown ao clicar fora dele
        document.addEventListener('click', closeDropdown);
      } else {
        dropdownContentCadastro.classList.remove("show");
      }
    });
  });