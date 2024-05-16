package br.com.clinicamedica.model;

import java.text.DateFormat;
import java.util.Date;

public class Paciente extends Usuario {
    private Long id;
    private int dependentes;
    private int idade;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
