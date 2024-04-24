package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.DisponibilidadeDAO;
import br.com.clinicamedica.model.Horario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastrar-horarios")
public class DefinirHorarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Criar uma instância de Horario
        Horario horario = new Horario();

        // Recuperar os horários selecionados do formulário
        String[] horariosSelecionados = request.getParameterValues("horario");

        // Marcar como verdadeiros os horários selecionados
        if (horariosSelecionados != null) {
            for (String horarioSelecionado : horariosSelecionados) {
                horario.setDisponibilidade(horarioSelecionado, true);
            }
        } else {
            System.out.println("Nenhum horário selecionado.");
            // Tratar o caso em que nenhum horário foi selecionado, se necessário
        }

        // Chamar o método do DAO para inserir os horários no banco de dados
        DisponibilidadeDAO horarioDAO = new DisponibilidadeDAO();
        horarioDAO.DefinirHorarios(horario);

        // Redirecionar para alguma página de confirmação
        response.sendRedirect("/medico/calendario.html");
    }
}
