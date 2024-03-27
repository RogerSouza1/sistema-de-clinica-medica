package br.com.clinicamedica.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-paciente")
public class CreatePacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pacieteNome = req.getParameter("pacienteNome");

        System.out.println("O nome do paciente eh: " + pacieteNome);

        req.getRequestDispatcher("index.html").forward(req, resp);

    }
}
