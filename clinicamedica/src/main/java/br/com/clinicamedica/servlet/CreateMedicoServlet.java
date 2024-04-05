package br.com.clinicamedica.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create-medico")
public class CreateMedicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("medico-nome");
        int cpf = Integer.parseInt(req.getParameter("medico-cpf"));
        String email = req.getParameter("medico-email");
        String senha = req.getParameter("medico-senha");
        String dataNascimentoStr = req.getParameter("medico-dataNascimento");
        String telefone = req.getParameter("medico-telefone");

        String logradouro = req.getParameter("medico-logradouro");
        int numero = Integer.parseInt(req.getParameter("medico-numero"));
        String complemento = req.getParameter("medico-complemento");
        String bairro = req.getParameter("medico-bairro");
        String cidade = req.getParameter("medico-cidade");
        String estado = req.getParameter("medico-estado");
        String cep = req.getParameter("medico-cep");

        int crm = Integer.parseInt(req.getParameter("medico-crm"));
        String especialidade = req.getParameter("medico-especialidade");
        String clinica = req.getParameter("medico-clinica");

        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
