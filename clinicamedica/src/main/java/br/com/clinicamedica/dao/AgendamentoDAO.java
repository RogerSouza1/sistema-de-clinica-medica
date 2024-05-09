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

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement psInsert = connection.prepareStatement(sqlInsert);

            psInsert.setLong(1, paciente.getIdUsuario());
            psInsert.setLong(2, idDisponibilidade);
            psInsert.setString(3, agendamento.getProntuario());
            psInsert.setBoolean(4, false);
            psInsert.setBoolean(5, false);
            psInsert.setBoolean(6, false);

            psInsert.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar agendamento: " + e.getMessage());
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
