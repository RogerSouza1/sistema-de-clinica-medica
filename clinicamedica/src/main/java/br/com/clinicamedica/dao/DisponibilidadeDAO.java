package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Medico;

import java.sql.*;

public class DisponibilidadeDAO {
    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";

    public void definirHorarios(Medico medico, java.util.Date data, int idHorarios) {
        final String sqlInsert = "INSERT INTO disponibilidade (id_medico, data, id_horarios, disponivel) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlInsert);
            ps.setLong(1, medico.getId());
            ps.setDate(2, new java.sql.Date(data.getTime()));
            ps.setInt(3, idHorarios);
            ps.setBoolean(4, true);
            ps.executeUpdate();
            ps.close();
            System.out.println("Horários de disponibilidade definidos com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao definir horários de disponibilidade: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void atualizarHorarios(Medico medico, java.util.Date data, int idHorarios, boolean disponivel) {
        final String sqlUpdate = "UPDATE disponibilidade SET disponivel = ? WHERE id_medico = ? AND data = ? AND id_horarios = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlUpdate);
            ps.setBoolean(1, disponivel);
            ps.setLong(2, medico.getId());
            ps.setDate(3, new java.sql.Date(data.getTime()));
            ps.setInt(4, idHorarios);
            ps.executeUpdate();
            ps.close();
            System.out.println("Horários de disponibilidade atualizados com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar horários de disponibilidade: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
