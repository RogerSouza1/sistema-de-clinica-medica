package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Agendamento;
import br.com.clinicamedica.model.Disponibilidade;
import br.com.clinicamedica.model.Paciente;
import br.com.clinicamedica.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
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

                psInsert.setLong(1, paciente.getIdUsuario());
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

    }

    public void cancelarAgendamento(Agendamento agendamento) {

    }

    public void finalizarAgendamento(Agendamento agendamento) {

    }

    public List<Agendamento> buscarAgendamentos(Usuario usuario) {
        return Collections.emptyList();
    }

}
