package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Medico;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Medico getMedicoByCPF(String cpf) {
        final String sqlSelect = "SELECT * FROM usuario WHERE cpf = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getLong("id_usuario"));
                medico.setCpf(rs.getLong("cpf"));
                // Set other fields as necessary
                return medico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar o médico pelo CPF: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public Medico getidMedicoByCPF(String cpf) {
        Medico medico = getMedicoByCPF(cpf); // Reutilize a função para buscar o id_usuario

        if (medico != null) {
            final String sqlSelect = "SELECT * FROM medico WHERE id_usuario = ?";

            try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
                PreparedStatement ps = connection.prepareStatement(sqlSelect);
                ps.setLong(1, medico.getId()); // Use o id_usuario retornado pela primeira função
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    medico.setId(rs.getLong("id_medico"));
                    // Set other fields as necessary
                    return medico;
                }
            } catch (SQLException e) {
                System.out.println("Erro ao recuperar o médico pelo CPF: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return null;
    }

    public List<Medico> getMedicosByClinicaAndEspecialidade(String clinicaNome, String especialidadeNome) {
        List<Medico> medicos = new ArrayList<>();
        final String sqlSelect = "SELECT m.id_medico, u.nome " +
                "FROM Medico m " +
                "JOIN Clinica c ON m.id_clinica = c.id_clinica " +
                "JOIN Especialidade e ON m.id_especialidade = e.id_especialidade " +
                "JOIN Usuario u ON m.id_usuario = u.id_usuario " +
                "WHERE c.nome_clinica = ? AND e.nome_especialidade = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, clinicaNome);
            ps.setString(2, especialidadeNome);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getLong("id_medico")); // Define o ID do médico
                medico.setNome(rs.getString("nome")); // Define o nome do médico
                medicos.add(medico);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar os médicos: " + e.getMessage());
            e.printStackTrace();
        }

        return medicos;
    }

    public Set<String> getDatasByMedico(String medicoId) {
        Set<String> datas = new HashSet<>(); // Usando um conjunto para manter apenas valores únicos
        final String sqlSelect = "SELECT DISTINCT d.data FROM Disponibilidade d " +
                "JOIN Medico m ON d.id_medico = m.id_medico " +
                "WHERE m.id_medico = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, medicoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String data = rs.getString("data");
                datas.add(data); // Adicionando a data ao conjunto
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar as datas: " + e.getMessage());
            e.printStackTrace();
        }

        return datas;
    }

    public List<String> getHorariosByMedicoAndData(String medicoId, String data) {
        List<String> horarios = new ArrayList<>();
        final String sqlSelect = "SELECT h.horario FROM Disponibilidade d " +
                "JOIN Medico m ON d.id_medico = m.id_medico " +
                "JOIN Horarios h ON d.id_horarios = h.id_horarios " +
                "WHERE m.id_medico = ? AND d.data = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setLong(1, Long.parseLong(medicoId)); // Convertendo String para Long
            ps.setString(2, data);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String horario = rs.getString("horario");
                horarios.add(horario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar os horários: " + e.getMessage());
            e.printStackTrace();
        }

        return horarios;
    }

    public Long getIdByNome(String nomeMedico) {
        Long idMedico = null;
        final String sqlSelect = "SELECT id_medico FROM Medico m " +
                "JOIN Usuario u ON m.id_usuario = u.id_usuario " +
                "WHERE u.nome = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, nomeMedico);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idMedico = rs.getLong("id_medico");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar o ID do médico pelo nome: " + e.getMessage());
            e.printStackTrace();
        }

        return idMedico;
    }
}