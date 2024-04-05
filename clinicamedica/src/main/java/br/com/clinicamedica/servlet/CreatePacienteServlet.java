package br.com.clinicamedica.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create-paciente")
public class CreatePacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("paciente-nome");
        int cpf = Integer.parseInt(req.getParameter("paciente-cpf"));
        String email = req.getParameter("paciente-email");
        String senha = req.getParameter("paciente-senha");
        String dataNascimentoStr = req.getParameter("paciente-dataNascimento");
        String telefone = req.getParameter("paciente-telefone");

        String logradouro = req.getParameter("paciente-logradouro");
        int numero = Integer.parseInt(req.getParameter("paciente-numero"));
        String complemento = req.getParameter("paciente-complemento");
        String bairro = req.getParameter("paciente-bairro");
        String cidade = req.getParameter("paciente-cidade");
        String estado = req.getParameter("paciente-estado");
        String cep = req.getParameter("paciente-cep");

        int dependentes = Integer.parseInt(req.getParameter("paciente-dependentes"));

        req.getRequestDispatcher("index.html").forward(req, resp);

    }
}
