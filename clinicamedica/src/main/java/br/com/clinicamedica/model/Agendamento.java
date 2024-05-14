package br.com.clinicamedica.model;

public class Agendamento {
    Long paciente;
    Long disponibilidade;
    String prontuario;
    boolean finalizado;
    boolean cancelado;
    boolean confirmado;

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public Long getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Long disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }
}
