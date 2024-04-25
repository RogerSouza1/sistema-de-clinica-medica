package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Medico;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDAO {
    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";

    public Medico getMedicoLogado(HttpSession session) {
        Long idMedicoLogado = (Long) session.getAttribute("idMedicoLogado");
        if (idMedicoLogado == null) {
            return null;
        }

        final String sqlSelect = "SELECT * FROM medico WHERE id_medico = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setLong(1, idMedicoLogado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getLong("id_medico"));
                medico.setCrm(rs.getString("crm"));
                // Set other fields as necessary
                return medico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar o médico logado: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}