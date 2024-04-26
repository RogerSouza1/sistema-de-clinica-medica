package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.UsuarioDAO;
import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Medico;
import br.com.clinicamedica.dao.EspecialidadeDAO;
import br.com.clinicamedica.model.Especialidade;
import br.com.clinicamedica.dao.ClinicaDAO;
import br.com.clinicamedica.model.Clinica;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/cadastrar-medico")
public class CreateMedicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Medico medico = new Medico();
        Endereco endereco = new Endereco();

        medico.setPaciente(false);

        endereco.setLogradouro(req.getParameter("medico-logradouro"));
        endereco.setNumero(Integer.parseInt(req.getParameter("medico-numero")));
        endereco.setBairro(req.getParameter("medico-bairro"));
        endereco.setCidade(req.getParameter("medico-cidade"));
        endereco.setEstado(req.getParameter("medico-estado"));
        endereco.setCep(req.getParameter("medico-cep"));

        medico.setNome(req.getParameter("medico-nome"));
        medico.setCpf(Long.parseLong(req.getParameter("medico-cpf").replaceAll("[^0-9]", "")));
        medico.setEmail(req.getParameter("medico-email"));
        medico.setSenha(req.getParameter("medico-senha"));
        medico.setDataNascimento(req.getParameter("medico-data-nascimento"));
        medico.setTelefone(Long.parseLong(req.getParameter("medico-telefone").replaceAll("[^0-9]", "")));

        medico.setEndereco(endereco);

        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        Especialidade especialidade = especialidadeDAO.getEspecialidadeByName(req.getParameter("medico-especialidade"));
        medico.setEspecialidade(especialidade);

        medico.setCrm(req.getParameter("medico-crm"));

        ClinicaDAO clinicaDAO = new ClinicaDAO();
        Clinica clinica = clinicaDAO.getClinicaByName(req.getParameter("medico-clinica"));
        medico.setClinica(clinica);

        new UsuarioDAO().cadastrarUsuario(medico);

        req.getRequestDispatcher("login.html").forward(req, resp);
    }
}
