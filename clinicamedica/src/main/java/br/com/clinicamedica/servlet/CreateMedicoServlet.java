package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.UsuarioDAO;
import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Medico;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrar-medico")
public class CreateMedicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Medico medico = new Medico();
        Endereco endereco = new Endereco();

        medico.setPaciente(false);

        endereco.setLogradouro(req.getParameter("logradouro-medico"));
        endereco.setNumero(Integer.parseInt(req.getParameter("numero-medico")));
        endereco.setBairro(req.getParameter("bairro-medico"));
        endereco.setCidade(req.getParameter("cidade-medico"));
        endereco.setEstado(req.getParameter("estado-medico"));
        endereco.setCep(req.getParameter("cep-medico"));

        medico.setNome(req.getParameter("nome-medico"));
        medico.setCpf(req.getParameter("cpf-medico"));
        medico.setEmail(req.getParameter("email-medico"));
        medico.setSenha(req.getParameter("senha-medico"));
        medico.setDataNascimento(req.getParameter("data-nascimento-medico"));
        medico.setTelefone(req.getParameter("telefone-medico"));
        medico.setEndereco(endereco);

        medico.setEspecialidade(req.getParameter("especialidade-medico"));
        medico.setCrm(req.getParameter("crm-medico"));
        medico.setClinica(req.getParameter("clinica-medico"));


        new UsuarioDAO().cadastrarUsuario(medico);

        req.getRequestDispatcher("login.html").forward(req, resp);
    }
}
