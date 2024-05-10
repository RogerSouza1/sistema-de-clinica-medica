package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Endereco;
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
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getLong("cpf"));
                paciente.setSenha(rs.getString("senha"));
                paciente.setTelefone(rs.getLong("telefone"));

                long enderecoId = rs.getLong("id_endereco");
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                Endereco endereco = enderecoDAO.getEnderecoById(enderecoId);
                paciente.setEndereco(endereco);

                return paciente;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar o paciente pelo CPF: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
