package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.DisponibilidadeDAO;
import br.com.clinicamedica.dao.MedicoDAO;
import br.com.clinicamedica.model.Horario;
import br.com.clinicamedica.model.Medico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/cadastrar-horarios")
public class DefinirHorarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperar o médico logado
        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = (Medico) request.getSession().getAttribute("medicoLogado");

        // Recuperar a data selecionada
        String dataString = request.getParameter("data-horarios");
        Date data = null;
        if (dataString != null && !dataString.isEmpty()) {
            try {
                data = new SimpleDateFormat("dd-MM-yyyy").parse(dataString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Data é null ou está vazio.");
            return; // Se a data for nula ou vazia, retorne imediatamente
        }

        // Recuperar os horários selecionados do formulário
        Horario horario = new Horario();

        String[] horariosSelecionados = request.getParameterValues("horario");


        if (horariosSelecionados != null) {
            for (String horarioSelecionado : horariosSelecionados) {
                horario.setDisponibilidade(horarioSelecionado, true);
            }
            DisponibilidadeDAO disponibilidadeDAO = new DisponibilidadeDAO();
            disponibilidadeDAO.definirDisponibilidade(medico, data, horario);
        } else {
            System.out.println("Nenhum horário selecionado.");
        }

        // Redirecionar para alguma página de confirmação
        response.sendRedirect("/medico/calendario.html");
    }
}