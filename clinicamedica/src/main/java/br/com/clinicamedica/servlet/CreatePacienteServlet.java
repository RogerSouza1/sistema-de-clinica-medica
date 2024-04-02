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

        paciente.setNome(req.getParameter("pacienteNome"));
        paciente.setCPF(Integer.parseInt(req.getParameter("pacienteCPF")));
        paciente.setEmail(req.getParameter("pacienteEmail"));
        paciente.setSenha(req.getParameter("pacienteSenha"));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            paciente.setDataNascimento(dateFormat.parse(req.getParameter("pacienteDataNascimento")));
        } catch (Exception e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }

        paciente.setTelefone(req.getParameter("pacienteTelefone"));

        Endereco enderecoPaciente = new Endereco();
        enderecoPaciente.setLogradouro(req.getParameter("pacienteLogradouro"));
        enderecoPaciente.setNumero(Integer.parseInt(req.getParameter("pacienteNumero")));
        enderecoPaciente.setComplemento(req.getParameter("pacienteComplemento"));
        enderecoPaciente.setBairro(req.getParameter("pacienteBairro"));
        enderecoPaciente.setCidade(req.getParameter("pacienteCidade"));
        enderecoPaciente.setEstado(req.getParameter("pacienteEstado"));
        enderecoPaciente.setCEP(req.getParameter("pacienteCEP"));
        paciente.setEndereco(enderecoPaciente);

        paciente.setDependentes(Integer.parseInt(req.getParameter("pacienteDependentes")));

        req.getRequestDispatcher("index.html").forward(req, resp);

    }
}
