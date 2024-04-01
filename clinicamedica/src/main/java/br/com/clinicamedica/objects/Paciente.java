package br.com.clinicamedica.objects;

public class Paciente extends Usuario{
    private int idPaciente;
    private Usuario usuario;
    private int denpendentes;
    
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getDenpendentes() {
        return denpendentes;
    }
    public void setDenpendentes(int denpendentes) {
        this.denpendentes = denpendentes;
    }

    

}
