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

        medico.setNome(req.getParameter("medico-nome"));
        medico.setCPF(Integer.parseInt(req.getParameter("medico-cpf")));
        medico.setEmail(req.getParameter("medico-email"));
        medico.setSenha(req.getParameter("medico-senha"));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            medico.setDataNascimento(dateFormat.parse(req.getParameter("medico-dataNascimento")));
        } catch (Exception e) {
            System.err.println("Error parsing date: " + e.getMessage());
        }

        medico.setTelefone(req.getParameter("medico-telefone"));

        Endereco enderecoMedico = new Endereco();
        enderecoMedico.setLogradouro(req.getParameter("medico-logradouro"));
        enderecoMedico.setNumero(Integer.parseInt(req.getParameter("medico-numero")));
        enderecoMedico.setComplemento(req.getParameter("medico-complemento"));
        enderecoMedico.setBairro(req.getParameter("medico-bairro"));
        enderecoMedico.setCidade(req.getParameter("medico-cidade"));
        enderecoMedico.setEstado(req.getParameter("medico-estado"));
        enderecoMedico.setCEP(req.getParameter("medico-cep"));
        medico.setEndereco(enderecoMedico);

        medico.setCRM(Integer.parseInt(req.getParameter("medico-crm")));
        medico.setEspecialidade(req.getParameter("medico-especialidade"));
        medico.setClinica(req.getParameter("medico-clinica"));

        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
