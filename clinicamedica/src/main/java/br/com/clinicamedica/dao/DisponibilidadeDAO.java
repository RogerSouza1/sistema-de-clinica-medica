package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Disponibilidade;
import br.com.clinicamedica.model.Horario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;



public class DisponibilidadeDAO {

    final String url = "jdbc:h2:~/test";
    final String usuario = "sa";
    final String senha = "sa";


    public void atualizarHorarios (Disponibilidade disponibilidade) {

    }

    public void DefinirHorarios(Horario horario) {
        final String sqlInsert = "INSERT INTO horarios (%s) VALUES (%s)";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            // Montar a lista de horários disponíveis
            List<String> horariosDisponiveis = new ArrayList<>();
            for (Map.Entry<String, Boolean> entry : horario.getDisponibilidade().entrySet()) {
                if (entry.getValue()) {
                    horariosDisponiveis.add("h" + entry.getKey().replace(":", "").replace(" - ", "_").replace(" ", "_").toLowerCase());
                }
            }

            if (horariosDisponiveis.isEmpty()) {
                System.out.println("Nenhum horário disponível selecionado.");
                return;
            }

            // Criar a lista de colunas e placeholders para os horários
            String colunas = String.join(", ", horariosDisponiveis);
            String placeholders = String.join(", ", Collections.nCopies(horariosDisponiveis.size(), "?"));

            // Inserir os horários na tabela horarios
            String sqlFinal = String.format(sqlInsert, colunas, placeholders);
            PreparedStatement ps = connection.prepareStatement(sqlFinal, Statement.RETURN_GENERATED_KEYS);

            // Preencher os placeholders com os valores verdadeiros
            int i = 1;
            for (Boolean disponivel : horario.getDisponibilidade().values()) {
                if (disponivel) {
                    ps.setBoolean(i++, true);
                }
            }

            ps.executeUpdate();

            // Recuperar o ID gerado automaticamente
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                long idHorarios = generatedKeys.getLong(1);
                System.out.println("ID dos horários gerado: " + idHorarios);
            } else {
                System.out.println("Falha ao recuperar o ID dos horários gerado.");
            }

            ps.close();

            System.out.println("Horários de disponibilidade cadastrados com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir horários de disponibilidade: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
