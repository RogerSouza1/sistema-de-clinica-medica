package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Clinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}