package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MedicoDAO {
    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";

    public Medico getMedicoByCPF(String cpf) {
        final String sqlSelect = "SELECT u.*, m.id_medico FROM usuario u LEFT JOIN medico m ON u.id_usuario = m.id_usuario WHERE u.cpf = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Medico medico = new Medico();
                medico.setNome(rs.getString("nome"));
                medico.setCpf(rs.getLong("cpf"));
                medico.setSenha(rs.getString("senha"));
                medico.setTelefone(rs.getLong("telefone"));

                long enderecoId = rs.getLong("id_endereco");
                Endereco endereco = new EnderecoDAO().getEnderecoById(enderecoId);
                medico.setEndereco(endereco);

                // Se houver um ID de médico, define-o
                if (rs.getLong("id_medico") != 0) {
                    medico.setId(rs.getLong("id_medico"));
                }

                return medico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar o médico pelo CPF: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public boolean atualizarMedico(Medico medico, String cpf) {
        final String sqlUpdateEndereco = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id_endereco = ?";
        final String sqlUpdateUsuario = "UPDATE usuario SET nome = ?, email = ?, senha = ?, telefone = ?, id_endereco = ? WHERE cpf = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Sucesso ao conectar ao banco de dados");

            PreparedStatement psEndereco = connection.prepareStatement(sqlUpdateEndereco);
            psEndereco.setString(1, medico.getEndereco().getLogradouro());
            psEndereco.setInt(2, medico.getEndereco().getNumero());
            psEndereco.setString(3, medico.getEndereco().getBairro());
            psEndereco.setString(4, medico.getEndereco().getCidade());
            psEndereco.setString(5, medico.getEndereco().getEstado());
            psEndereco.setString(6, medico.getEndereco().getCep());
            psEndereco.setLong(7, medico.getEndereco().getId());
            psEndereco.executeUpdate();
            System.out.println("Endereço Atualizado");

            PreparedStatement ps = connection.prepareStatement(sqlUpdateUsuario);
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getEmail());
            ps.setString(3, medico.getSenha());
            ps.setLong(4, medico.getTelefone());
            ps.setLong(5, medico.getEndereco().getId());
            ps.setLong(6, Long.parseLong(cpf));
            ps.executeUpdate();
            System.out.println("Médico Atualizado");

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o médico: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Medico getMedicoByNome(String nomeMedico) {
        final String sqlSelect = "SELECT m.id_medico, u.id_usuario " +
                "FROM Medico m " +
                "JOIN Usuario u ON m.id_usuario = u.id_usuario " +
                "WHERE u.nome = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement ps = connection.prepareStatement(sqlSelect)) {
            ps.setString(1, nomeMedico);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getLong("id_medico"));
                // Preencher outros campos, se necessário
                return medico;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar o médico pelo nome: " + e.getMessage());
            e.printStackTrace();
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
                "WHERE m.id_medico = ? AND d.data = ? AND d.disponivel = TRUE"; // Adicionando a condição de disponibilidade

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
            System.out.println("Erro ao recuperar os horários disponíveis: " + e.getMessage());
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
