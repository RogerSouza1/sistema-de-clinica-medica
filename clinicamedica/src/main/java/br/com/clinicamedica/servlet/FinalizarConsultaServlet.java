package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.AgendamentoDAO;
import br.com.clinicamedica.model.Agendamento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/finalizar-consulta")
public class FinalizarConsultaServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Agendamento agendamento = new Agendamento();
        //colocar aqui o id do agendamento que está sendo finalizado que será buscado no jsps e mandar para a função

        new AgendamentoDAO().finalizarAgendamento(agendamento);

        resp.sendRedirect("consultas.jsp");
    }
}
