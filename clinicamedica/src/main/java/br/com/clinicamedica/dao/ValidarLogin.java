package br.com.clinicamedica.dao;

public class ValidarLogin {
    private boolean isValido;
    private boolean isPaciente;

    public ValidarLogin(boolean isValido, boolean isPaciente){
        this.isValido = isValido;
        this.isPaciente = isPaciente;
    }

    // getters and setters
    public boolean getIsValido() {
        return isValido;
    }

    public void setIsValido(boolean isValido) {
        this.isValido = isValido;
    }

    public boolean getIsPaciente() {
        return isPaciente;
    }

    public void setIsPaciente(boolean isPaciente) {
        this.isPaciente = isPaciente;
    }
}



