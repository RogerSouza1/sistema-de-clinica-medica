package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.ClinicaDAO;
import br.com.clinicamedica.dao.EspecialidadeDAO;
import br.com.clinicamedica.dao.MedicoDAO;
import br.com.clinicamedica.model.Clinica;
import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Especialidade;
import br.com.clinicamedica.model.Medico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/alterar-dados-medico")
public class AlterarDadosMedicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperar o médico logado
        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = (Medico) req.getSession().getAttribute("medicoLogado");
        Medico novoMedico = new Medico();

        // Recuperar os dados do formulário
        novoMedico.setId(medico.getId());
        novoMedico.setNome(req.getParameter("alterar-medico-nome"));
        novoMedico.setCpf(medico.getCpf());
        Especialidade especialidade = new EspecialidadeDAO().getEspecialidadeByName(req.getParameter("alterar-medico-especialidade"));
        novoMedico.setEspecialidade(especialidade);
        Clinica clinica = new ClinicaDAO().getClinicaByName(req.getParameter("alterar-medico-clinica"));
        novoMedico.setClinica(clinica);


        novoMedico.setEmail(req.getParameter("alterar-medico-email"));
        novoMedico.setSenha(req.getParameter("alterar-medico-senha"));

        novoMedico.setDataNascimento(medico.getDataNascimento());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(req.getParameter("alterar-medico-logradouro"));
        endereco.setNumero(Integer.parseInt(req.getParameter("alterar-medico-numero")));
        endereco.setBairro(req.getParameter("alterar-medico-bairro"));
        endereco.setCidade(req.getParameter("alterar-medico-cidade"));
        endereco.setEstado(req.getParameter("alterar-medico-estado"));
        endereco.setCep(req.getParameter("alterar-medico-cep"));

        novoMedico.setEndereco(endereco);

        medicoDAO.atualizarMedico(medico);

        req.getRequestDispatcher("perfil-medico.jsp").forward(req, resp);
    }
}
