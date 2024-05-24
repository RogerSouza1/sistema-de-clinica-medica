# 👩‍⚕️Seja Bem vindo ao MedEasy
> O projeto MedEasy é uma iniciativa desenvolvida para avaliar o conteúdo da disciplina de PI (Projeto Integrador) no curso de ADS do Centro Universitário Senac.
> Nosso objetivo final é a criação de um sistema médico abrangente, capaz de gerenciar o CRUD de pacientes, médicos e consultas.
> O sistema será completo, apresentando uma interface front-end para facilitar a interação do usuário, desde o processo de cadastro até o armazenamento seguro de dados em nosso banco de dados. Com a orientação do nosso professor, buscamos estabelecer este projeto como um modelo para futuros desenvolvedores

## 🔧Lista de Funcionalidades
#### Requisitos Funcionais
- [x] O usuário deve conseguir se cadastrar como Paciente ou Médico
- [x] O usuário deve conseguir consultar e alterar suas informações cadastrais necessárias
- [x] O usuário deve conseguir fazer login em sua Área Credenciada específica
- [x] O usuário deve conseguir alterar a sua senha, fornecendo o CPF e Email
- [x] O paciente deve conseguir agendar suas consultas, selecionando a especialidade, data e horário disponíveis
- [x] O paciente deve conseguir acessar seu painel de consultas agendadas e ter a opção de confirmá-las ou cancelá-las
- [x] O médico deve conseguir definir e alterar seus horários disponíveis individualmente por data e horário
- [x] O médico deve ter acesso às consultas confirmadas que terá no dia e consultar os respectivos prontuários
- [x] O médico deve conseguir cancelar suas consultas individualmente

#### Requisitos Não-Funcionais
- [x] O site deve conter uma página principal que mostre as especialidades atendidas
- [x] O site deve conter um sobre referente ao plano
- [x] O site deve conter uma descrição de cada especialidade

#### Regras de Negócio
- [x] O usuário só deve conseguir se cadastrar se tiver mais de 18 anos no dia do cadastro
- [x] A senha do usuário deve conter no mínimo 8 caracteres, sendo uma letra maiúscula e um número
- [x] O usuário só pode adicionar no máximo 3 dependentes por CPF
- [x] No cadastro, a finalização só pode ser completa se todos os dados solicitados forem inseridos e validados

## 🩹Versionamento das entregas
#### Marco 1:
- Construção dos protótipos de alta fidelidade;
- Construção do MER (Modelo Entidade Relacionamento);
- Construção dos casos de uso com UML;
- Criar o repositório oficial do projeto;
- Enviar o readme.md com a lista de funcionalidades + versão 1 dos protótipos + v1 do MER;
#### Marco 2:
- Entrega da primeira funcionalidade;
#### Marco 3:
- Entrega de todas as funcionalidades propostas em aula;
## 🦿Caso de Uso (UML)
![useCase](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/f28b0bcc-9b6c-40de-87cd-0a9e0664fe72)



## 🖌Prototipação
### [Figma](https://www.figma.com/file/LBVzo28R39qSp1XCC8q0Nc/P.I?type=design&node-id=0%3A1&mode=design&t=7NEoHfca2crw8hu1-1)

*Tela principal*
![tela-principal](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/201fbd60-85c0-4421-980e-9d93706b7742)

*Tela de especialidades*
![tela-especialidades](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/c761a0ee-4a29-4b53-9d6f-86c00035cae6)

*Tela sobre*
![tela-sobre](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/d7a1c9ee-1ab6-4db6-944a-a15e9e4f8c0b)

*Tela Login*
![tela-login](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/1b8a8680-b8ee-4ad0-ae6c-7f790c2022c4)

*Tela do cadastro de paciente*
![tela-cadastro-paciente](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/979b7b33-3b21-479d-80db-8e977fa421b6)

*Tela do cadastro de médico*
![tela-cadastro-medico](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/bea6de23-50f4-4170-a268-fd046a069c3b)

*Tela redefinição de senha*
![tela-redefinicao-senha](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/8493cdf8-dd1f-4838-baa9-e8e078b6faba)

*Tela nova senha*
![tela-nova-senha](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/57f81329-7651-42ac-93bd-6928f4fd1761)

*Tela alterar dados paciente*
![tela-alterar-dados-paciente](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/65b1d8d2-d874-4620-8dba-a1c1e4cfd221)

*Tela alterar dados médico*
![tela-alterar-dados-medicos](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/4208d17d-99ca-4665-9d48-aa350b49d2c5)

*Tela marcação de consultas (paciente)*
![tela-marcacao-consulta](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/43c48e28-28cb-4b9e-9d8e-330baa60e240)

