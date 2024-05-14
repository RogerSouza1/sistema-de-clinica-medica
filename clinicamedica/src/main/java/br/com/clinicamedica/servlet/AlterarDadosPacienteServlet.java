package br.com.clinicamedica.servlet;

import br.com.clinicamedica.dao.EnderecoDAO;
import br.com.clinicamedica.dao.PacienteDAO;
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
        Paciente identificador = (Paciente) req.getSession().getAttribute("pacienteLogado");
        String cpf = identificador.getCpf().toString();
        Endereco enderecoIdentificador = new EnderecoDAO().getEnderecoById(identificador.getEndereco().getId_endereco());

        Paciente paciente = new Paciente();
        Endereco endereco = new Endereco();

        endereco.setId_endereco(enderecoIdentificador.getId_endereco());
        endereco.setLogradouro(enderecoIdentificador.getLogradouro());
        endereco.setNumero(enderecoIdentificador.getNumero());
        endereco.setBairro(enderecoIdentificador.getBairro());
        endereco.setCidade(enderecoIdentificador.getCidade());
        endereco.setEstado(enderecoIdentificador.getEstado());
        endereco.setCep(enderecoIdentificador.getCep());

        paciente.setIdUsuario(identificador.getIdUsuario());
        paciente.setNome(identificador.getNome());
        paciente.setSenha(identificador.getSenha());
        paciente.setTelefone(identificador.getTelefone());
        paciente.setEndereco(enderecoIdentificador);

        String nomeStr = req.getParameter("paciente-nome");
        if (nomeStr != null && !nomeStr.isEmpty()) {
            paciente.setNome(nomeStr);
        }

        String senhaStr = req.getParameter("paciente-senha");
        if (senhaStr != null && !senhaStr.isEmpty()) {
            paciente.setSenha(senhaStr);
        }

        String telefone = (req.getParameter("paciente-telefone"));
        if (telefone != null && !telefone.isEmpty()) {
            paciente.setTelefone(Long.parseLong(telefone));
        }

        String logradouro = req.getParameter("paciente-lougradouro");
        if (logradouro != null && !logradouro.isEmpty()) {
            endereco.setLogradouro(logradouro);
        }

        String numero = req.getParameter("paciente-numero");
        if (numero != null && !numero.isEmpty()) {
            endereco.setNumero(Integer.parseInt(numero));
        }

        String bairro = req.getParameter("paciente-bairro");
        if (bairro != null && !bairro.isEmpty()) {
            endereco.setBairro(bairro);
        }

        String cidade = req.getParameter("paciente-cidade");
        if (cidade != null && !cidade.isEmpty()) {
            endereco.setCidade(cidade);
        }
        String estado = req.getParameter("paciente-estado");
        if (estado != null && !estado.isEmpty()) {
            endereco.setEstado(estado);
        }

        String cep = req.getParameter("paciente-cep");
        if (cep != null && !cep.isEmpty()) {
            endereco.setCep(cep.replaceAll("[^0-9]", ""));
        }
        paciente.setEndereco(endereco);

        boolean dadosAlterados = new PacienteDAO().atualizarPaciente(paciente, cpf);

        if (dadosAlterados) {
            req.getSession().setAttribute("pacienteLogado", new PacienteDAO().getPacienteByCPF(cpf));
            req.getRequestDispatcher("paciente/agendarConsultas.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("paciente/pacienteDados.html").forward(req, resp);
        }
    }
}
