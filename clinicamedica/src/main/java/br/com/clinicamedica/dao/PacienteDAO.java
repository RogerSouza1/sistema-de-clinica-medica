package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Medico;
import br.com.clinicamedica.model.Paciente;

import java.sql.*;

public class PacienteDAO {

    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";
    public Paciente getPacienteByCPF(String cpf) {
        final String sqlSelect = "SELECT * FROM usuario WHERE cpf = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdUsuario(rs.getLong("id_usuario"));
                paciente.setCpf(rs.getLong("cpf"));
                // Set other fields as necessary
                return paciente;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar o paciente pelo CPF: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public Paciente getidPacienteByCPF(String cpf) {
        Paciente paciente = getPacienteByCPF(cpf);

        if (paciente != null) {
            final String sqlSelect = "SELECT * FROM paciente WHERE id_usuario = ?";

            try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
                PreparedStatement ps = connection.prepareStatement(sqlSelect);
                ps.setLong(1, paciente.getIdUsuario());
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    paciente.setIdUsuario(rs.getLong("id_paciente"));
                    // Set other fields as necessary
                    return paciente;
                }
            } catch (SQLException e) {
                System.out.println("Erro ao recuperar o paciente pelo CPF: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return null;
    }
}
