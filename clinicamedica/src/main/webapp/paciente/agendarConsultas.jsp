<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/reset.css" />
    <link rel="stylesheet" href="../css/style.css" />
    <link rel="shortcut icon" type="image/x-icon" href="../img/favicon.ico">
    <title>MedEasy</title>
</head>

<body>
<header>
    <!--Navbar-->
    <nav class="navbar">
        <div class="navbar-container">
            <h1 class="navbar-logo"><a href="#">MedEasy</a></h1>
            <ul class="navbar-links ms-auto">
                <li><a href="../paciente/agendarConsultas.jsp">Agendar Consulta</a></li>
                <li><form action="/consultas" method="get">
                <button type="submit" id="botao-consulta">Minhas Consultas</button>
                </form>
                </li>
                <li><a href="../paciente/pacienteDados.jsp">Alterar Dados</a></li>
                <li><a href="../index.jsp" id="sair">Sair<img src="../img/sair.svg" alt="Seta"></a></li>
            </ul>
        </div>
    </nav>
</header>

<main>
    <form action="/cadastrar-agendamento" method="post">
    <section class="agendardar-consulta-index">
        <h1>Agendamento de Consulta</h1>
        <div class="agendardar-consulta-main">
            <div class="campos-esquerda-agendar-consulta">
                <div class="campos-agendar-consulta">
                    <h2>Especialidades:</h2>
                    <input list="especialidade-agendamento-list" name="especialidade" id="especialidade-agendamento" required placeholder="Especialidade" autocomplete="off"/>
                    <datalist id="especialidade-agendamento-list">
                        <option value="Cardiologia">
                        <option value="Dermatologia">
                        <option value="Endocrinologia">
                        <option value="Gastroenterologia">
                        <option value="Geriatria">
                        <option value="Ginecologia">
                        <option value="Mastologia">
                        <option value="Nefrologia">
                        <option value="Neurologia">
                        <option value="Oftalmologia">
                        <option value="Oncologia">
                        <option value="Ortopedia">
                        <option value="Otorrinolaringologia">
                        <option value="Pediatria">
                        <option value="Psiquiatria">
                        <option value="Urologia">
                    </datalist>
                </div>

                <div class="campos-agendar-consulta">
                    <h2>Clínica:</h2>
                    <input list="clinica-agendamento-list" name="clinica" id="clinica-agendamento" required placeholder="Clínica" autocomplete="off"/>
                    <datalist id="clinica-agendamento-list">
                        <!-- Options will be filled dynamically by JavaScript -->
                    </datalist>
                </div>

                <div class="campos-agendar-consulta">
                    <h2>Médico:</h2>
                    <input list="medico-agendamento-list" name="medico" id="medico-agendamento" required placeholder="Médico" autocomplete="off"/>
                    <datalist id="medico-agendamento-list">
                        <!-- Options will be filled dynamically by JavaScript -->
                    </datalist>
                </div>
            </div>

            <div class="campos-direita-agendar-consulta">
                <div class="campos-agendar-consulta">
                    <h2>Data:</h2>
                    <input list="data-agendamento-list" name="data" id="data-agendamento" required placeholder="Data" autocomplete="off">
                    <datalist id="data-agendamento-list">
                        <!-- Options will be filled dynamically by JavaScript -->
                     </datalist>
                </div>
                <div class="campos-agendar-consulta">
                    <h2>Horários Disponíveis:</h2>
                    <input list="horario-agendamento-list" name="horario" id="horario-agendamento" required placeholder="Horário" autocomplete="off"/>
                    <datalist id="horario-agendamento-list">
                        <!-- Options will be filled dynamically by JavaScript -->
                    </datalist>
                </div>
            </div>
        </div>
        <div class="botoes-agendar-consulta">
            <button type="button" id="botão-cancelar-agendamento">Cancelar</button>
            <form action="/consultas" method="get"><button type="submit" id="botão-agendar">Agendar</button></form>
        </div>
    </section>
    </form>
</main>

<footer>
    <div class="rodape">
        <h3 class="footer-logo">MedEasy</h3>
        <div class="footer-container-medico">
            <div class="contatos-aba-medico">
                <ul>
                    <li>
                        <a href="#"
                        ><img src="../img/phone.svg" alt="telefone" />(11) 3881-3637</a
                        >
                    </li>
                    <li>
                        <a href="#"
                        ><img src="../img/whatsapp.svg" alt="whatsapp" />(11)
                            98066-7105</a
                        >
                    </li>
                    <li>
                        <a href="#"
                        ><img src="../img/email.svg" alt="email" />medeasy@gmail.com</a
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../js/agendamento.js"></script>
<script src="../js/dropdown.js"></script>

</body>
</html>
