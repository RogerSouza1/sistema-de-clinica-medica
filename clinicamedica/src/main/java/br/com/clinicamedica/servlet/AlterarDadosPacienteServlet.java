package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.PacienteDAO;
import br.com.clinicamedica.dao.UsuarioDAO;
import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Paciente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/alterar-dados-paciente")
public class AlterarDadosPacienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PacienteDAO pacienteDAO = new PacienteDAO();
        Paciente identificador = (Paciente) req.getSession().getAttribute("pacienteLogado");
        Long cpf = identificador.getCpf();

        Paciente paciente = new Paciente();
        Endereco endereco = new Endereco();

        paciente.setNome(identificador.getNome());
        paciente.setSenha(identificador.getSenha());
        paciente.setTelefone(identificador.getTelefone());
        paciente.setEndereco(identificador.getEndereco());

        String nomeStr = req.getParameter("paciente-nome");
        if (nomeStr != null && !nomeStr.isEmpty()) {
            paciente.setNome(nomeStr);
        }

        String senhaStr = req.getParameter("paciente-senha");
        if (senhaStr != null && !senhaStr.isEmpty()) {
            paciente.setSenha(senhaStr);
        }

        String telefoneStr = req.getParameter("paciente-telefone");
        if (telefoneStr != null && !telefoneStr.isEmpty()) {
            long telefoneLong = Long.parseLong(telefoneStr);
            paciente.setTelefone(telefoneLong);
        }

        String logradouroStr = req.getParameter("paciente-logradouro");
        if (logradouroStr != null && !logradouroStr.isEmpty()) {
            endereco.setLogradouro(logradouroStr);
        }

        int numero = Integer.parseInt(req.getParameter("paciente-numero"));
        if (numero != 0) {
            endereco.setNumero(numero);
        }
        String bairroStr = req.getParameter("paciente-bairro");
        if (bairroStr != null && !bairroStr.isEmpty()) {
            endereco.setBairro(bairroStr);
        }
        String cidadeStr = req.getParameter("paciente-cidade");
        if (cidadeStr != null && !cidadeStr.isEmpty()) {
            endereco.setCidade(cidadeStr);
        }
        String estadoStr = req.getParameter("paciente-estado");
        if (estadoStr != null && !estadoStr.isEmpty()) {
            endereco.setEstado(estadoStr);
        }
        String cepStr = req.getParameter("paciente-cep");
        if (cepStr != null && !cepStr.isEmpty()) {
            endereco.setCep(cepStr);
        }
        paciente.setEndereco(endereco);

        boolean dadosAlterados = new UsuarioDAO().atualizarUsuario(paciente, cpf);

        if (dadosAlterados) {
            req.getSession().setAttribute("pacienteLogado", pacienteDAO.getPacienteByCPF(cpf.toString()));
            req.getRequestDispatcher("paciente/agendarConsultas.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("alterarDadosPaciente.html").forward(req, resp);
        }








    }
}
