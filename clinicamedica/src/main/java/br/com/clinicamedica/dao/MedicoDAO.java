package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Clinica;
import br.com.clinicamedica.model.Especialidade;
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

    public Medico getMedicoByCPF(String cpf){

        final String sqlSelectUsuario = "SELECT * FROM usuario WHERE cpf = ?";
        final String sqlSelectEndereco = "SELECT * FROM endereco WHERE id_endereco = ?";

        final String sqlSelectMedico = "SELECT * FROM medico WHERE id_usuario = ?";
        final String sqlSelectEspecialidade = "SELECT * FROM especialidade WHERE id_especialidade = ?";
        final String sqlSelectClinica = "SELECT * FROM clinica WHERE id_clinica = ?";


        try {

            Connection connection = DriverManager.getConnection(url, usuario, senha);

            PreparedStatement ps = connection.prepareStatement(sqlSelectUsuario);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            Medico medico = new Medico();
            Long id_usuario = rs.getLong("id_usuario");
            Long id_endereco = rs.getLong("id_endereco");
            medico.setNome(rs.getString("nome"));
            medico.setCpf(rs.getLong("cpf"));
            medico.setEmail(rs.getString("email"));
            medico.setSenha(rs.getString("senha"));
            medico.setDataNascimento(rs.getString("data_nascimento"));
            medico.setTelefone(rs.getLong("telefone"));
            medico.setPaciente(rs.getBoolean("paciente"));

            PreparedStatement psEndereco = connection.prepareStatement(sqlSelectEndereco);

            psEndereco.setLong(1, id_endereco);

            ResultSet rsEndereco = psEndereco.executeQuery();


            medico.getEndereco().setId_endereco(rsEndereco.getLong("id_endereco"));
            medico.getEndereco().setLogradouro(rsEndereco.getString("logradouro"));
            medico.getEndereco().setNumero(rsEndereco.getInt("numero"));
            medico.getEndereco().setBairro(rsEndereco.getString("bairro"));
            medico.getEndereco().setCidade(rsEndereco.getString("cidade"));
            medico.getEndereco().setEstado(rsEndereco.getString("estado"));
            medico.getEndereco().setCep(rsEndereco.getString("cep"));

            PreparedStatement psMedico = connection.prepareStatement(sqlSelectMedico);

            psMedico.setLong(1, id_usuario);

            ResultSet rsMedico = psMedico.executeQuery();

            medico.setId(rsMedico.getLong("id_medico"));
            medico.setIdUsuario(id_usuario);
            Long id_especialidade = rsMedico.getLong("id_especialidade");
            Long id_clinica = rsMedico.getLong("id_clinica");
            medico.setCrm(rsMedico.getString("crm"));


            PreparedStatement psEspecialidade = connection.prepareStatement(sqlSelectEspecialidade);

            psEspecialidade.setLong(1, id_especialidade);

            ResultSet rsEspecialidade = psEspecialidade.executeQuery();

            Especialidade especialidade = new Especialidade();
            especialidade.setIdEspecialidade(rsEspecialidade.getLong("id_especialidade"));
            especialidade.setNomeEspecialidade(rsEspecialidade.getString("nome_especialidade"));

            medico.setEspecialidade(especialidade);

            PreparedStatement psClinica = connection.prepareStatement(sqlSelectClinica);

            psClinica.setLong(1, id_clinica);

            ResultSet rsClinica = psClinica.executeQuery();

            Clinica clinica = new Clinica();

            clinica.setId(rsClinica.getLong("id_clinica"));
            clinica.setNome(rsClinica.getString("nome_clinica"));

            medico.setClinica(clinica);

            return medico;
        } catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    public void atualizarMedico(Medico medico) {
        final String sqlUpdateUsuario = "UPDATE usuario SET nome = ?, cpf = ?, email = ?, senha = ?, data_nascimento = ?, telefone = ? WHERE id_usuario = ?";
        final String sqlUpdateEndereco = "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id_endereco = ?";
        final String sqlUpdateMedico = "UPDATE medico SET crm = ?, id_especialidade = ?, id_clinica = ? WHERE id_medico = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement psUsuario = connection.prepareStatement(sqlUpdateUsuario);
            psUsuario.setString(1, medico.getNome());
            psUsuario.setLong(2, medico.getCpf());
            psUsuario.setString(3, medico.getEmail());
            psUsuario.setString(4, medico.getSenha());
            psUsuario.setString(5, medico.getDataNascimento());
            psUsuario.setLong(6, medico.getTelefone());
            psUsuario.setLong(7, medico.getIdUsuario());
            psUsuario.executeUpdate();

            PreparedStatement psEndereco = connection.prepareStatement(sqlUpdateEndereco);
            psEndereco.setString(1, medico.getEndereco().getLogradouro());
            psEndereco.setInt(2, medico.getEndereco().getNumero());
            psEndereco.setString(3, medico.getEndereco().getBairro());
            psEndereco.setString(4, medico.getEndereco().getCidade());
            psEndereco.setString(5, medico.getEndereco().getEstado());
            psEndereco.setString(6, medico.getEndereco().getCep());
            psEndereco.executeUpdate();

            PreparedStatement psMedico = connection.prepareStatement(sqlUpdateMedico);
            psMedico.setString(1, medico.getCrm());
            psMedico.setLong(2, medico.getEspecialidade().getIdEspecialidade());
            psMedico.setLong(3, medico.getClinica().getId());
            psMedico.setLong(4, medico.getId());
            psMedico.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o médico: " + e.getMessage());
            e.printStackTrace();
        }
    }
}