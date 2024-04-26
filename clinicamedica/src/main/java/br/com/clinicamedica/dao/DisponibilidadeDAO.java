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
    final String sqlDelete = "DELETE FROM disponibilidade WHERE id_medico = ? AND data = ? AND id_horarios = ?";

    try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
        PreparedStatement psInsert = connection.prepareStatement(sqlInsert);
        PreparedStatement psDelete = connection.prepareStatement(sqlDelete);

        // Buscar todos os horários para o médico e a data especificados
        Set<Long> horariosExistentes = buscarHorarios(medico, data);

        for (Map.Entry<String, Boolean> entry : horario.getDisponibilidade().entrySet()) {
            Long id_horario = getIdHorarios(entry.getKey());

            if (entry.getValue()) {
                // Se o horário não existir no banco de dados, insira-o
                if (!horariosExistentes.contains(id_horario)) {
                    psInsert.setLong(1, medico.getId());
                    psInsert.setDate(2, new java.sql.Date(data.getTime()));
                    psInsert.setLong(3, id_horario);
                    psInsert.setBoolean(4, true);
                    psInsert.executeUpdate();
                }
            } else {
                // Se o horário existir no banco de dados, mas não estiver na lista de horários selecionados, remova-o
                if (horariosExistentes.contains(id_horario)) {
                    psDelete.setLong(1, medico.getId());
                    psDelete.setDate(2, new java.sql.Date(data.getTime()));
                    psDelete.setLong(3, id_horario);
                    psDelete.executeUpdate();
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private Set<Long> buscarHorarios(Medico medico, Date data) {
    final String sqlSelect = "SELECT id_horarios FROM disponibilidade WHERE id_medico = ? AND data = ?";
    Set<Long> horarios = new HashSet<>();

    try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
        PreparedStatement psSelect = connection.prepareStatement(sqlSelect);
        psSelect.setLong(1, medico.getId());
        psSelect.setDate(2, new java.sql.Date(data.getTime()));
        ResultSet rs = psSelect.executeQuery();

        while (rs.next()) {
            horarios.add(rs.getLong("id_horarios"));
        }
    } catch (SQLException e) {
        System.out.println("Erro ao buscar horários: " + e.getMessage());
        e.printStackTrace();
    }

    return horarios;
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
