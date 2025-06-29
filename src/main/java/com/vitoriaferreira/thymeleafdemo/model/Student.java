package com.vitoriaferreira.thymeleafdemo.model;

public class Student {
    private String primeiroNome;
    private String ultimoNome;
    private String pais;

    public Student() {
    }

    public Student(String primeiroNome, String ultimoNome, String pais) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.pais = pais;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
