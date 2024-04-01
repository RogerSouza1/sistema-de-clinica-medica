package br.com.clinicamedica.objects;

public class Agendamento {
    private int idAgendamento;
    private Paciente paciente;
    private Disponibilidade disponibilidade;
    private String prontuario;
    
    public int getIdAgendamento() {
        return idAgendamento;
    }
    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    public String getProntuario() {
        return prontuario;
    }
    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    
}
