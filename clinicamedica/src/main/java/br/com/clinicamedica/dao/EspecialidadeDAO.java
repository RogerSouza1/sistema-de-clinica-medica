package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Especialidade;
import br.com.clinicamedica.model.Clinica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EspecialidadeDAO {
    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";
    private Connection connection;

    public EspecialidadeDAO() {
        try {
            this.connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Especialidade getEspecialidadeByName(String nomeEspecialidade) {
        Especialidade especialidade = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Especialidade WHERE nome_especialidade = ?");
            stmt.setString(1, nomeEspecialidade);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                especialidade = new Especialidade();
                especialidade.setIdEspecialidade(rs.getInt("id_especialidade"));
                especialidade.setNomeEspecialidade(rs.getString("nome_especialidade"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return especialidade;
    }
}