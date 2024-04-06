package br.com.clinicamedica.model;

public class Paciente extends Usuario {
    int dependentes;

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }
}
