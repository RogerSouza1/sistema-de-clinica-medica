package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Medico;
import java.sql.*;

public class MedicoDAO {
    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";

    public Medico getMedicoByCPF(String cpf) {
        new MedicoDAO();
        final String sqlSelect = "SELECT * FROM usuario WHERE cpf = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Medico medico = new Medico();
                medico.setIdUsuario(rs.getLong("id_usuario"));
                medico.setNome(rs.getString("nome"));
                medico.setCpf(rs.getLong("cpf"));
                medico.setSenha(rs.getString("senha"));
                medico.setTelefone(rs.getLong("telefone"));

                long enderecoId = rs.getLong("id_endereco");
                Endereco endereco =  new EnderecoDAO().getEnderecoById(enderecoId);
                medico.setEndereco(endereco);

                return medico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar o médico pelo CPF: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
    public boolean atualizarMedico(Medico medico, String cpf) {
        new MedicoDAO();
        final String sqlUpdateEndereco = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id_endereco = ?";
        final String sqlUpdateUsuario = "UPDATE usuario SET nome = ?, senha = ?, telefone = ?, id_endereco = ? WHERE cpf = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Sucesso ao conectar ao banco de dados");

            PreparedStatement psEndereco = connection.prepareStatement(sqlUpdateEndereco);
            psEndereco.setString(1, medico.getEndereco().getLogradouro());
            psEndereco.setInt(2, medico.getEndereco().getNumero());
            psEndereco.setString(3, medico.getEndereco().getBairro());
            psEndereco.setString(4, medico.getEndereco().getCidade());
            psEndereco.setString(5, medico.getEndereco().getEstado());
            psEndereco.setString(6, medico.getEndereco().getCep());
            psEndereco.setLong(7, medico.getEndereco().getId_endereco());
            psEndereco.executeUpdate();
            System.out.println("Endereço Atualizado");

            PreparedStatement ps = connection.prepareStatement(sqlUpdateUsuario);
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getSenha());
            ps.setLong(3, medico.getTelefone());
            ps.setLong(4, medico.getEndereco().getId_endereco());
            ps.setLong(5, Long.parseLong(cpf));
            ps.executeUpdate();
            System.out.println("Médico Atualizado");

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o médico: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
