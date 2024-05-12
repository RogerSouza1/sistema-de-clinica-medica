package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.AgendamentoDAO;
import br.com.clinicamedica.model.Agendamento;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ConsultaServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
    List<Agendamento> consultasDoDia = agendamentoDAO.buscarConsultasDoDia();
    request.setAttribute("consultasDoDia", consultasDoDia);
    request.getRequestDispatcher("/medico/calendario.jsp").forward(request, response);
}
}
