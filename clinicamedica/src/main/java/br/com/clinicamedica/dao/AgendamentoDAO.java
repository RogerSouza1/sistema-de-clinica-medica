package br.com.clinicamedica.dao;

import br.com.clinicamedica.model.Agendamento;
import br.com.clinicamedica.model.Medico;
import br.com.clinicamedica.model.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class AgendamentoDAO {
    
    public void cadastrarAgendamento (Agendamento agendamento) {

    }

    public void confirmarAgendamento (Agendamento agendamento) {

    }

    public void cancelarAgendamento (Agendamento agendamento) {

    }

    public void finalizarAgendamento (Agendamento agendamento) {

    }

    public List<Agendamento> buscarAgendamentos (Medico medico) {
        return null;
    }

    public List<Agendamento> buscarAgendamentos (Paciente medico) {
        return null;
    }
}
