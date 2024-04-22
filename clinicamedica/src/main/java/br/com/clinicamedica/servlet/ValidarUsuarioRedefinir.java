package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.UsuarioDAO;
import br.com.clinicamedica.dao.ValidarRedefinir;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/validar-redefinir-senha")
public class ValidarUsuarioRedefinir extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("validacao-email");
        String cpf = req.getParameter("validacao-cpf");

        ValidarRedefinir validacao = new UsuarioDAO().validarRedefinir(email, cpf);

        if (validacao.getIsValido()) {
            // Armazenar o CPF na sessão
            req.getSession().setAttribute("cpf", cpf);

            req.getRequestDispatcher("redefinicaoSenha.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("esqueciSenha.html").forward(req, resp);
        }
    }
}
