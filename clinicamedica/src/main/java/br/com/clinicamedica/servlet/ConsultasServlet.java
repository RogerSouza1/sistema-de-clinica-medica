package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.AgendamentoDAO;
import br.com.clinicamedica.model.Agendamento;
import br.com.clinicamedica.model.Paciente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/consultas")
public class ConsultasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Paciente paciente = (Paciente) request.getSession().getAttribute("pacienteLogado");
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        List<Agendamento> minhasConsultas = agendamentoDAO.buscarAgendamentos(paciente);
        request.setAttribute("minhasConsultas", minhasConsultas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/consultas.jsp");
        dispatcher.forward(request, response);
    }
}