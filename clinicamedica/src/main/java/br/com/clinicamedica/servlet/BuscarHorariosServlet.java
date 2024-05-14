package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.MedicoDAO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/buscarHorarios")
public class BuscarHorariosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeMedico = req.getParameter("medico");
        String data = req.getParameter("data");
        MedicoDAO medicoDAO = new MedicoDAO();
        Long medicoId = medicoDAO.getIdByNome(nomeMedico);

        List<String> horarios = medicoDAO.getHorariosByMedicoAndData(String.valueOf(medicoId), data);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(horarios));
    }
}