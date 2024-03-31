document.addEventListener("DOMContentLoaded", function () {
  var cadastreSeLink = document.getElementById("cadastre-se");
  var dropdownContentCadastro = document.getElementById(
    "dropdown-content-cadastro"
  );
  
  function closeDropdown(event) {
    if (!event.target.closest(".dropdown-cadastro")) {
      dropdownContentCadastro.classList.remove("show");
      document.removeEventListener("click", closeDropdown);
    }
  }

  cadastreSeLink.addEventListener("click", function (event) {
    event.preventDefault();

    var isVisible = dropdownContentCadastro.classList.contains("show");
    
    if (!isVisible) {
      dropdownContentCadastro.classList.add("show");
      document.addEventListener("click", closeDropdown);
    } else {
      dropdownContentCadastro.classList.remove("show");
    }

  });
});

document.addEventListener("DOMContentLoaded", function () {
  var cardsTitles = document.querySelectorAll(".dropdown-title");

  cardsTitles.forEach(function(cardsTitle) {
    cardsTitle.addEventListener("click", function () {
      var cardsContent = this.nextElementSibling;
      var isVisible = cardsContent.style.display === "block";

      if (!isVisible) {
        cardsContent.style.display = "block";
        this.classList.add("open");
      } else {
        cardsContent.style.display = "none";
        this.classList.remove("open"); 
      }
    });
  });
});