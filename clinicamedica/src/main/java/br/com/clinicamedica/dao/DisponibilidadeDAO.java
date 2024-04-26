package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Horario;
import br.com.clinicamedica.model.Medico;

import java.sql.*;
import java.util.*;
import java.util.Date;


public class DisponibilidadeDAO {
    private final String url = "jdbc:h2:~/test";
    private final String usuario = "sa";
    private final String senha = "sa";

    public long definirHorarios(Horario horario) {
        final String sqlInsert = "INSERT INTO horarios (%s) VALUES (%s)";
        final String sqlSelect = "SELECT id_horarios FROM horarios WHERE %s";

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
                return -1;
            }

            // Criar a lista de colunas e placeholders para os horários
            String colunas = String.join(", ", horariosDisponiveis);
            String placeholders = String.join(", ", Collections.nCopies(horariosDisponiveis.size(), "?"));

            // Verificar se os horários já existem no banco de dados
            String colunasExistem = String.join(" = TRUE AND ", horariosDisponiveis) + " = TRUE";
            String sqlSelectFinal = String.format(sqlSelect, colunasExistem);
            try (PreparedStatement psSelect = connection.prepareStatement(sqlSelectFinal)) {
                ResultSet rs = psSelect.executeQuery();
                if (rs.next()) {
                    long existingId = rs.getLong("id_horarios");
                    System.out.println("Já existe um registro com os mesmos valores no ID_HORARIOS = " + existingId);
                    return existingId;
                }
            }

            // Inserir os horários na tabela horarios
            String sqlFinal = String.format(sqlInsert, colunas, placeholders);
            try (PreparedStatement psInsert = connection.prepareStatement(sqlFinal, Statement.RETURN_GENERATED_KEYS)) {
                // Preencher os placeholders com os valores verdadeiros
                int i = 1;
                for (Boolean disponivel : horario.getDisponibilidade().values()) {
                    if (disponivel) {
                        psInsert.setBoolean(i++, true);
                    }
                }

                int affectedRows = psInsert.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("A inserção falhou, nenhum registro foi afetado.");
                }

                // Recuperar o ID gerado automaticamente
                try (ResultSet generatedKeys = psInsert.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1);
                    } else {
                        throw new SQLException("A inserção falhou, nenhum ID foi gerado.");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir horários de disponibilidade: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public void definirDisponibilidade(Medico medico, Date data, Horario horario) {

        Long id_horario = definirHorarios(horario);
        final String sqlInsert = "INSERT INTO disponibilidade (id_medico, data, id_horarios, disponivel) VALUES (?, ?, ?, ?)";

        for (Map.Entry<String, Boolean> entry : horario.getDisponibilidade().entrySet()) {
            if (entry.getValue()) {
                System.out.println("Horário disponível: " + entry.getKey());

            }
        }

        try{
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            PreparedStatement ps = connection.prepareStatement(sqlInsert);

            ps.setLong(1, medico.getId());
            ps.setDate(2, new java.sql.Date(data.getTime()));
            ps.setLong(3, id_horario);
            ps.setBoolean(4, true);



        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private int getIdHorarios(String horarioSelecionado) {
        final String sqlSelect = "SELECT id_horarios FROM horarios WHERE horario = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlSelect);
            ps.setString(1, horarioSelecionado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_horarios");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar idHorarios: " + e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }
    public void atualizarHorarios(Medico medico, java.util.Date data, int idHorarios, boolean disponivel) {
        final String sqlUpdate = "UPDATE disponibilidade SET disponivel = ? WHERE id_medico = ? AND data = ? AND id_horarios = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            PreparedStatement ps = connection.prepareStatement(sqlUpdate);
            ps.setBoolean(1, disponivel);
            ps.setLong(2, medico.getId());
            ps.setDate(3, new java.sql.Date(data.getTime()));
            ps.setInt(4, idHorarios);
            ps.executeUpdate();
            ps.close();
            System.out.println("Horários de disponibilidade atualizados com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar horários de disponibilidade: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
