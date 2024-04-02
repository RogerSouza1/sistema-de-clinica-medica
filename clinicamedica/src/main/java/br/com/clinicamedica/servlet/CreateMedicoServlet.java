package br.com.clinicamedica.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.clinicamedica.objects.Endereco;
import br.com.clinicamedica.objects.Medico;

@WebServlet("/create-medico")
public class CreateMedicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Medico medico = new Medico();

        medico.setNome(req.getParameter("medicoNome"));
        medico.setCPF(Integer.parseInt(req.getParameter("medicoCPF")));
        medico.setEmail(req.getParameter("medicoEmail"));
        medico.setSenha(req.getParameter("medicoSenha"));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            medico.setDataNascimento(dateFormat.parse(req.getParameter("medicoDataNascimento")));
        } catch (Exception e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }

        medico.setTelefone(req.getParameter("medicoTelefone"));

        Endereco enderecoMedico = new Endereco();
        enderecoMedico.setLogradouro(req.getParameter("medicoLogradouro"));
        enderecoMedico.setNumero(Integer.parseInt(req.getParameter("medicoNumero")));
        enderecoMedico.setComplemento(req.getParameter("medicoComplemento"));
        enderecoMedico.setBairro(req.getParameter("medicoBairro"));
        enderecoMedico.setCidade(req.getParameter("medicoCidade"));
        enderecoMedico.setEstado(req.getParameter("medicoEstado"));
        enderecoMedico.setCEP(req.getParameter("medicoCEP"));
        medico.setEndereco(enderecoMedico);

        medico.setCRM(Integer.parseInt(req.getParameter("medicoCRM")));
        medico.setEspecialidade(req.getParameter("medicoEspecialidade"));
        medico.setClinica(req.getParameter("medicoClinica"));

        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
