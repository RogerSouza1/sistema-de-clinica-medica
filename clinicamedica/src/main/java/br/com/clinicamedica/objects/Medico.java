package br.com.clinicamedica.objects;

public class Medico extends Usuario{
    private int idMedico;
    private Usuario usuario;
    private String CRM;
    private String especialidade;
    private String clinica;
    
    public int getIdMedico() {
        return idMedico;
    }
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getCRM() {
        return CRM;
    }
    public void setCRM(String cRM) {
        CRM = cRM;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public String getClinica() {
        return clinica;
    }
    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    
}
