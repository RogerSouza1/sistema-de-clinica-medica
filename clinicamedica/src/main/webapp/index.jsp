<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="css/style.css"/>
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
                    <a href="#" id="cadastre-se">Cadastre-se <img src="img/setinha.svg" alt="seta"/></a>
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
    <!--Banner-->
    <section id="banner">
        <div class="banner-container">
            <h2 class="primeira-frase">
                Cuide do seu bem-estar com paixão e propósito.
            </h2>
            <h2 class="segunda-frase">Seja o protagonista da sua saúde!</h2>
            <h3 class="terceira-frase">
                Sua jornada para o bem-estar é única, estamos aqui para fazer parte
                desse enredo extraordinário da sua vida saudável.
            </h3>
            <a class="botao-saiba-mais" href="especialidade.jsp">Saiba mais!</a>
        </div>
    </section>

    <!--Especialidades-->
    <section id="especialidades-index">
        <div class="especialidades-index-container">
            <h1>Especialidades</h1>
            <div class="carousel-container-1">
                <button id="prev" onclick="prevSlide()"><img src="img/seta-esquerda.svg" alt="Anterior"></button>
                <div id="carousel">
                    <div class="slide active">
                        <img src="img/cardiologia.png" alt="Cardiologia">
                        <h3>Cardiologia</h3>
                        <a href="especialidade.jsp?open=cardiologia#cardiologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/dermatologia.png" alt="Dermatologia">
                        <h3>Dermatologia</h3>
                        <a href="especialidade.jsp?open=dermatologia#dermatologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/endocrinologia.png" alt="Endocrinologia">
                        <h3>Endocrinologia</h3>
                        <a href="especialidade.jsp?open=endocrinologia#endocrinologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/gastroenterologia.png" alt="Gastroenterologia">
                        <h3>Gastroenterologia</h3>
                        <a href="especialidade.jsp?open=gastroenterologia#gastroenterologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/geriatria.png" alt="Geriatria">
                        <h3>Geriatria</h3>
                        <a href="especialidade.jsp?open=geriatria#geriatria">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/ginecologia.png" alt="Ginecologia">
                        <h3>Ginecologia</h3>
                        <a href="especialidade.jsp?open=ginecologia#ginecologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/mastologia.png" alt="Mastologia">
                        <h3>Mastologia</h3>
                        <a href="especialidade.jsp?open=mastologia#mastologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/nefrologia.png" alt="Nefrologia">
                        <h3>Nefrologia</h3>
                        <a href="especialidade.jsp?open=nefrologia#nefrologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/neurologia.png" alt="Neurologia">
                        <h3>Neurologia</h3>
                        <a href="especialidade.jsp?open=neurologia#neurologia">Saiba mais!</a>
                    </div>
                </div>
                <button id="next" onclick="nextSlide()"><img src="img/seta-direita.svg" alt="Proximo"></button>
            </div>
            <div class="carousel-container-2">
                <button id="prev" onclick="prevSlide()"><img src="img/seta-esquerda.svg" alt="Anterior"></button>
                <div id="carousel">
                    <div class="slide active">
                        <img src="img/oftalmologia.png" alt="Oftalmologia">
                        <h3>Oftalmologia</h3>
                        <a href="especialidade.jsp?open=oftalmologia#oftalmologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/oncologia.png" alt="Oncologia">
                        <h3>Oncologia</h3>
                        <a href="especialidade.jsp?open=oncologia#oncologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/ortopedia.png" alt="Ortopedia">
                        <h3>Ortopedia</h3>
                        <a href="especialidade.jsp?open=ortopedia#ortopedia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/otorrinolaringologia.png" alt="Otorrinolaringologia">
                        <h3>Otorrinolaringologia</h3>
                        <a href="especialidade.jsp?open=otorrinolaringologia#otorrinolaringologia">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/pediatria.png" alt="Pediatria">
                        <h3>Pediatria</h3>
                        <a href="especialidade.jsp?open=pediatria#pediatria">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/psiquiatria.png" alt="Psiquiatria">
                        <h3>Psiquiatria</h3>
                        <a href="especialidade.jsp?open=psiquiatria#psiquiatria">Saiba mais!</a>
                    </div>
                    <div class="slide active">
                        <img src="img/urologia.png" alt="Urologia">
                        <h3>Urologia</h3>
                        <a href="especialidade.jsp?open=urologia#urologia">Saiba mais!</a>
                    </div>
                </div>
                <button id="next" onclick="nextSlide()"><img src="img/seta-direita.svg" alt="Proximo"></button>
            </div>
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
                        <a href="#"><img src="img/phone.svg" alt="telefone"/>(11) 3881-3637</a>
                    </li>
                    <li>
                        <a href="#"><img src="img/whatsapp.svg" alt="whatsapp"/>(11)
                            98066-7105</a>
                    </li>
                    <li>
                        <a href="#"><img src="img/email.svg" alt="email"/>medeasy@gmail.com</a>
                    </li>
                </ul>
            </div>
            <div class="redes-sociais">
                <ul>
                    <li>
                        <a href="#"><img src="img/linkedin.svg" alt="linkedin"/></a>
                    </li>
                    <li>
                        <a href="#"><img src="img/facebook.svg" alt="facebook"/></a>
                    </li>
                    <li>
                        <a href="#"><img src="img/instagram.svg" alt="instagram"/></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="rodape-frase">
        <h3>MedEasy - Projeto Integrador - 3ª Semestre</h3>
    </div>
</footer>
<script src="js/dropdown.js"></script>
<script src="js/carousel.js"></script>
</body>

</html>