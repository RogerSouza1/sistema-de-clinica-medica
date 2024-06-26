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
                <li><a href="../medico/horarios.jsp">Horários</a></li>
                <li>
                    <form action="/listar-consultas" method="get">
                        <button type="submit" id="botao-calendario">Calendário</button></form></li>
                <li><a href="../medico/medicoDados.jsp">Alterar Dados</a></li>
                <li><a href="../index.jsp" id="sair">Sair<img src="../img/sair.svg" alt="Seta"></a></li>
            </ul>
        </div>
    </nav>
</header>

<main>
    <!--Definição de Horários-->
            <form action="/cadastrar-horarios" method="post">
                <section>
                    <div class="horarios-index">
                        <h1>Definição de Horários</h1>

                        <div class="data-campo">
                            <h2>Data: </h2>
                            <label for="data-horarios"></label>
                            <input name= "data-horarios" type="date" id="data-horarios">
                        </div>

                        <h2>Horários: </h2>
                <div class="horarios-campo">
                    <div class="horario-option">
                        <input type="checkbox" id="07:00 - 07:30" name="horario" value="07:00 - 07:30">
                        <label for="07:00 - 07:30">07:00 - 07:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="10:00 - 10:30" name="horario" value="10:00 - 10:30">
                        <label for="10:00 - 10:30">10:00 - 10:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="13:00 - 13:30" name="horario" value="13:00 - 13:30">
                        <label for="13:00 - 13:30">13:00 - 13:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="16:00 - 16:30" name="horario" value="16:00 - 16:30">
                        <label for="16:00 - 16:30">16:00 - 16:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="07:30 - 08:00" name="horario" value="07:30 - 08:00">
                        <label for="07:30 - 08:00">07:30 - 08:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="10:30 - 11:00" name="horario" value="10:30 - 11:00">
                        <label for="10:30 - 11:00">10:30 - 11:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="13:30 - 14:00" name="horario" value="13:30 - 14:00">
                        <label for="13:30 - 14:00">13:30 - 14:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="16:30 - 17:00" name="horario" value="16:30 - 17:00">
                        <label for="16:30 - 17:00">16:30 - 17:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="08:00 - 08:30" name="horario" value="08:00 - 08:30">
                        <label for="08:00 - 08:30">08:00 - 08:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="11:00 - 11:30" name="horario" value="11:00 - 11:30">
                        <label for="11:00 - 11:30">11:00 - 11:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="14:00 - 14:30" name="horario" value="14:00 - 14:30">
                        <label for="14:00 - 14:30">14:00 - 14:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="17:00 - 17:30" name="horario" value="17:00 - 17:30">
                        <label for="17:00 - 17:30">17:00 - 17:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="08:30 - 09:00" name="horario" value="08:30 - 09:00">
                        <label for="08:30 - 09:00">08:30 - 09:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="11:30 - 12:00" name="horario" value="11:30 - 12:00">
                        <label for="11:30 - 12:00">11:30 - 12:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="14:30 - 15:00" name="horario" value="14:30 - 15:00">
                        <label for="14:30 - 15:00">14:30 - 15:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="17:30 - 18:00" name="horario" value="17:30 - 18:00">
                        <label for="17:30 - 18:00">17:30 - 18:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="09:00 - 09:30" name="horario" value="09:00 - 09:30">
                        <label for="09:00 - 09:30">09:00 - 09:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="12:00 - 12:30" name="horario" value="12:00 - 12:30">
                        <label for="12:00 - 12:30">12:00 - 12:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="15:00 - 15:30" name="horario" value="15:00 - 15:30">
                        <label for="15:00 - 15:30">15:00 - 15:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="18:00 - 18:30" name="horario" value="18:00 - 18:30">
                        <label for="18:00 - 18:30">18:00 - 18:30</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="09:30 - 10:00" name="horario" value="09:30 - 10:00">
                        <label for="09:30 - 10:00">09:30 - 10:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="12:30 - 13:00" name="horario" value="12:30 - 13:00">
                        <label for="12:30 - 13:00">12:30 - 13:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="15:30 - 16:00" name="horario" value="15:30 - 16:00">
                        <label for="15:30 - 16:00">15:30 - 16:00</label>
                    </div>
                    <div class="horario-option">
                        <input type="checkbox" id="18:30 - 19:00" name="horario" value="18:30 - 19:00">
                        <label for="18:30 - 19:00">18:30 - 19:00</label>
                    </div>
                </div>
                <button type="submit" id="botão-salvar">Salvar</button>

        </div>

    </section>
            </form>
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

<script src="../js/dropdown.js"></script>
</body>
