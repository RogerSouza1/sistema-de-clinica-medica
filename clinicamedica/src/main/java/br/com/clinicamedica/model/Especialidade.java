package br.com.clinicamedica.model;


public class Especialidade {
    private long idEspecialidade;
    private String nomeEspecialidade;

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public long getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
}
