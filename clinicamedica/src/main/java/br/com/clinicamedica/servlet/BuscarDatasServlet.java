package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.MedicoDAO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BuscarDatasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String medicoId = req.getParameter("medicoId");
        MedicoDAO medicoDAO = new MedicoDAO();
        List<String> datas = medicoDAO.getDatasByMedico(medicoId);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(datas));
    }
}