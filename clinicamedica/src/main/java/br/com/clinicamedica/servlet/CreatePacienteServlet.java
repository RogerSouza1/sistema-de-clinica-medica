package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.UsuarioDAO;
import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Paciente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastrar-paciente")
public class CreatePacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Paciente paciente = new Paciente();
        Endereco endereco = new Endereco();

        paciente.setPaciente(true);

        endereco.setLogradouro(req.getParameter("paciente-logradouro"));
        endereco.setNumero(Integer.parseInt(req.getParameter("paciente-numero")));
        endereco.setBairro(req.getParameter("paciente-bairro"));
        endereco.setCidade(req.getParameter("paciente-cidade"));
        endereco.setEstado(req.getParameter("paciente-estado"));
        endereco.setCep(req.getParameter("paciente-cep"));



        paciente.setNome(req.getParameter("paciente-nome"));
        paciente.setCpf(Long.parseLong(req.getParameter("paciente-cpf").replaceAll("[^0-9]", "")));
        paciente.setEmail(req.getParameter("paciente-email"));
        paciente.setSenha(req.getParameter("paciente-senha"));
        paciente.setDataNascimento(req.getParameter("paciente-data-nascimento"));
        paciente.setTelefone(Long.parseLong(req.getParameter("paciente-telefone").replaceAll("[^0-9]", "")));

        paciente.setEndereco(endereco);

        paciente.setDependentes(Integer.parseInt(req.getParameter("paciente-dependentes")));

        new UsuarioDAO().cadastrarUsuario(paciente);

        req.getRequestDispatcher("login.html").forward(req, resp);
    }
}
