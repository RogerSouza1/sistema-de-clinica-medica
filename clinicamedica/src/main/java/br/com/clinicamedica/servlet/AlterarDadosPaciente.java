package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.UsuarioDAO;
import br.com.clinicamedica.model.Paciente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/alterar-dados-paciente")
public class AlterarDadosPaciente extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("alterar-nome-paciente");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Paciente identificador = (Paciente) req.getSession().getAttribute("pacienteLogado");
        Long cpf = identificador.getCpf();

        boolean dadosAlterados = usuarioDAO.atualizarUsuario(cpf, nome);

        if (dadosAlterados) {
            req.getRequestDispatcher("agendarConsultas.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("alterarDadosPaciente.html").forward(req, resp);
        }
    }
}
