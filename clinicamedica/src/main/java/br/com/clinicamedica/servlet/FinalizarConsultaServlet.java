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
public class FinalizarConsultaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Agendamento agendamento = new Agendamento();

        String dadoIdStr = req.getParameter("dado-id");
        if (dadoIdStr != null && !dadoIdStr.isEmpty()) {
            long consultaId = Long.parseLong(dadoIdStr);
            String prontuario = req.getParameter("prontuario");
            if (prontuario == null || prontuario.isEmpty()) {
                prontuario = "Vazio";
            }
            agendamento.setProntuario(prontuario);
            agendamento.setId(consultaId);
            new AgendamentoDAO().finalizarAgendamento(agendamento);
            System.out.println("Consulta finalizada com sucesso");
        } else {
            System.out.println("Erro ao finalizar consulta: id não informado");
        }


        resp.sendRedirect("/listar-consultas");
    }
}
