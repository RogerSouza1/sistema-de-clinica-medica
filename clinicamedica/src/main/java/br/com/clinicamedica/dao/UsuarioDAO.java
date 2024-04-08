package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Horario;
import br.com.clinicamedica.model.Medico;
import br.com.clinicamedica.model.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class UsuarioDAO {

    private boolean validarUsuario(String email, String cpf) {
        return true;
    }

    public void redefinicaoSenha(String novaSenha, String email, String cpf) {

        if (validarUsuario(email, cpf)) {

        } else {

        }
    }

    public HashMap<String, Boolean> realizarLogin(String CPF, String senha){

        // Verificar se o usuário é um paciente ou médico = String (isPaciente, isMedico)
        // Verificar se o cadastro é válido = Boolean (true, false)

        return new HashMap<>();
    }

    public void cadastrarUsuario(Paciente paciente) {
        final String sqlEndereco = "INSERT INTO endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?)";
        final String sqlUsuario = "INSERT INTO usuario (nome, email, senha, cpf, dataNascimento, telefone, idEndereco, isPaciente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        final String sqlPaciente = "INSERT INTO paciente (id_usuario, dependente) VALUES (?, ?)";

        final String url = "jdbc:h2:~/test";
        final String usuario = "sa";
        final String senha = "sa";

        try {
            // Cadastrar endereço
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Sucesso ao conectar no banco de dados");

            PreparedStatement psEndereco = connection.prepareStatement(sqlEndereco);

            psEndereco.setString(1, paciente.getEndereco().getLogradouro());
            psEndereco.setInt(2, paciente.getEndereco().getNumero());
            psEndereco.setString(3, paciente.getEndereco().getBairro());
            psEndereco.setString(4, paciente.getEndereco().getCidade());
            psEndereco.setString(5, paciente.getEndereco().getEstado());
            psEndereco.setString(6, paciente.getEndereco().getCep());

            psEndereco.execute();
            System.out.println("Endereço cadastrado com sucesso");

            ResultSet rs = psEndereco.getGeneratedKeys();
            Long idEndereco = null;
            if (rs.next()) {
                idEndereco = rs.getLong(1);
            }

            psEndereco.close();

            //Inserir um Usuário
            PreparedStatement psUsuario = connection.prepareStatement(sqlUsuario);


            psUsuario.setString(1, paciente.getNome());
            psUsuario.setString(2, paciente.getEmail());
            psUsuario.setString(3, paciente.getSenha());
            psUsuario.setString(4, paciente.getCpf());
            psUsuario.setString(5, paciente.getDataNascimento());
            psUsuario.setString(6, paciente.getTelefone());
            psUsuario.setLong(7, idEndereco);
            psUsuario.setBoolean(8, true);

            psUsuario.execute();
            System.out.println("Usuário cadastrado com sucesso");

            ResultSet rsUsuario = psUsuario.getGeneratedKeys();
            Long idUsuario = null;
            if (rsUsuario.next()) {
                idUsuario = rsUsuario.getLong(1);
            }
            psUsuario.close();

            // Inserir um Paciente
            PreparedStatement psPaciente = connection.prepareStatement(sqlPaciente);
            psPaciente.setLong(1, idUsuario);
            psPaciente.setInt(2, paciente.getDependentes());

            psPaciente.execute();
            System.out.println("Paciente cadastrado com sucesso");

            psPaciente.close();

        } catch (Exception e) {
            System.out.println("Erro ao inserir dados no Banco: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cadastrarUsuario(Medico medico) {
        final String sqlEndereco = "INSERT INTO endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?)";
        final String sqlUsuario = "INSERT INTO usuario (nome, email, senha, cpf, dataNascimento, telefone, idEndereco, isPaciente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        final String sqlMedico = "INSERT INTO medico (id_usuario, especialidade, crm, clinica) VALUES (?, ?, ?, ?)";

        final String url = "jdbc:h2:~/test";
        final String usuario = "sa";
        final String senha = "sa";

        try {
            // Cadastrar endereço
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Sucesso ao conectar no banco de dados");

            PreparedStatement psEndereco = connection.prepareStatement(sqlEndereco);

            psEndereco.setString(1, medico.getEndereco().getLogradouro());
            psEndereco.setInt(2, medico.getEndereco().getNumero());
            psEndereco.setString(3, medico.getEndereco().getBairro());
            psEndereco.setString(4, medico.getEndereco().getCidade());
            psEndereco.setString(5, medico.getEndereco().getEstado());
            psEndereco.setString(6, medico.getEndereco().getCep());

            psEndereco.execute();
            System.out.println("Endereço cadastrado com sucesso");

            ResultSet rs = psEndereco.getGeneratedKeys();
            Long idEndereco = null;
            if (rs.next()) {
                idEndereco = rs.getLong(1);
            }

            psEndereco.close();

            //Inserir um Usuário
            PreparedStatement psUsuario = connection.prepareStatement(sqlUsuario);

            psUsuario.setString(1, medico.getNome());
            psUsuario.setString(2, medico.getEmail());
            psUsuario.setString(3, medico.getSenha());
            psUsuario.setString(4, medico.getCpf());
            psUsuario.setString(5, medico.getDataNascimento());
            psUsuario.setString(6, medico.getTelefone());
            psUsuario.setLong(7, idEndereco);
            psUsuario.setBoolean(8, false);

            psUsuario.execute();
            System.out.println("Usuário cadastrado com sucesso");

            ResultSet rsUsuario = psUsuario.getGeneratedKeys();
            Long idUsuario = null;

            if (rsUsuario.next()) {
                idUsuario = rsUsuario.getLong(1);
            }
            psUsuario.close();

            // Inserir um Médico
            PreparedStatement psMedico = connection.prepareStatement(sqlMedico);
            psMedico.setLong(1, idUsuario);
            psMedico.setString(2, medico.getEspecialidade());
            psMedico.setString(3, medico.getCrm());
            psMedico.setString(4, medico.getClinica());

            psMedico.execute();
            System.out.println("Médico cadastrado com sucesso");

            psMedico.close();

        } catch (Exception e) {
            System.out.println("Erro ao inserir dados no Banco: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void atualizarUsuario(Paciente paciente) {

    }

    public void atualizarUsuario(Medico medico) {

    }

    public void deletarUsuario(Paciente paciente) {

    }

    public void deletarUsuario(Medico medico) {

    }

    public List<String> buscarEspecialidades() {
        return Collections.emptyList();
    }

    public List<String> buscarClinicas(String especialidade) {
        return Collections.emptyList();
    }

    public List<Medico> buscarMedicos(String especialidade, String clinica) {
        return Collections.emptyList();
    }

    public List<Horario> buscarHorario(String data, Medico medico) {
        return Collections.emptyList();
    }

}

