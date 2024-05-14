package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.AgendamentoDAO;
import br.com.clinicamedica.model.Agendamento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cancelar-consulta")
public class CancelarConsultaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Agendamento agendamento = new Agendamento();
        agendamento.setProntuario(req.getParameter("prontuario"));
        long consultaId = Long.parseLong(req.getParameter("consultaId"));
        agendamento.setId(consultaId);

        new AgendamentoDAO().cancelarAgendamento(agendamento);

        resp.sendRedirect("consultas.jsp");
    }
}