*Tela consultas (paciente)*
![tela-consultas](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/275954cf-3a65-4edd-9d96-5b3322e53fb8)

*Tela de definição de horários (médico)*
![tela-horarios](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/81d9a0d9-2603-45b1-bae8-3e2adfbc7396)

*Tela do calendário (médico)*
![tela-calendario](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/6f96144f-a2b4-49aa-883b-0522023d2945)

## 🎲MER
![MER](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/c2011416-0d13-4eee-8f2f-bc8fc0641d17)

### Endereço
| nomeAtributo | tipo | descrição |
| --- | --- | --- |
| id_endereco | SERIAL | chave primária |
| logradouro | VARCHAR(255) | atributo, não nulo, valor padrão '' |
| numero | INT | atributo, não nulo |
| bairro | VARCHAR(255) | atributo, não nulo, valor padrão '' |
| cidade | VARCHAR(255) | atributo, não nulo, valor padrão '' |
| estado | VARCHAR(255) | atributo, não nulo, valor padrão '' |
| cep | BIGINT | atributo, não nulo, valor padrão 0 |

### Horários
| nomeAtributo | tipo | descrição |
| --- | --- | --- |
| id_horarios | SERIAL | chave primária |
| horario | VARCHAR(255) | atributo, não nulo |

### Especialidade
| nomeAtributo | tipo | descrição |
| --- | --- | --- |
| id_especialidade | SERIAL | chave primária |
| nome_especialidade | VARCHAR(255) | atributo, não nulo |

### Clínica
| nomeAtributo | tipo | descrição |
| --- | --- | --- |
| id_clinica | SERIAL | chave primária |
| nome_clinica | VARCHAR(255) | atributo, não nulo |

### Usuário
| nomeAtributo | tipo | descrição |
| --- | --- | --- |
| id_usuario | SERIAL | chave primária |
| id_endereco | INTEGER | chave estrangeira, não nulo, referência a Endereço(id_endereco) |
| nome | VARCHAR(255) | atributo, não nulo, valor padrão '' |
| cpf | BIGINT | atributo, não nulo |
| email | VARCHAR(255) | atributo, não nulo, valor padrão '' |
| senha | VARCHAR(255) | atributo, não nulo, valor padrão '' |
| data_nascimento | DATE | atributo, não nulo |
| telefone | BIGINT | atributo, não nulo |
| is_paciente | BOOLEAN | atributo |

### Paciente
| nomeAtributo | tipo | descrição |
| --- | --- | --- |
| id_paciente | SERIAL | chave primária |
| id_usuario | INTEGER | chave estrangeira, não nulo, referência a Usuario(id_usuario) |
| dependentes | INT | atributo, não nulo |

### Médico
| nomeAtributo | tipo | descrição |
| --- | --- | --- |
| id_medico | SERIAL | chave primária |
| id_usuario | INTEGER | chave estrangeira, não nulo, referência a Usuario(id_usuario) |
| id_especialidade | INTEGER | chave estrangeira, não nulo, referência a Especialidade(id_especialidade) |
| id_clinica | INTEGER | chave estrangeira, não nulo, referência a Clinica(id_clinica) |
| crm | VARCHAR(255) | atributo, não nulo |

### Disponibilidade
| nomeAtributo | tipo | descrição |
| --- | --- | --- |
| id_disponibilidade | SERIAL | chave primária |
| id_horarios | INTEGER | chave estrangeira, não nulo, referência a Horários(id_horarios) |
| id_medico | INTEGER | chave estrangeira, não nulo, referência a Medico(id_medico) |
| data | DATE | atributo, não nulo |
| disponivel | BOOLEAN | atributo, valor padrão TRUE |

### Agendamento
| nomeAtributo | tipo | descrição |
| --- | --- | --- |
| id_agendamento | SERIAL | chave primária |
| id_paciente | INTEGER | chave estrangeira, não nulo, referência a Paciente(id_paciente) |
| id_disponibilidade | INTEGER | chave estrangeira, não nulo, referência a Disponibilidade(id_disponibilidade) |
| prontuario | VARCHAR(255) | atributo, não nulo, valor padrão '' |
| confirmada | BOOLEAN | atributo, valor padrão FALSE |
| finalizada | BOOLEAN | atributo, valor padrão FALSE |
| cancelada | BOOLEAN | atributo, valor padrão FALSE |

## 👨‍💻Autores do projeto
[**Carla Brito**](https://github.com/carladfb)

[**Felippe Pedrosa**](https://github.com/Pelifefe)

[**Geórgia Ligia**](https://github.com/GeorgiaLSousa)

[**Heloysa Arruda**](https://github.com/heloysasa)

[**Nicolas Oliveira**](https://github.com/NicolasNascimento05)

[**Roger Souza**](https://github.com/RogerSouza1)
