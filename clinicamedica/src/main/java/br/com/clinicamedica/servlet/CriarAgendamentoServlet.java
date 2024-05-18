package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.AgendamentoDAO;
import br.com.clinicamedica.dao.DisponibilidadeDAO;
import br.com.clinicamedica.dao.MedicoDAO;
import br.com.clinicamedica.model.Agendamento;
import br.com.clinicamedica.model.Medico;
import br.com.clinicamedica.model.Paciente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cadastrar-agendamento")
public class CriarAgendamentoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter o paciente logado na sessão
        Paciente paciente = (Paciente) request.getSession().getAttribute("pacienteLogado");

        // Obter os parâmetros enviados pelo formulário
        String especialidade = request.getParameter("especialidade");
        String clinica = request.getParameter("clinica");
        String nomeMedico = request.getParameter("medico");
        String horario = request.getParameter("horario");
        String data = request.getParameter("data");

        // Obtendo o ID do médico
        MedicoDAO medicoDAO = new MedicoDAO();
        Medico medico = medicoDAO.getMedicoByNome(nomeMedico);
        long idMedico = medico.getId(); // Defina um valor padrão se o médico não for encontrado

        // Obtendo o ID da disponibilidade correspondente
        DisponibilidadeDAO disponibilidadeDAO = new DisponibilidadeDAO();
        Long idDisponibilidade = disponibilidadeDAO.getIdDisponibilidade(especialidade, clinica, idMedico, data, horario);

        if (idDisponibilidade != null) {
            // Se encontrou a disponibilidade, criar o agendamento
            Agendamento agendamento = new Agendamento();

            agendamento.setPaciente(paciente);
            agendamento.setProntuario(""); // Preencher com o prontuário do paciente, se necessário

            AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
            agendamentoDAO.cadastrarAgendamento(agendamento, paciente, idDisponibilidade);

            List<Agendamento> minhasConsultas = agendamentoDAO.buscarAgendamentos(paciente);
            request.setAttribute("minhasConsultas", minhasConsultas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/paciente/consultas.jsp");
            dispatcher.forward(request, response);

        } else {
            System.out.println("Nenhum horário selecionado.");
            // Redirecionar para alguma página de erro, se necessário
        }
    }
}
