<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/reset.css" />
  <link rel="stylesheet" href="css/style.css" />
  <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
  <title>MedEasy</title>
</head>

<body>
  <!--Navbar-->
  <header>
    <nav class="navbar">
      <div class="navbar-container">
        <h1 class="navbar-logo"><a href="index.jsp">MedEasy</a></h1>
        <ul class="navbar-links ms-auto">
          <li><a href="index.jsp">Home</a></li>
          <li><a href="especialidade.jsp">Especialidades</a></li>
          <li><a href="sobre.jsp">Sobre</a></li>
          <li><a href="login.jsp" id="login">Login</a></li>
          <li class="dropdown-cadastro">
            <a href="#" id="cadastre-se">Cadastre-se <img src="img/setinha.svg" alt="seta" /></a>
            <ul class="dropdown-content-cadastro" id="dropdown-content-cadastro">
              <li>
                <a href="cadastroPaciente.jsp">Beneficiário do Plano</a>
              </li>
              <li><a href="cadastroMedico.jsp">Credenciado Médico</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>

  <main>
  <section id="redefinicao-senha">
    <div class="forms-container" id="redefinicao-senha-container">
      <h2>Redefinição de Senha</h2>
      <p>Cadastre sua nova senha</p>
      <form id="password-form" action="/update-senha" method="post">
        <input type="password" id="nova-senha" name="password" required placeholder="Nova senha" />
        <input type="password" id="confirmar-senha" name="confirmar-senha" required placeholder="Confirme sua senha" />
        <span id="senhaError" class="error-message"></span>
        <button type="submit">Enviar</button>
      </form>
    </div>
  </section>
</main>

<!--Footer-->
  <footer>
  <div class="rodape">
    <h3 class="footer-logo">MedEasy</h3>
    <div class="footer-container">
      <div class="navegacao">
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="sobre.jsp">Sobre</a></li>
        </ul>
      </div>
      <div class="contatos">
        <ul>
          <li>
            <a href="#"><img src="img/phone.svg" alt="telefone" />(11) 3881-3637</a>
          </li>
          <li>
            <a href="#"><img src="img/whatsapp.svg" alt="whatsapp" />(11) 98066-7105</a>
          </li>
          <li>
            <a href="#"><img src="img/email.svg" alt="email" />medeasy@gmail.com</a>
          </li>
        </ul>
      </div>
      <div class="redes-sociais">
        <ul>
          <li>
            <a href="#"><img src="img/linkedin.svg" alt="linkedin" /></a>
          </li>
          <li>
            <a href="#"><img src="img/facebook.svg" alt="facebook" /></a>
          </li>
          <li>
            <a href="#"><img src="img/instagram.svg" alt="instagram" /></a>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <div class="rodape-frase">
    <h3>MedEasy - Projeto Integrador - 3ª Semestre</h3>
  </div>
</footer>


</body>

<script src="js/redefinicaoValidacao.js"></script>
<script src="js/dropdown.js"></script>

</html>