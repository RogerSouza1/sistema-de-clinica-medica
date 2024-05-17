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
  var urlParams = new URLSearchParams(window.location.search);
  var open = urlParams.get('open');

  // Se houver, encontre o dropdown correspondente e abra-o.
  if (open) {
    var dropdownTitle = document.getElementById(open);
    if (dropdownTitle) {
      var dropdownContent = dropdownTitle.nextElementSibling;
      dropdownContent.style.display = "block";
      dropdownTitle.classList.add("open");
    }
  }

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