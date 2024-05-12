<%@ page import="br.com.clinicamedica.model.Agendamento" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.clinicamedica.model.Paciente" %>
<%@ page import="br.com.clinicamedica.model.Disponibilidade" %><%--Em um arquivo JSP, você pode usar a diretiva <%@ page import %> para importar classes Java que
serão usadas no arquivo. Isso é semelhante a usar a declaração import em um arquivo Java normal.
A sintaxe é a seguinte:%> <%@ page import="nome.do.pacote.NomeDaClasse" %>--%>
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
<header>
    <!--Navbar-->
    <nav class="navbar">
        <div class="navbar-container">
            <h1 class="navbar-logo"><a href="../index.html">MedEasy</a></h1>
            <ul class="navbar-links ms-auto">
                <li><a href="../medico/horarios.html">Horários</a></li>
                <li><a href="../medico/calendario.jsp">Calendario</a></li>
                <li><a href="../medico/medicoDados.html">Alterar Dados</a></li>
                <li><a href="../index.html" id="sair">Sair<img src="../img/sair.svg" alt="Seta"></a></li>
            </ul>
        </div>
    </nav>
</header>
<main>
    <section id="calendario-medico">
    <div class="calendario-container">
        <h1 class="titulo-pagina">Pacientes</h1>
        <div class="calendario-container-interno">
            <div class="pacientes-dia-container">
                <%
                    List<Agendamento> consultasDoDia = (List<Agendamento>) request.getAttribute("consultasDoDia");
                    for (Agendamento consulta : consultasDoDia) {
                        Paciente paciente = consulta.getPaciente();
                        Disponibilidade disponibilidade = consulta.getDisponibilidade();
                %>
                <div class="pacientes-cards">
                    <h3 class="nome-paciente"><%= paciente.getNome() %></h3>
                    <div class="horario-agendamento">
                        <p><%= disponibilidade.getData() %></p>
                        <p><%= disponibilidade.getHorario().getHorarioSelecionado() %></p>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</section>
</main>

<!--Rodape-->
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

<script src="../js/dropdown.js"></script>
</body>
</html>