package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Horario;
import br.com.clinicamedica.model.Medico;
import br.com.clinicamedica.model.Paciente;

import java.sql.*;
import java.util.Collections;
import java.util.List;


public class UsuarioDAO {

    final String url = "jdbc:h2:~/test";
    final String usuario = "sa";
    final String senha = "sa";

    private boolean validarUsuario(String cpf) {
        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Sucesso ao conectar no banco de dados");

            final String sql = "SELECT cpf FROM usuario WHERE cpf = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return true;
            }

            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ValidarLogin validarLogin(String cpfLogin, String senhaLogin) {

        boolean isPaciente = false;
        boolean isValido = false;

        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Sucesso ao conectar no banco de dados");

            final String sql = "SELECT paciente FROM usuario WHERE cpf = ? AND senha = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpfLogin);
            ps.setString(2, senhaLogin);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                isPaciente = resultSet.getBoolean("paciente");
                isValido = true;
            }

            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Usuário válido para login: " + isValido);
        System.out.println("Usuário é paciente: " + isPaciente);

        return new ValidarLogin(isValido, isPaciente);
    }
    public ValidarRedefinir validarRedefinir(String email, String cpf) {
        boolean isValido = false;

        try{
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Sucesso ao conectar no banco de dados");

            final String sql = "SELECT * FROM usuario WHERE email = ? AND cpf = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, cpf);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()){
                isValido = true;
            }
            ps.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Usuário validado para redefinição de senha: " + isValido);

        return new ValidarRedefinir(isValido);
    }
    public boolean redefinicaoSenha(String cpf, String novaSenha) {

        if (validarUsuario(cpf)) {
            try {
                Connection connection = DriverManager.getConnection(url, usuario, senha);
                System.out.println("Sucesso ao conectar no banco de dados");

                final String sql = "UPDATE usuario SET senha = ? WHERE cpf = ?";

                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, novaSenha);
                ps.setString(2, cpf);

                ps.execute();

                ps.close();
                connection.close();

                System.out.println("Senha redefinida com sucesso");
                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Usuário não encontrado");
        }
        return false;
    }

    public void cadastrarUsuario(Medico medico) {
        final String sqlEndereco = "INSERT INTO endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?)";
        final String sqlUsuario = "INSERT INTO usuario (nome, email, senha, cpf, data_nascimento, telefone, id_endereco, paciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        final String sqlMedico = "INSERT INTO medico (id_usuario, especialidade, crm, clinica) VALUES (?, ?, ?, ?)";


        try {

            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Sucesso ao conectar no banco de dados");

            if (dadosExiste(medico.getCpf())){
                System.out.println("CPF já cadastrado");
                return;
            }
            if(dadosExiste(medico.getEmail())){
                System.out.println("Email já cadastrado");
                return;
            }

            // Cadastrar endereço
            PreparedStatement psEndereco = connection.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);

            int cep = Integer.parseInt(medico.getEndereco().getCep().replace("-", ""));

            psEndereco.setString(1, medico.getEndereco().getLogradouro());
            psEndereco.setInt(2, medico.getEndereco().getNumero());
            psEndereco.setString(3, medico.getEndereco().getBairro());
            psEndereco.setString(4, medico.getEndereco().getCidade());
            psEndereco.setString(5, medico.getEndereco().getEstado());
            psEndereco.setInt(6, cep);

            psEndereco.execute();

            ResultSet enderecoGeneratedKeys = psEndereco.getGeneratedKeys();

            Long id_endereco = null;

            while (enderecoGeneratedKeys.next()) {
                id_endereco = enderecoGeneratedKeys.getLong(1);
                System.out.println("ID do endereço: " + id_endereco);
            }

            psEndereco.close();

            System.out.println("Endereço cadastrado com sucesso");

            //Inserir um Usuário
            PreparedStatement psUsuario = connection.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);



            psUsuario.setString(1, medico.getNome());
            psUsuario.setString(2, medico.getEmail());
            psUsuario.setString(3, medico.getSenha());
            psUsuario.setLong(4, medico.getCpf());
            psUsuario.setString(5, medico.getDataNascimento());
            psUsuario.setLong(6, medico.getTelefone());
            psUsuario.setLong(7, id_endereco);
            psUsuario.setBoolean(8, false);

            psUsuario.execute();

            ResultSet usuarioGeneratedKeys = psUsuario.getGeneratedKeys();
            Long id_usuario = null;

            if (usuarioGeneratedKeys.next()) {
                id_usuario = usuarioGeneratedKeys.getLong(1);
                System.out.println("ID do usuário: " + id_usuario);
            }
            psUsuario.close();

            System.out.println("Usuário cadastrado com sucesso");

            // Inserir um Médico
            PreparedStatement psMedico = connection.prepareStatement(sqlMedico, Statement.RETURN_GENERATED_KEYS);
            psMedico.setLong(1, id_usuario);
            psMedico.setString(2, medico.getEspecialidade());
            psMedico.setString(3, medico.getCrm());
            psMedico.setString(4, medico.getClinica());

            psMedico.execute();

            ResultSet psMedicoGeneratedKeys = psMedico.getGeneratedKeys();

            Long id_medico;

            if (psMedicoGeneratedKeys.next()) {
                id_medico = psMedicoGeneratedKeys.getLong(1);
                System.out.println("ID do médico: " + id_medico);
            }

            System.out.println("Médico cadastrado com sucesso");

            psMedico.close();

        } catch (Exception e) {
            System.out.println("Erro ao inserir dados no Banco: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cadastrarUsuario(Paciente paciente) {
        final String sqlEndereco = "INSERT INTO endereco (logradouro, numero, bairro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?)";
        final String sqlUsuario = "INSERT INTO usuario (nome, email, senha, cpf, data_nascimento, telefone, id_endereco, paciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        final String sqlPaciente = "INSERT INTO paciente (id_usuario, dependentes) VALUES (?, ?)";


        try {

            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Sucesso ao conectar no banco de dados");

            if (dadosExiste(paciente.getCpf())){
                System.out.println("CPF já cadastrado");
                return;
            }
            if(dadosExiste(paciente.getEmail())){
                System.out.println("Email já cadastrado");
                return;
            }

            // Cadastrar endereço

            PreparedStatement psEndereco = connection.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);

            int cep = Integer.parseInt(paciente.getEndereco().getCep().replace("-", ""));

            psEndereco.setString(1, paciente.getEndereco().getLogradouro());
            psEndereco.setInt(2, paciente.getEndereco().getNumero());
            psEndereco.setString(3, paciente.getEndereco().getBairro());
            psEndereco.setString(4, paciente.getEndereco().getCidade());
            psEndereco.setString(5, paciente.getEndereco().getEstado());
            psEndereco.setInt(6, cep);

            psEndereco.execute();

            ResultSet enderecoGeneratedKeys = psEndereco.getGeneratedKeys();

            Long id_endereco = null;

            while (enderecoGeneratedKeys.next()) {
                id_endereco = enderecoGeneratedKeys.getLong(1);
                System.out.println("ID do endereço: " + id_endereco);
            }

            psEndereco.close();

            System.out.println("Endereço cadastrado com sucesso");

            //Inserir um Usuário
            PreparedStatement psUsuario = connection.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);



            psUsuario.setString(1, paciente.getNome());
            psUsuario.setString(2, paciente.getEmail());
            psUsuario.setString(3, paciente.getSenha());
            psUsuario.setLong(4, paciente.getCpf());
            psUsuario.setString(5, paciente.getDataNascimento());
            psUsuario.setLong(6, paciente.getTelefone());
            psUsuario.setLong(7, id_endereco);
            psUsuario.setBoolean(8, true);

            psUsuario.execute();

            ResultSet usuarioGeneratedKeys = psUsuario.getGeneratedKeys();
            Long id_usuario = null;

            if (usuarioGeneratedKeys.next()) {
                id_usuario = usuarioGeneratedKeys.getLong(1);
                System.out.println("ID do usuário: " + id_usuario);
            }
            psUsuario.close();

            System.out.println("Usuário cadastrado com sucesso");

            // Inserir um Médico
            PreparedStatement psPaciente = connection.prepareStatement(sqlPaciente, Statement.RETURN_GENERATED_KEYS);
            psPaciente.setLong(1, id_usuario);
            psPaciente.setInt(2, paciente.getDependentes());

            psPaciente.execute();

            ResultSet psPacienteGeneratedKeys = psPaciente.getGeneratedKeys();
            Long id_paciente;

            if (psPacienteGeneratedKeys.next()) {
                id_paciente = psPacienteGeneratedKeys.getLong(1);
                System.out.println("ID do paciente: " + id_paciente);
            }

            System.out.println("Paciente cadastrado com sucesso");

            psPaciente.close();

        } catch (Exception e) {
            System.out.println("Erro ao inserir dados no Banco: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean dadosExiste(Long cpf) {

        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            final String sql = "SELECT cpf FROM usuario WHERE cpf = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, cpf);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

            ps.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    private boolean dadosExiste(String email) {

        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            final String sql = "SELECT email FROM usuario WHERE email = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

            ps.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
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

