package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.MedicoDAO;
import br.com.clinicamedica.dao.UsuarioDAO;
import br.com.clinicamedica.dao.ValidarLogin;
import br.com.clinicamedica.model.Medico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/validar-login")
public class ValidarUsuarioLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("login-cpf");
        String senha = req.getParameter("login-senha");

        ValidarLogin validacao = new UsuarioDAO().validarLogin(cpf, senha);

        if (validacao.getIsValido()) {
            if (validacao.getIsPaciente()) {
                req.getRequestDispatcher("paciente/consultas.html").forward(req, resp);
            } else {
                Medico medico = new MedicoDAO().getidMedicoByCPF(cpf);
                req.getSession().setAttribute("medicoLogado", medico);
                req.getRequestDispatcher("medico/horarios.html").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("login.html").forward(req, resp);
        }
    }
}
