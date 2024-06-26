<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <div class="cadastro">
        <h1 class="areaExclusiva">Área Exclusiva</h1>
        <div class="forms-container">
            <h2>Cadastro</h2>
            <form id="paciente-form" action="/cadastrar-paciente" method="post">
                <input type="text" id="paciente-nome" name="paciente-nome" required placeholder="Nome"/>
                <input type="text" id="paciente-cpf" name="paciente-cpf" required placeholder="CPF"/>
                <span id="cpfError" class="error-message"></span>

                <input type="email" id="paciente-email" name="paciente-email" required placeholder="Email"/>
                <span id="emailError" class="error-message"></span>

                <input type="email" id="paciente-confirmar-email" name="paciente-confirmar-email" required
                       placeholder="Confirmar Email"/>
                <span id="confirmarEmailError" class="error-message"></span>

                <input type="password" id="paciente-senha" name="paciente-senha" required placeholder="Senha"/>
                <span id="senhaError" class="error-message"></span>

                <input type="password" id="paciente-confirmar-senha" name="paciente-confirmar-senha" required
                       placeholder="Confirmar Senha"/>
                <span id="confirmarSenhaError" class="error-message"></span>

                <input type="date" id="paciente-data-nascimento" name="paciente-data-nascimento" required
                       placeholder="Data de Nascimento"/>
                <span id="dataNascimentoError" class="error-message"></span>

                <input list="number" name="paciente-dependentes" id="dependentes" required
                       placeholder="Quantidade de Dependentes">
                <datalist id="number">
                    <option value="0">
                    <option value="1">
                    <option value="2">
                    <option value="3">
                </datalist>

                <div class="dividir-caixa">
                    <div class="caixa-ddd">
                        <input type="number" name="paciente-ddd" id="paciente-ddd
                " required placeholder="DDD">
                    </div>
                    <div class="caixa-telefone">
                        <input type="text" name="paciente-telefone" id="paciente-telefone
                " required placeholder="Telefone">
                    </div>

                </div>

                <div class="dividir-caixa">
                    <div class="caixa-lougradouro">
                        <input type="text" id="paciente-logradouro
                " name="paciente-logradouro" required placeholder="Logradouro">
                    </div>
                    <div class="caixa-numero">
                        <input type="number" id="paciente-numero" name="paciente-numero" required placeholder="Nº">
                    </div>
                </div>

                <input type="text" id="paciente-bairro" name="paciente-bairro" required placeholder="Bairro">
                <input type="text" id="paciente-cidade" name="paciente-cidade" required placeholder="Cidade">

                <div class="dividir-caixa">
                    <div class="caixa-estado">
                        <input list="estados" id="paciente-estado" name="paciente-estado" required placeholder="UF">
                        <datalist id="estados">
                            <option value="AC">
                            <option value="AL">
                            <option value="AP">
                            <option value="AM">
                            <option value="BA">
                            <option value="CE">
                            <option value="ES">
                            <option value="GO">
                            <option value="MA">
                            <option value="MT">
                            <option value="MS">
                            <option value="MG">
                            <option value="PA">
                            <option value="PB">
                            <option value="PR">
                            <option value="PE">
                            <option value="PI">
                            <option value="RJ">
                            <option value="RN">
                            <option value="RS">
                            <option value="RO">
                            <option value="SC">
                            <option value="SP">
                            <option value="SE">
                            <option value="TO">
                            <option value="DF">
                        </datalist>
                    </div>
                    <div class="caixa-cep">
                        <input type="text" id="paciente-cep" name="paciente-cep" required placeholder="CEP">
                    </div>
                </div>

                <button type="submit">Enviar</button>
            </form>
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
                    <li><a href="sobre.jsp">Sobre</a></li>
                </ul>
            </div>
            <div class="contatos">
                <ul>
                    <li>
                        <a href="#"><img src="img/phone.svg" alt="telefone"/>(11) 3881-3637</a>
                    </li>
                    <li>
                        <a href="#"><img src="img/whatsapp.svg" alt="whatsapp"/>(11) 98066-7105</a>
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

<script src="js/cadastroPacienteValidacao.js"></script>
<script src="js/dropdown.js"></script>
</body>
</html>