package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.AgendamentoDAO;
import br.com.clinicamedica.model.Agendamento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cancelar-consulta-paciente")
public class CancelarConsultaPacienteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/cadastrar-agendamento");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String agendamentoId = request.getParameter("id_agendamento");

        if (agendamentoId != null) {
            Agendamento agendamento = new Agendamento();
            agendamento.setId(Long.parseLong(agendamentoId));
            agendamento.setCancelado(true);

            new AgendamentoDAO().cancelarAgendamento(agendamento);

            response.sendRedirect("/consultas");
        } else {
            response.sendRedirect("/cadastrar-agendamento");
        }
    }



}