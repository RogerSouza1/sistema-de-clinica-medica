package br.com.clinicamedica.dao;


import br.com.clinicamedica.model.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AgendamentoDAO {

    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";

    public void cadastrarAgendamento(Agendamento agendamento, Paciente paciente, Long idDisponibilidade) {
        final String sqlInsert = "INSERT INTO Agendamento (id_paciente, id_disponibilidade, prontuario, confirmada, finalizada, cancelada) VALUES (?, ?, ?, ?, ?, ?)";
        final String sqlUpdate = "UPDATE disponibilidade SET disponivel = false WHERE id_disponibilidade = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            connection.setAutoCommit(false); // Desativa o commit automático para transação manual
            try (PreparedStatement psInsert = connection.prepareStatement(sqlInsert);
                 PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {

                psInsert.setLong(1, paciente.getId_usuario());
                psInsert.setLong(2, idDisponibilidade);
                psInsert.setString(3, agendamento.getProntuario());
                psInsert.setBoolean(4, false);
                psInsert.setBoolean(5, false);
                psInsert.setBoolean(6, false);

                psInsert.executeUpdate(); // Insere o agendamento

                psUpdate.setLong(1, idDisponibilidade);
                psUpdate.executeUpdate(); // Atualiza a disponibilidade para false

                connection.commit(); // Realiza o commit da transação
            } catch (SQLException e) {
                connection.rollback(); // Em caso de erro, faz rollback da transação
                System.out.println("Erro ao cadastrar agendamento: " + e.getMessage());
                e.printStackTrace();
            } finally {
                connection.setAutoCommit(true); // Restaura o comportamento padrão de commit automático
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void confirmarAgendamento(Agendamento agendamento) {
        String SQL = "UPDATE Agendamento SET confirmada = true WHERE id_agendamento = ?";

        try(Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, agendamento.getId());
            preparedStatement.execute();
            System.out.println("success in update confirmar");

        } catch (SQLException e) {
            System.out.println("Erro ao confirmar agendamento: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void cancelarAgendamento(Agendamento agendamento) {
        final String SQLCancelar = "UPDATE Agendamento SET cancelada = true, prontuario = ? WHERE id_agendamento = ?";
        final String SQLDisponibilidade = "SELECT id_disponibilidade FROM Agendamento WHERE id_agendamento = ?";
        final String SQLUpdateDisponibilidade = "UPDATE disponibilidade SET disponivel = TRUE WHERE id_disponibilidade = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(SQLCancelar);
            ps.setString(1, agendamento.getProntuario());
            ps.setLong(2, agendamento.getId());
            ps.executeUpdate();
            System.out.println("Suceso ao cancelar consulta");

            PreparedStatement psDisponibilidade = connection.prepareStatement(SQLDisponibilidade);
            psDisponibilidade.setLong(1, agendamento.getId());
            ResultSet rs = psDisponibilidade.executeQuery();
            Long idDisponibilidade = null;
            while (rs.next()) {
                idDisponibilidade = rs.getLong("id_disponibilidade");
            }

            if (idDisponibilidade == null) {
                System.out.println("Erro ao buscar id da disponibilidade");
            } else {
                PreparedStatement psUpdateDisponibilidade = connection.prepareStatement(SQLUpdateDisponibilidade);
                psUpdateDisponibilidade.setLong(1, idDisponibilidade);
                psUpdateDisponibilidade.executeUpdate();
                System.out.println("Sucesso ao atualizar disponibilidade");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cancelar a consulta: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void finalizarAgendamento(Agendamento agendamento) {
        final String SQLFinalizada = "UPDATE Agendamento SET finalizada = TRUE, prontuario = ? WHERE id_agendamento = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(SQLFinalizada);
            ps.setString(1, agendamento.getProntuario());
            ps.setLong(2, agendamento.getId());
            ps.executeUpdate();
            System.out.println("Consulta finalizada com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao finalizar a consulta: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Agendamento> buscarAgendamentos(Paciente paciente) {

        List<Agendamento> minhasConsultas = new ArrayList<>();

        String SQL = "SELECT a.*, e.nome_especialidade, c.nome_clinica, d.data, h.horario, u.nome AS medico " +
                "FROM Agendamento a " +
                "JOIN Disponibilidade d ON a.id_disponibilidade = d.id_disponibilidade " +
                "JOIN Medico m ON d.id_medico = m.id_medico " +
                "JOIN Usuario u ON m.id_usuario = u.id_usuario " +
                "JOIN Especialidade e ON m.id_especialidade = e.id_especialidade " +
                "JOIN Clinica c ON m.id_clinica = c.id_clinica " +
                "JOIN Horarios h ON d.id_horarios = h.id_horarios " +
                "WHERE a.id_paciente = ? AND a.cancelada = false AND a.confirmada = false";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, paciente.getId_usuario());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Especialidade especialidade = new Especialidade();
                especialidade.setNome(resultSet.getString("nome_especialidade"));
                Clinica clinica = new Clinica();
                clinica.setNome(resultSet.getString("nome_clinica"));
                Medico medico = new Medico();
                medico.setNome(resultSet.getString("medico"));
                medico.setEspecialidade(especialidade);
                medico.setClinica(clinica);

                Horario horario = new Horario();
                horario.setHorarioSelecionado(resultSet.getString("horario"));

                Disponibilidade disponibilidade = new Disponibilidade();
                disponibilidade.setHorario(horario);
                disponibilidade.setData(resultSet.getString("data"));
                disponibilidade.setMedico(medico);
                disponibilidade.setId(resultSet.getLong("id_disponibilidade"));
                Agendamento agendamento = new Agendamento();
                agendamento.setPaciente(paciente);
                agendamento.setDisponibilidade(disponibilidade);
                agendamento.setProntuario(resultSet.getString("prontuario"));
                agendamento.setFinalizado(resultSet.getBoolean("finalizada"));
                agendamento.setCancelado(resultSet.getBoolean("cancelada"));
                agendamento.setConfirmado(resultSet.getBoolean("confirmada"));
                agendamento.setId(resultSet.getLong("id_agendamento"));

                minhasConsultas.add(agendamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar agendamentos: " + e.getMessage());
            e.printStackTrace();
        }

        return minhasConsultas;
    }

    public List<Agendamento> buscarConsultasDoDia(Long id_medico) {
        List<Agendamento> consultasDoDia = new ArrayList<>();
        final String url = "jdbc:h2:~/test";
        final String usuario = "sa";
        final String senha = "sa";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {

            String SQLAgendamento = "SELECT a.id_agendamento, a.*, u.nome, u.cpf, u.data_nascimento, h.horario, d.data " +
                    "FROM Agendamento a " +
                    "JOIN Paciente p ON a.id_paciente = p.id_paciente " +
                    "JOIN Usuario u ON p.id_usuario = u.id_usuario " +
                    "JOIN Disponibilidade d ON a.id_disponibilidade = d.id_disponibilidade " +
                    "JOIN Horarios h ON d.id_horarios = h.id_horarios " +
                    "JOIN Medico m ON d.id_medico = m.id_medico " +
                    "WHERE a.confirmada = TRUE AND a.finalizada = FALSE AND a.cancelada = FALSE AND m.id_medico = ?";

            PreparedStatement ps = connection.prepareStatement(SQLAgendamento);
            ps.setLong(1, id_medico);
            ResultSet rs = ps.executeQuery();
            System.out.println("Consulta foi realizada no banco de dados");
            SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");

            while (rs.next()) {
                System.out.println("Consulta retornou resultados");
                Agendamento agendamento = new Agendamento();
                agendamento.setId(rs.getLong("id_agendamento"));
                Paciente paciente = new Paciente();
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getLong("cpf"));

                // Convertendo a data de nascimento para um objeto Date
                try {
                    java.util.Date dataNascimentoUtil = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("data_nascimento"));
                    java.sql.Date dataNascimentoSql = new java.sql.Date(dataNascimentoUtil.getTime());
                    String dataNascimento = new SimpleDateFormat("dd/MM/yyyy").format(dataNascimentoSql);
                    paciente.setDataNascimento(dataNascimento);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // Calculando a idade
                int idade = Period.between(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("data_nascimento"))), LocalDate.now()).getYears();
                paciente.setIdade(idade);

                agendamento.setPaciente(paciente);

                Disponibilidade disponibilidade = new Disponibilidade();
                Horario horario = new Horario();
                horario.setHorarioSelecionado(rs.getString("horario"));
                disponibilidade.setHorario(horario);
                disponibilidade.setData(formatoBrasileiro.format(rs.getDate("data")));
                agendamento.setDisponibilidade(disponibilidade);

                consultasDoDia.add(agendamento);
            }

            // Cria um comparador que compara os horários das consultas
            Comparator<Agendamento> comparator = new Comparator<Agendamento>() {
                final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

                @Override
                public int compare(Agendamento a1, Agendamento a2) {
                    LocalTime time1 = LocalTime.parse(a1.getDisponibilidade().getHorario().getHorarioSelecionado().split(" - ")[0], formatter);
                    LocalTime time2 = LocalTime.parse(a2.getDisponibilidade().getHorario().getHorarioSelecionado().split(" - ")[0], formatter);
                    return time1.compareTo(time2);
                }
            };

            // Ordena a lista de consultas do dia usando o comparador
            Collections.sort(consultasDoDia, comparator);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultasDoDia;
    }
}