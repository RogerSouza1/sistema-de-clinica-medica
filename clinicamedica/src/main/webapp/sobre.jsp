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
                <li><a href="sobre.html">Sobre</a></li>
                <li><a href="login.jsp" id="login">Login</a></li>
                <li class="dropdown-cadastro">
                    <a href="#" id="cadastre-se"
                    >Cadastre-se <img src="img/setinha.svg" alt="seta"
                    /></a>
                    <ul
                            class="dropdown-content-cadastro"
                            id="dropdown-content-cadastro"
                    >
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
</body>

<main class="sobre">
    <div class="bloco-impar">
        <div class="img-sobre"><img src="./img/sobreNos.png" alt="Sobre nós"/></div>
        <div class="textos-sobre">
            <h1 class="impar-sobre">Sobre Nós</h1>
            <h3 class="descricao-sobre">Bem-vindo ao MedEasy, sua escolha para soluções abrangentes e inovadoras
                desde 2024. Nosso compromisso é proporcionar benefícios de alta qualidade, focando no bem-estar e
                satisfação dos nossos associados.</h3>
        </div>
    </div>
    <div class="bloco2">
        <div class="textos-sobre">
            <h1 class="par-sobre">Nossa Equipe</h1>
            <h3 class="descricao-sobre">Contamos com uma equipe experiente e dedicada, pronta para entender as
                necessidades específicas dos nossos associados. Cada membro contribui com conhecimento especializado,
                garantindo soluções personalizadas e atendimento eficiente.</h3>
        </div>
        <div class="img-sobre"><img class="img-direita" src="./img/equipe.png" alt="Nossa equipe"/></div>
    </div>
    <div class="bloco-impar">
        <div class="img-sobre"><img src="./img/localizacao.png" alt="Localização"/></div>
        <div class="textos-sobre">
            <h1 class="impar-sobre">Nosso Foco</h1>
            <h3 class="descricao-sobre">No MedEasy, concentramos nossos esforços na satisfação e bem-estar dos
                associados. Buscamos constantemente oportunidades para melhorar suas vidas, colaborando com parceiros
                alinhados aos nossos valores. Junte-se a nós para uma experiência onde você é valorizado e cuidado.</h3>
        </div>
    </div>
</main>

<!--Footer-->
<footer>
    <div class="rodape">
        <h3 class="footer-logo">MedEasy</h3>
        <div class="footer-container">
            <div class="navegacao">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="sobre.html">Sobre</a></li>
                </ul>
            </div>
            <div class="contatos">
                <ul>
                    <li>
                        <a href="#"
                        ><img src="img/phone.svg" alt="telefone"/>(11) 3881-3637</a
                        >
                    </li>
                    <li>
                        <a href="#"
                        ><img src="img/whatsapp.svg" alt="whatsapp"/>(11) 98066-7105</a
                        >
                    </li>
                    <li>
                        <a href="#"
                        ><img src="img/email.svg" alt="email"/>medeasy@gmail.com</a
                        >
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
</html>
