package br.com.clinicamedica.dao;

public class ValidarRedefinir {
    private boolean isValido;

    public ValidarRedefinir(boolean isValido){
        this.isValido = isValido;
    }

    // getters and setters
    public boolean getIsValido() {
        return isValido;
    }
    public void setIsValido(boolean isValido) {
        this.isValido = isValido;
    }
}
