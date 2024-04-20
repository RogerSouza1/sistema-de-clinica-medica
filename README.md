# 👩‍⚕️Seja Bem vindo ao MedEasy
> O projeto MedEasy é uma iniciativa desenvolvida para avaliar o conteúdo da disciplina de PI (Projeto Integrador) no curso de ADS do Centro Universitário Senac.
> Nosso objetivo final é a criação de um sistema médico abrangente, capaz de gerenciar o CRUD de pacientes, médicos e consultas.
> O sistema será completo, apresentando uma interface front-end para facilitar a interação do usuário, desde o processo de cadastro até o armazenamento seguro de dados em nosso banco de dados. Com a orientação do nosso professor, buscamos estabelecer este projeto como um modelo para futuros desenvolvedores

## 🔧Lista de Funcionalidades
#### Requisitos Funcionais
- [ ] O usuário deve conseguir se cadastrar como Paciente ou Médico
- [ ] O usuário deve conseguir consultar e alterar suas informações cadastrais necessárias
- [ ] O usuário deve conseguir fazer login em sua Área Credenciada específica
- [ ] O usuário deve conseguir alterar a sua senha, fornecendo o CPF e Email
- [ ] O paciente deve conseguir agendar suas consultas, selecionando a especialidade, data e horário disponíveis
- [ ] O paciente deve conseguir acessar seu painel de consultas agendadas e ter a opção de confirmá-las ou cancelá-las
- [ ] O médico deve conseguir definir e alterar seus horários disponíveis individualmente por data e horário
- [ ] O médico deve ter acesso às consultas confirmadas que terá no dia e consultar os respectivos prontuários
- [ ] O médico deve conseguir cancelar suas consultas individualmente

#### Requisitos Não-Funcionais
- [ ] O site deve conter uma página principal que mostre as especialidades atendidas
- [ ] O site deve conter um sobre referente ao plano
- [ ] O site deve conter uma descrição de cada especialidade

#### Regras de Negócio
- [ ] O usuário só deve conseguir se cadastrar se tiver mais de 18 anos no dia do cadastro
- [ ] A senha do usuário deve conter no mínimo 8 caracteres, sendo uma letra maiúscula e um número
- [ ] O usuário só pode adicionar no máximo 3 dependentes por CPF
- [ ] No cadastro, a finalização só pode ser completa se todos os dados solicitados forem inseridos e validados
- [ ] A consulta deve ser confirmada pelo Paciente até um dia antes do atendimento; caso contrário, será automaticamente cancelada

## 🩹Versionamento das entregas
#### Marco 1:
- Construção dos protótipos de alta fidelidade;
- Construção do MER (Modelo Entidade Relacionamento);
- Construção dos casos de uso com UML;

## 🦿Caso de Uso (UML)
![casodeuso](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/6ea9d20f-a943-44ac-b4c2-f12df062af61)


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
![MER](https://github.com/RogerSouza1/sistema-de-clinica-medica/assets/136206263/c91afa8e-2a1d-45b2-8565-4ef03aaa0632)

### Usuário
| nomeAtributo | tipo | descrição|
| --- | --- | --- |
| id_usuario | int | chave primária |
| nome | varchar | atributo | 
| cpf | long | atributo |
| email | varchar | atributo |
| senha | varchar | atributo |
| data_nascimento | date | atributo |
| telefone | long | atributo |
| paciente | boolean | atributo |
| id_endereco | int | chave estrangeira |

### Endereço
| nomeAtributo | tipo | descrição|
| --- | --- | --- |
| id_endereco | int | chave primária |
| logradouro | varchar | atributo | 
| numero | int | atributo |
| bairro | varchar | atributo |
| cidade | varchar | atributo |
| estado | varchar | atributo |
| cep | int | atributo |

### Paciente
| nomeAtributo | tipo | descrição|
| --- | --- | --- |
| id_paciente | int | chave primária |
| dependentes | int | atributo | 
| id_usuario | int | chave estrangeira |

### Médico
| nomeAtributo | tipo | descrição|
| --- | --- | --- |
| id_medico | int | chave primária |
| especialidade | varchar | atributo | 
| crm | varchar | atributo |
| clinica | varchar | atributo |
| id_usuario | int | chave estrangeira |

### Agendamento
| nomeAtributo | tipo | descrição|
| --- | --- | --- |
| id_agendamento | int | chave primária |
| prontuario | varchar | atributo |
| confirmada | boolean | atributo |
| finalizada | boolean | atributo |
| cancelada | boolean | atributo |
| id_Paciente | int | chave estrangeira | 
| id_disponibilidade | int | chave estrangeira |

### Disponibilidade
| nomeAtributo | tipo | descrição|
| --- | --- | --- |
| id_disponibilidade | int | chave primária |
| data | date | atributo |
| id_Horario | int | chave estrangeira | 
| id_Medico | int | chave estrangeira |

### Horários
| nomeAtributo | tipo | descrição|
| --- | --- | --- |
| id_horario | int | chave primária |
| 06:00-06:30 | boolean | atributo |
| 06:30-07:00 | boolean | atributo |
| 07:00-07:30 | boolean | atributo |
| 07:30-08:00 | boolean | atributo |
| 08:00-08:30 | boolean | atributo |
| 08:30-09:00 | boolean | atributo |
| 09:00-09:30 | boolean | atributo |
| 09:30-10:00 | boolean | atributo |
| 10:00-10:30 | boolean | atributo |
| 10:30-11:00 | boolean | atributo |
| 11:00-11:30 | boolean | atributo |
| 11:30-12:00 | boolean | atributo |
| 12:00-12:30 | boolean | atributo |
| 12:30-13:00 | boolean | atributo |
| 13:00-13:30 | boolean | atributo |
| 13:30-14:00 | boolean | atributo |
| 14:00-14:30 | boolean | atributo |
| 14:30-15:00 | boolean | atributo |
| 15:00-15:30 | boolean | atributo |
| 15:30-16:00 | boolean | atributo |
| 16:00-16:30 | boolean | atributo |
| 16:30-17:00 | boolean | atributo |
| 17:00-17:30 | boolean | atributo |
| 17:30-18:00 | boolean | atributo |
| 18:00-18:30 | boolean | atributo |
| 18:30-19:00 | boolean | atributo |

## 👨‍💻Autores do projeto
[**Carla Brito**](https://github.com/carladfb)

[**Felippe Pedrosa**](https://github.com/Pelifefe)

[**Geórgia Ligia**](https://github.com/GeorgiaLSousa)

[**Heloysa Arruda**](https://github.com/heloysasa)

[**Nicolas Oliveira**](https://github.com/NicolasNascimento05)

[**Roger Souza**](https://github.com/RogerSouza1)
