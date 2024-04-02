package br.com.clinicamedica.objects;

public class Disponibilidade {
    private int idDisponibilidade;
    private Medico medico;
    private String data;
    private Horario horario;

    public int getIdDisponibilidade() {
        return idDisponibilidade;
    }

    public void setIdDisponibilidade(int idDisponibilidade) {
        this.idDisponibilidade = idDisponibilidade;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

}
