package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.ClinicaDAO;
import br.com.clinicamedica.model.Clinica;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BuscarClinicasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String especialidade = req.getParameter("especialidade");
        ClinicaDAO clinicaDAO = new ClinicaDAO();
        List<Clinica> clinicas = clinicaDAO.getClinicasByEspecialidade(especialidade);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(clinicas));
    }
}