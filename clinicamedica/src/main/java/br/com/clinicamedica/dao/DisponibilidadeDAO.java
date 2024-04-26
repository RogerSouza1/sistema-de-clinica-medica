package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Disponibilidade;
import br.com.clinicamedica.model.Horario;
import br.com.clinicamedica.model.Medico;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class DisponibilidadeDAO {
    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";

    public void inserirHorarios(String horario) {
        final String sqlInsert = "INSERT INTO horarios (horario) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, horario);
            ps.executeUpdate();
            System.out.println("Horário inserido com sucesso: " + horario);
        } catch (SQLException e) {
            System.out.println("Erro ao inserir horário: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void definirDisponibilidade(Medico medico, Date data, Horario horario) {
        final String sqlInsert = "INSERT INTO disponibilidade (id_medico, data, id_horarios, disponivel) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlInsert);

            for (Map.Entry<String, Boolean> entry : horario.getDisponibilidade().entrySet()) {
                if (entry.getValue()) {
                    System.out.println("Horário disponível: " + entry.getKey());

                    Long id_horario = getIdHorarios(entry.getKey()); // Assuming getIdHorarios returns Long for given time slot

                    ps.setLong(1, medico.getId());
                    ps.setDate(2, new java.sql.Date(data.getTime()));
                    ps.setLong(3, id_horario);
                    ps.setBoolean(4, true);

                    ps.executeUpdate(); // Execute the prepared statement
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Long getIdHorarios(String horario) {
        final String sqlSelect = "SELECT id_horarios FROM horarios WHERE horario = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement psSelect = connection.prepareStatement(sqlSelect);
            psSelect.setString(1, horario);
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                return rs.getLong("id_horarios");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter id_horarios: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
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
