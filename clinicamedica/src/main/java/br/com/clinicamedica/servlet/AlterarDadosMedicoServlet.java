package br.com.clinicamedica.servlet;


import br.com.clinicamedica.dao.EnderecoDAO;
import br.com.clinicamedica.dao.MedicoDAO;
import br.com.clinicamedica.model.Endereco;
import br.com.clinicamedica.model.Medico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/alterar-dados-medico")
public class AlterarDadosMedicoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Medico identificador = (Medico) req.getSession().getAttribute("medicoLogado");
        String cpf = identificador.getCpf().toString();
        Endereco enderecoIdentificador = new EnderecoDAO().getEnderecoById(identificador.getEndereco().getId_endereco());
        Endereco endereco = new Endereco();
        Medico medico = new Medico();


        endereco.setId_endereco(enderecoIdentificador.getId_endereco());
        endereco.setLogradouro(enderecoIdentificador.getLogradouro());
        endereco.setNumero(enderecoIdentificador.getNumero());
        endereco.setBairro(enderecoIdentificador.getBairro());
        endereco.setCidade(enderecoIdentificador.getCidade());
        endereco.setEstado(enderecoIdentificador.getEstado());
        endereco.setCep(enderecoIdentificador.getCep());

        medico.setIdUsuario(identificador.getIdUsuario());
        medico.setNome(identificador.getNome());
        medico.setSenha(identificador.getSenha());
        medico.setTelefone(identificador.getTelefone());
        medico.setEndereco(enderecoIdentificador);

        String nomeStr = req.getParameter("medico-nome");
        if (nomeStr != null && !nomeStr.isEmpty()) {
            medico.setNome(nomeStr);
        }

        String senhaStr = req.getParameter("medico-senha");
        if (senhaStr != null && !senhaStr.isEmpty()) {
            medico.setSenha(senhaStr);
        }

        String telefone = (req.getParameter("medico-telefone"));
        if (telefone != null && !telefone.isEmpty()) {
            medico.setTelefone(Long.parseLong(telefone.replaceAll("[^0-9]", "")));
        }

        String logradouro = req.getParameter("medico-lougradouro");
        if (logradouro != null && !logradouro.isEmpty()) {
            endereco.setLogradouro(logradouro);
        }

        String numero = req.getParameter("medico-numero");
        if (numero != null && !numero.isEmpty()) {
            endereco.setNumero(Integer.parseInt(numero));
        }

        String bairro = req.getParameter("medico-bairro");
        if (bairro != null && !bairro.isEmpty()) {
            endereco.setBairro(bairro);
        }

        String cidade = req.getParameter("medico-cidade");
        if (cidade != null && !cidade.isEmpty()) {
            endereco.setCidade(cidade);
        }
        String estado = req.getParameter("medico-estado");
        if (estado != null && !estado.isEmpty()) {
            endereco.setEstado(estado);
        }

        String cep = req.getParameter("medico-cep");
        if (cep != null && !cep.isEmpty()) {
            endereco.setCep(cep.replaceAll("[^0-9]", ""));
        }
        medico.setEndereco(endereco);

        boolean dadosAlterados = new MedicoDAO().atualizarMedico(medico, cpf);

        if (dadosAlterados) {
            req.getSession().setAttribute("medicoLogado", new MedicoDAO().getMedicoByCPF(cpf));
            req.getRequestDispatcher("medico/calendario.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("medico/medicoDados.html").forward(req, resp);
        }
    }
}
