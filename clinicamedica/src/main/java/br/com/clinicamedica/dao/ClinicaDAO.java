package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Clinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClinicaDAO {
    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";

    public Clinica getClinicaByName(String nome) {
        final String sqlSelect = "SELECT * FROM Clinica WHERE nome_clinica = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Clinica clinica = new Clinica();
                clinica.setId(rs.getLong("id_clinica"));
                clinica.setNome(rs.getString("nome_clinica"));
                return clinica;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar a clínica: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public List<Clinica> getClinicasByEspecialidade(String especialidadeNome) {
        List<Clinica> clinicas = new ArrayList<>();
        final String sqlSelect = "SELECT c.* FROM Clinica c " +
                "JOIN Medico m ON c.id_clinica = m.id_clinica " +
                "JOIN Especialidade e ON m.id_especialidade = e.id_especialidade " +
                "WHERE e.nome_especialidade = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, especialidadeNome);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clinica clinica = new Clinica();
                clinica.setId(rs.getLong("id_clinica"));
                clinica.setNome(rs.getString("nome_clinica"));
                clinicas.add(clinica);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar as clínicas: " + e.getMessage());
            e.printStackTrace();
        }

        return clinicas;
    }
}