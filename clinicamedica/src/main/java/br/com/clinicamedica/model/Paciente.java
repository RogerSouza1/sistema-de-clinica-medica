package br.com.clinicamedica.model;

public class Paciente extends Usuario {
    private Long id;
    private Long idUsuario;
    private int dependentes;
    private int idade;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
