package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.ClinicaDAO;
import br.com.clinicamedica.model.Clinica;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/buscarClinicas")
public class BuscarClinicasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String especialidade = req.getParameter("especialidade");
        ClinicaDAO clinicaDAO = new ClinicaDAO();
        List<Clinica> clinicas = clinicaDAO.getClinicasByEspecialidade(especialidade);

        // Definindo o tipo de conteúdo como JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Escrevendo a lista de clínicas em formato JSON na resposta
        resp.getWriter().write(new Gson().toJson(clinicas));
    }
}