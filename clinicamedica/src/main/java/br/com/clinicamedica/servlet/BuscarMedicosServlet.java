package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.MedicoDAO;
import br.com.clinicamedica.model.Medico;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BuscarMedicosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String especialidade = req.getParameter("especialidade");
        String clinica = req.getParameter("clinica");
        MedicoDAO medicoDAO = new MedicoDAO();
        List<Medico> medicos = medicoDAO.getMedicosByClinicaAndEspecialidade(clinica, especialidade);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(medicos));
    }
}