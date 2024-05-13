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

        // Colocar nesse agendamento, o ID do agendamento, juntamente com o prontuário para o método fazer a atualização
        // Tem que pegar o jsp e colocar no agendamento.

        new AgendamentoDAO().cancelarAgendamento(agendamento);

        resp.sendRedirect("consultas.jsp");
    }
}
