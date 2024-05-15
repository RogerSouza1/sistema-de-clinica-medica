package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.AgendamentoDAO;
import br.com.clinicamedica.model.Agendamento;
import br.com.clinicamedica.model.Medico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listar-consultas")
public class ListarConsultasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Medico medico = (Medico) req.getSession().getAttribute("medicoLogado");
        List<Agendamento> consultas = new AgendamentoDAO().buscarConsultasDoDia(medico.getId());
        req.setAttribute("consultas", consultas);
        req.getRequestDispatcher("medico/calendario.jsp").forward(req, resp);
    }
}
