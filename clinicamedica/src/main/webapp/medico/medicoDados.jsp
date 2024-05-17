<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="../css/reset.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="../img/favicon.ico">
    <title>MedEasy</title>
</head>

<body>
<!--Navbar-->
<header>
    <nav class="navbar">
        <div class="navbar-container">
            <h1 class="navbar-logo"><a href="#">MedEasy</a></h1>
            <ul class="navbar-links ms-auto">
                <li><a href="../medico/horarios.jsp">Horários</a></li>
                <li>
                    <form action="/listar-consultas" method="get">
                        <button type="submit" id="botao-calendario">Calendário</button>
                    </form>
                </li>
                <li><a href="../medico/medicoDados.jsp">Alterar Dados</a></li>
                <li><a href="../index.jsp" id="sair">Sair<img src="../img/sair.svg" alt="Seta"></a></li>
            </ul>
        </div>
    </nav>
</header>


<main>
    <div class="cadastro">

        <h1 class="areaExclusiva">Alterar Dados</h1>
        <div class="forms-container" id="alterarDados-container">
            <h2>Dados Cadastrais</h2>
            <form id="forms-alterar-dados-medico" action="/alterar-dados-medico" method="post">
                <input type="text" id="alterar-nome-medico" name="medico-nome" placeholder="Nome"/>
                <input type="email" id="alterar-email-medico" name="medico-email" placeholder="Email"/>
                <input type="email" id="medico-confirmar-email" name="medico-confirmar-email" required
                       placeholder="Confirmar Email"/>
                <span id="confirmarEmailError" class="error-message"></span>

                <input type="password" id="alterar-senha-medico" name="medico-senha" placeholder="Senha"/>
                <span id="senhaError" class="error-message"></span>

                <input type="password" id="medico-confirmar-senha" name="medico-confirmar-senha" required
                       placeholder="Confirmar Senha"/>
                <span id="confirmarSenhaError" class="error-message"></span>

                <div class="dividir-caixa">
                    <div class="caixa-ddd">
                        <input type="number" name="medico-ddd" id="alterar-ddd-medico" placeholder="DDD">
                    </div>
                    <div class="caixa-telefone">
                        <input type="text" name="medico-telefone" id="alterar-telefone-medico" placeholder="Telefone">
                    </div>
                </div>

                <div class="dividir-caixa">
                    <div class="caixa-lougradouro">
                        <input type="text" id="alterar-lougradouro-medico" name="medico-lougradouro"
                               placeholder="Lougradouro">
                    </div>
                    <div class="caixa-numero">
                        <input type="number" id="alterar-numero-medico" name="medico-numero" placeholder="Nº">
                    </div>
                </div>

                <input type="text" id="alterar-bairro-medico" name="medico-bairro" placeholder="Bairro">
                <input type="text" id="aletar-cidade-medico" name="medico-cidade" placeholder="Cidade">

                <div class="dividir-caixa">
                    <div class="caixa-estado">
                        <input list="estados" id="alterar-estado-medico" name="medico-estado" placeholder="UF">
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
                        <input type="text" id="alterar-cep-medico" name="medico-cep" placeholder="CEP">
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
        <div class="footer-container-medico">
            <div class="contatos-aba-medico">
                <ul>
                    <li>
                        <a href="#"
                        ><img src="../img/phone.svg" alt="telefone"/>(11) 3881-3637</a
                        >
                    </li>
                    <li>
                        <a href="#"
                        ><img src="../img/whatsapp.svg" alt="whatsapp"/>(11)
                            98066-7105</a
                        >
                    </li>
                    <li>
                        <a href="#"
                        ><img src="../img/email.svg" alt="email"/>medeasy@gmail.com</a
                        >
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="rodape-frase">
        <h3>MedEasy - Projeto Integrador - 3ª Semestre</h3>
    </div>
</footer>
<script src="../js/alterarDadosValidacaoMedico.js"></script>
</body>
</html>