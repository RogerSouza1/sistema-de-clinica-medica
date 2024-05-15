package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EnderecoDAO {

    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";

    public Endereco getEnderecoById(Long id){
        new EnderecoDAO();
        final String sql = "SELECT * FROM endereco WHERE id_endereco = ?";

        try(Connection connection = DriverManager.getConnection(url, usuario, senha)){
            System.out.println("Sucesso ao conectar ao banco de dados");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getLong("id_endereco"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCep(rs.getString("cep"));

                return endereco;
            }

        }catch(Exception e){
            System.out.println("Não foi possivel conectar ao banco de dados");
            e.printStackTrace();
        }
        return null;
    }


}
