package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.*;
import br.com.clinicamedica.model.Agendamento;
import br.com.clinicamedica.model.Medico;
import br.com.clinicamedica.model.Paciente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/validar-login")
public class ValidarUsuarioLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        String cpf = req.getParameter("login-cpf");
        String senha = req.getParameter("login-senha");
        ValidarLogin validacao = new UsuarioDAO().validarLogin(cpf, senha);

        if (validacao.getIsValido()) {
            if (validacao.getIsPaciente()) {
                Paciente paciente = new PacienteDAO().getPacienteByCPF(cpf);
                req.getSession().setAttribute("pacienteLogado", paciente);

                AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
                List<Agendamento> minhasConsultas = agendamentoDAO.buscarAgendamentos(paciente);
                req.setAttribute("minhasConsultas", minhasConsultas);
                req.getRequestDispatcher("paciente/consultas.jsp").forward(req, resp);
            } else {
                Medico medico = new MedicoDAO().getMedicoByCPF(cpf);
                req.getSession().setAttribute("medicoLogado", medico);
                req.getRequestDispatcher("medico/horarios.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("loginFailed", true);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
