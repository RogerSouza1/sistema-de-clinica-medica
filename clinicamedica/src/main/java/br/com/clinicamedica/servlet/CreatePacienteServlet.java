package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.UsuarioDAO;
import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Paciente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastar-paciente")
public class CreatePacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Paciente paciente = new Paciente();
        Endereco endereco = new Endereco();

        paciente.setPaciente(true);

        endereco.setLogradouro(req.getParameter("logradouro-paciente"));
        endereco.setNumero(Integer.parseInt(req.getParameter("numero-paciente")));
        endereco.setBairro(req.getParameter("bairro-paciente"));
        endereco.setCidade(req.getParameter("cidade-paciente"));
        endereco.setEstado(req.getParameter("estado-paciente"));
        endereco.setCep(req.getParameter("cep-paciente"));

        paciente.setNome(req.getParameter("nome-paciente"));
        paciente.setCpf(req.getParameter("cpf-paciente"));
        paciente.setEmail(req.getParameter("email-paciente"));
        paciente.setSenha(req.getParameter("senha-paciente"));
        paciente.setDataNascimento(req.getParameter("data-nascimento-paciente"));
        paciente.setTelefone(req.getParameter("telefone-paciente"));
        paciente.setEndereco(endereco);

        paciente.setDependentes(Integer.parseInt(req.getParameter("depedentes-paciente")));

        new UsuarioDAO().cadastrarUsuario(paciente);

        req.getRequestDispatcher("login.html").forward(req, resp);
    }
}
