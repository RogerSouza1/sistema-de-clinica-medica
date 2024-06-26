<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <section id="calendario-medico">
        <div class="calendario-container">

            <h1 class="titulo-pagina">Pacientes</h1>
            <div class="calendario-container-interno">
                <div class="pacientes-dia-container">
                    <c:forEach var="consulta" items="${consultas}">
                        <div class="pacientes-cards"
                             data-nome="${consulta.paciente.nome}"
                             data-idade="${consulta.paciente.idade}"
                             data-cpf="${consulta.paciente.cpf}"
                             data-id="${consulta.id}">
                            <h4 class="id-consulta" style="display: none">${consulta.id}</h4>
                            <h3 class="nome-paciente">${consulta.paciente.nome}</h3>
                            <div class="horario-agendamento">
                                <p>${consulta.disponibilidade.data}</p>
                                <p>${consulta.disponibilidade.horario.horarioSelecionado}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="dados-paciente-container">
                    <div class="dados-paciente-escolhido">
                        <h3 class="dado-id" id="dado-id" style="display: none"></h3>
                        <h3 class="dado-nome" id="dado-nome"></h3>
                        <h3 class="dado-idade" id="dado-idade"></h3>
                        <h3 class="dado-cpf" id="dado-cpf"></h3>
                    </div>
                    <div class="prontuario-paciente-escolhido">
                        <h3 class="titulo-prontuario">Prontuário</h3>
                        <label for="prontuario"></label>
                        <textarea name="prontuario" id="prontuario" rows="50"></textarea>
                    </div>
                </div>
            </div>
            <div class="botoes-calendario-medico">
                <form method="post" action="${pageContext.request.contextPath}/cancelar-consulta">
                    <input type="hidden" id="form-dado-id-cancelar" name="dado-id" value="">
                    <button type="submit" id="botao-cancelar-consulta-medico">Cancelar</button>
                </form>
                <form method="post" action="${pageContext.request.contextPath}/finalizar-consulta">
                    <input type="hidden" id="form-dado-id-finalizar" name="dado-id" value="">
                    <input type="hidden" id="form-prontuario" name="prontuario" value="">
                    <button type="submit" id="botao-finalizar-consulta-medico">Finalizar</button>
                </form>
            </div>
        </div>
    </section>
</main>
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

<script>
    window.onload = function () {
        document.querySelectorAll('.pacientes-cards').forEach(function (card) {
            card.addEventListener('click', function () {
                var id = this.dataset.id;
                document.getElementById('dado-id').innerText = this.dataset.id;
                document.getElementById('form-dado-id-cancelar').value = id;
                document.getElementById('form-dado-id-finalizar').value = id;
                document.getElementById('dado-nome').innerText = 'Nome: ' + this.dataset.nome;
                document.getElementById('dado-idade').innerText = 'Idade: ' + this.dataset.idade;
                document.getElementById('dado-cpf').innerText = 'CPF: ' + this.dataset.cpf;
            });
        });
        document.getElementById('prontuario').addEventListener('input', function () {
            document.getElementById('form-prontuario').value = this.value;
        });
    };
</script>
<script src="../js/dropdown.js"></script>
</body>
</html>