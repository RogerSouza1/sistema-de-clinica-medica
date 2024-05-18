<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
 <nav class="navbar">
        <div class="navbar-container">
            <h1 class="navbar-logo"><a href="#">MedEasy</a></h1>
            <ul class="navbar-links ms-auto">
                <li><a href="../paciente/agendarConsultas.jsp">Agendar Consulta</a></li>
                <li>
                    <form action="/consultas" method="get">
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
        <div>
            <h2 class="minhas-consultas">Minhas Consultas</h2>
        </div>
        <c:choose>
            <c:when test="${empty minhasConsultas}">
                <div class="grid-Confirmar-Consultas">
                    <div class="info-consulta">
                        <p>Você não possui consultas agendadas.</p>
                    </div>
                </div>
            </c:when>
        <c:otherwise>
        <table>
            <c:forEach var="agendamento" items="${minhasConsultas}">
                        <div class="grid-Confirmar-Consultas">
                        <div class="info-consulta">
                        <p>Especialidade: <span style="font-weight: 400">${agendamento.disponibilidade.medico.especialidade.nome}</span></p>
                        <p>Medico(a): <span style="font-weight: 400">${agendamento.disponibilidade.medico.nome}</span></p>
                        <p>Clinica: <span style="font-weight: 400">${agendamento.disponibilidade.medico.clinica.nome}</span></p>
                </div>
                <div class="info-detalhes">
                        <p>Data: <span style="font-weight: 400">${agendamento.disponibilidade.data}</span></p>
                        <p>Horário: <span style="font-weight: 400">${agendamento.disponibilidade.horario.horarioSelecionado}</span></p>
                </div>
                <div class="botao-consulta">
                        <form action="/cancelar-consulta-paciente" method="post">
                            <input type="hidden" name="id_agendamento" value="${agendamento.id}">
                            <button  type="submit" id="botao-cancelar-consulta">Cancelar</button>
                        </form>
                        <form action="/confirmar-consulta-paciente" method="post">
                            <input type="hidden" name="id_agendamento" value="${agendamento.id}">
                            <button type="submit" id="botao-confirmar-consulta">Confirmar</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
            </c:otherwise>
            </c:choose>
            </div>
        </table>
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

<script src="../js/dropdown.js"></script>
</body>
</html>
