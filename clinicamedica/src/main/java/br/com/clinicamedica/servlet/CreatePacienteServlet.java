package br.com.clinicamedica.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.clinicamedica.objects.Endereco;
import br.com.clinicamedica.objects.Paciente;

@WebServlet("/create-paciente")
public class CreatePacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Paciente paciente = new Paciente();

        paciente.setNome(req.getParameter("paciente-nome"));
        paciente.setCPF(Integer.parseInt(req.getParameter("paciente-cpf")));
        paciente.setEmail(req.getParameter("paciente-email"));
        paciente.setSenha(req.getParameter("paciente-senha"));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            paciente.setDataNascimento(dateFormat.parse(req.getParameter("paciente-dataNascimento")));
        } catch (Exception e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }

        paciente.setTelefone(req.getParameter("paciente-telefone"));

        Endereco enderecoPaciente = new Endereco();
        enderecoPaciente.setLogradouro(req.getParameter("paciente-logradouro"));
        enderecoPaciente.setNumero(Integer.parseInt(req.getParameter("paciente-numero")));
        enderecoPaciente.setComplemento(req.getParameter("paciente-complemento"));
        enderecoPaciente.setBairro(req.getParameter("paciente-bairro"));
        enderecoPaciente.setCidade(req.getParameter("paciente-cidade"));
        enderecoPaciente.setEstado(req.getParameter("paciente-estado"));
        enderecoPaciente.setCEP(req.getParameter("paciente-cep"));
        paciente.setEndereco(enderecoPaciente);

        paciente.setDependentes(Integer.parseInt(req.getParameter("paciente-dependentes")));

        req.getRequestDispatcher("index.html").forward(req, resp);

    }
}
