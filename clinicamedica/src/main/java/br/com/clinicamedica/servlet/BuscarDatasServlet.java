package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.MedicoDAO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/buscarDatas")
public class BuscarDatasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeMedico = req.getParameter("medico");
        MedicoDAO medicoDAO = new MedicoDAO();
        Long medicoId = medicoDAO.getIdByNome(nomeMedico); // Método para recuperar o ID pelo nome
        Set<String> datas = medicoDAO.getDatasByMedico(String.valueOf(medicoId)); // Convertendo o Long para String
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(datas));
    }
}