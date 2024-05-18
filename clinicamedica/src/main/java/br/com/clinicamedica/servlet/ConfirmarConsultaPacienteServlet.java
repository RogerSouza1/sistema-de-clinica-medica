package br.com.clinicamedica.servlet;
import br.com.clinicamedica.dao.AgendamentoDAO;
import br.com.clinicamedica.model.Agendamento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/confirmar-consulta-paciente")
public class ConfirmarConsultaPacienteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/cadastrar-agendamento");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agendamentoId = request.getParameter("id_agendamento");


        if (agendamentoId != null) {
            Agendamento agendamento = new Agendamento();
            agendamento.setId(Long.parseLong(agendamentoId));
            agendamento.setConfirmado(true);

            new AgendamentoDAO().confirmarAgendamento(agendamento);

            response.sendRedirect("/consultas");
        } else {
            response.sendRedirect("/cadastrar-agendamento");
        }
    }
}