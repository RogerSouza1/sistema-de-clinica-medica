package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.PacienteDAO;
import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Paciente;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastar-paciente")
public class CreatePacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Paciente paciente = new Paciente();
        Endereco endereco = new Endereco();




        new PacienteDAO().cadastrarPaciente(paciente);

    }
}
