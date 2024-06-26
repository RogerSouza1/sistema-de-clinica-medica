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
    <section id="banner-especialidades">
        <div class="banner-especialidades-contatiner">
            <h3>
                “A base da medicina é a simpatia e o desejo de ajudar os outros e tudo
                o que é feito com esse fim deve ser chamado de medicina”
            </h3>
            <h3>- Frank Payne</h3>
        </div>
    </section>

    <section id="especialidades">
        <div class="especialidades-container">
            <h3>Conheça nossas especialidades!</h3>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="cardiologia">Cardiologia <img src="img/setinhalado.svg" alt="seta"></h4>
                <p class="dropdown-content">
                    A cardiologia é a especialidade médica dedicada ao estudo,
                    diagnóstico e tratamento de
                    doenças do coração e do sistema circulatório. Essa disciplina
                    abrange uma ampla gama de
                    condições, desde doenças cardíacas congênitas até problemas
                    adquiridos ao longo da vida,
                    como doença arterial coronariana e insuficiência cardíaca. Os
                    cardiologistas desempenham
                    um papel crucial na prevenção, diagnóstico precoce e gestão eficaz
                    dessas condições,
                    utilizando abordagens que incluem mudanças no estilo de vida,
                    medicamentos e intervenções
                    médicas e cirúrgicas quando necessário. O objetivo principal é
                    promover a saúde cardiovascular
                    e melhorar a qualidade de vida dos pacientes.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="dermatologia">Dermatologia <img src="img/setinhalado.svg"
                                                                               alt="seta"></h4>
                <p class="dropdown-content">
                    A dermatologia é uma especialidade médica que trata de problemas
                    relacionados à pele, cabelo,
                    unhas e mucosas. Dermatologistas diagnosticam e tratam uma ampla
                    gama de condições, como acne,
                    eczema, psoríase, câncer de pele e infecções cutâneas. Eles também
                    realizam procedimentos
                    dermatológicos, como cirurgias e tratamentos a laser, e promovem a
                    prevenção através da educação
                    sobre proteção solar e cuidados com a pele. Em resumo, a
                    dermatologia é crucial para a saúde e o
                    bem-estar, abordando questões que afetam a integridade da maior
                    barreira protetora do corpo humano: a pele.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="endocrinologia">Endocrinologia <img src="img/setinhalado.svg"
                                                                                   alt="seta"></h4>
                <p class="dropdown-content">
                    A endocrinologia é o ramo da medicina que estuda as glândulas
                    endócrinas e os hormônios que elas
                    produzem. Esses hormônios desempenham papéis importantes no controle
                    de diversos processos do corpo,
                    como metabolismo, crescimento e reprodução. Distúrbios endócrinos
                    podem resultar em condições como
                    diabetes, hipotireoidismo e síndrome de Cushing. O diagnóstico e
                    tratamento desses distúrbios geralmente
                    envolvem exames clínicos, laboratoriais e, às vezes, intervenções
                    cirúrgicas. O campo da endocrinologia
                    está em constante evolução, com novas descobertas e terapias sendo
                    desenvolvidas para tratar essas condições.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="gastroenterologia">Gastroenterologia <img
                        src="img/setinhalado.svg" alt="seta"></h4>
                <p class="dropdown-content">
                    A gastroenterologia é a especialidade médica que trata das doenças
                    do sistema digestivo, como estômago, intestinos,
                    fígado e pâncreas. Os gastroenterologistas usam exames como
                    endoscopia e colonoscopia para diagnosticar e tratar uma
                    ampla gama de condições, desde refluxo ácido até câncer
                    gastrointestinal. Eles também desempenham um papel crucial na
                    prevenção de doenças através de orientações sobre dieta e detecção
                    precoce de problemas digestivos. Essa área médica
                    está sempre evoluindo com novas tecnologias e terapias.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="geriatria">Geriatria
                    <img src="img/setinhalado.svg" alt="seta">
                </h4>
                <p class="dropdown-content">
                    A geriatria é a especialidade médica focada na saúde e no bem-estar
                    dos idosos. Os geriatras são treinados para lidar
                    com as complexidades físicas, mentais e sociais associadas ao
                    envelhecimento. Eles avaliam e tratam uma variedade de
                    condições comuns em idosos, como demência, fragilidade,
                    incontinência, osteoporose e doenças crônicas. Além disso, os
                    geriatras têm um papel importante na promoção da qualidade de vida
                    dos idosos, fornecendo cuidados preventivos, otimizando
                    a medicação e coordenando o cuidado interdisciplinar. O objetivo
                    principal da geriatria é permitir que os idosos mantenham
                    a independência e a funcionalidade pelo maior tempo possível,
                    garantindo ao mesmo tempo uma boa qualidade de vida.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="ginecologia">Ginecologia <img src="img/setinhalado.svg"
                                                                             alt="seta"></h4>
                <p class="dropdown-content">
                    A ginecologia é a especialidade médica dedicada à saúde do sistema
                    reprodutivo feminino, incluindo o útero, os ovários e a
                    vagina. Os ginecologistas são responsáveis por diagnosticar, tratar
                    e prevenir uma variedade de condições que afetam as
                    mulheres, desde problemas menstruais até doenças sexualmente
                    transmissíveis, passando pela gestação e menopausa. Eles
                    realizam exames ginecológicos de rotina, como o exame de
                    Papanicolau, e podem oferecer orientação sobre contracepção,
                    planejamento
                    familiar e saúde sexual. Além disso, os ginecologistas também podem
                    realizar procedimentos cirúrgicos ginecológicos,
                    como histerectomias e cirurgias laparoscópicas. A ginecologia
                    desempenha um papel fundamental na saúde e no bem-estar das
                    mulheres em todas as fases de suas vidas.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="mastologia">Mastologia <img src="img/setinhalado.svg"
                                                                           alt="seta"></h4>
                <p class="dropdown-content">
                    A mastologia é a especialidade médica dedicada ao estudo, prevenção,
                    diagnóstico e tratamento das doenças da mama. Os
                    mastologistas são responsáveis por cuidar da saúde das mamas
                    femininas e masculinas, incluindo o diagnóstico e tratamento do
                    câncer de mama, além de outras condições como mastalgia (dor na
                    mama), mastite (inflamação da mama), cistos e tumores benignos.
                    Eles realizam exames clínicos das mamas, interpretam exames de
                    imagem, como mamografias e ultrassonografias, e podem realizar
                    biópsias e cirurgias mamárias, quando necessário. Além disso, os
                    mastologistas também desempenham um papel importante na educação
                    e no apoio aos pacientes, fornecendo informações sobre prevenção,
                    rastreamento e tratamento das doenças mamárias. A mastologia é
                    essencial para a saúde e o bem-estar das pessoas, contribuindo para
                    a detecção precoce e o tratamento eficaz do câncer de mama,
                    uma das principais causas de morte por câncer em todo o mundo.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="nefrologia">Nefrologia <img src="img/setinhalado.svg"
                                                                           alt="seta"></h4>
                <p class="dropdown-content">
                    A nefrologia é a área da medicina dedicada ao estudo, diagnóstico e
                    tratamento das doenças relacionadas aos rins. Os nefrologistas
                    são especialistas treinados para cuidar da saúde renal, lidando com
                    condições como insuficiência renal aguda e crônica, doença renal
                    crônica, hipertensão arterial, distúrbios eletrolíticos e
                    transtornos do equilíbrio ácido-base. Eles realizam avaliações
                    clínicas,
                    interpretam exames laboratoriais e de imagem, como a análise de
                    urina e a ultrassonografia renal, e prescrevem tratamentos que podem
                    incluir medicamentos, diálise ou transplante renal. Além disso, os
                    nefrologistas desempenham um papel importante na prevenção de
                    doenças
                    renais, educando os pacientes sobre hábitos saudáveis e monitorando
                    aqueles com fatores de risco para complicações renais. A nefrologia
                    é essencial para a saúde e o bem-estar dos pacientes, garantindo o
                    funcionamento adequado dos rins e ajudando a prevenir e tratar
                    doenças renais graves.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="neurologia">Neurologia <img src="img/setinhalado.svg"
                                                                           alt="seta"></h4>
                <p class="dropdown-content">
                    A neurologia é a especialidade médica que trata das doenças do
                    sistema nervoso, incluindo cérebro, medula espinhal, nervos
                    periféricos
                    e músculos. Neurologistas diagnosticam e tratam uma ampla variedade
                    de condições, como dores de cabeça, acidente vascular cerebral,
                    epilepsia,
                    doença de Alzheimer e distúrbios do movimento, como o Parkinson.
                    Eles utilizam exames clínicos e de imagem para diagnosticar, e o
                    tratamento
                    pode incluir medicamentos, reabilitação ou cirurgia. A neurologia
                    desempenha um papel crucial na melhoria da qualidade de vida dos
                    pacientes
                    com distúrbios neurológicos.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="oftalmologia">Oftalmologia <img src="img/setinhalado.svg"
                                                                               alt="seta"></h4>
                <p class="dropdown-content">
                    A oftalmologia é a especialidade médica que trata de doenças
                    relacionadas aos olhos e à visão. Os oftalmologistas diagnosticam e
                    tratam condições como miopia, catarata, glaucoma e retinopatia
                    diabética. Eles realizam exames oftalmológicos e podem prescrever
                    óculos, lentes de contato ou realizar procedimentos cirúrgicos para
                    corrigir problemas visuais. A oftalmologia é crucial para manter a
                    saúde ocular e a qualidade de vida dos pacientes.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="oncologia">Oncologia <img src="img/setinhalado.svg" alt="seta">
                </h4>
                <p class="dropdown-content">
                    A oncologia é a especialidade médica que trata do câncer.
                    Oncologistas são especialistas em diagnosticar, tratar e prevenir o
                    câncer, utilizando uma variedade de abordagens terapêuticas, como
                    cirurgia, radioterapia, quimioterapia e imunoterapia. Eles também
                    promovem hábitos saudáveis e realizam programas de rastreamento para
                    detectar precocemente o câncer. Essa área médica está em constante
                    evolução, buscando novas terapias e estratégias para melhorar os
                    resultados dos pacientes com câncer.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="ortopedia">Ortopedia <img src="img/setinhalado.svg" alt="seta">
                </h4>
                <p class="dropdown-content">
                    A ortopedia é a especialidade médica que trata do sistema
                    musculoesquelético. Ortopedistas diagnosticam, tratam e reabilitam
                    lesões e condições relacionadas a ossos, articulações, músculos e
                    ligamentos. Eles usam uma variedade de abordagens, como
                    medicamentos, fisioterapia e cirurgia, para ajudar os pacientes a
                    recuperar a função e aliviar a dor. A ortopedia é fundamental para
                    manter a mobilidade e a qualidade de vida.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="otorrinolaringologia">Otorrinolaringologia <img
                        src="img/setinhalado.svg" alt="seta"></h4>
                <p class="dropdown-content">
                    A otorrinolaringologia é a especialidade médica que trata de
                    problemas relacionados ao ouvido, nariz, garganta, cabeça e pescoço.
                    Os otorrinolaringologistas diagnosticam e tratam uma variedade de
                    condições, incluindo problemas de audição, sinusite, distúrbios do
                    sono e tumores de cabeça e pescoço. Eles realizam exames clínicos e,
                    quando necessário, procedimentos cirúrgicos para melhorar a saúde e
                    a qualidade de vida dos pacientes.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="pediatria">Pediatria <img src="img/setinhalado.svg" alt="seta">
                </h4>
                <p class="dropdown-content">
                    A pediatria é a área da medicina que cuida da saúde das crianças,
                    desde o nascimento até a adolescência. Pediatras diagnosticam,
                    tratam e previnem uma variedade de condições pediátricas, oferecendo
                    cuidados físicos, emocionais e sociais. Eles realizam exames
                    físicos, orientam os pais sobre nutrição e desenvolvimento infantil,
                    e promovem a saúde pública através de vacinação e educação sobre
                    segurança infantil.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="psiquiatria">Psiquiatria <img src="img/setinhalado.svg"
                                                                             alt="seta"></h4>
                <p class="dropdown-content">
                    A psiquiatria é a especialidade médica que trata dos distúrbios
                    mentais, emocionais e comportamentais. Psiquiatras diagnosticam,
                    tratam e previnem uma ampla gama de condições, como depressão,
                    ansiedade, esquizofrenia e transtorno bipolar. Eles usam
                    psicoterapia, medicação e outras abordagens terapêuticas para ajudar
                    os pacientes a superar seus desafios emocionais e melhorar sua
                    qualidade de vida. A psiquiatria também envolve a promoção da saúde
                    mental e a pesquisa sobre distúrbios mentais.
                </p>
            </div>
            <div class="cards-dropdown">
                <h4 class="dropdown-title" id="urologia">Urologia <img src="img/setinhalado.svg" alt="seta">
                </h4>
                <p class="dropdown-content">
                    A urologia é a especialidade médica que trata do sistema urinário e
                    reprodutivo masculino e feminino. Os urologistas diagnosticam e
                    tratam uma variedade de condições, incluindo infecções urinárias,
                    cálculos renais, problemas de próstata e disfunção erétil. Eles
                    realizam exames clínicos e cirurgias, quando necessário, para
                    melhorar a saúde e o bem-estar dos pacientes.
                </p>
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
                        <a href="#"><img src="img/phone.svg" alt="telefone"/>(11)
                            3881-3637</a>
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
</body>
</html>