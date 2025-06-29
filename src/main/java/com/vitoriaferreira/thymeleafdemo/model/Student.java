package com.vitoriaferreira.thymeleafdemo.model;

import java.util.List;

public class Student {
    private String primeiroNome;
    private String ultimoNome;
    private String pais;
    private String linguagemFavorita;
    private List<String> sistemas;

    public Student() {
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

    public String getLinguagemFavorita() {
        return linguagemFavorita;
    }

    public void setLinguagemFavorita(String linguagemFavorita) {
        this.linguagemFavorita = linguagemFavorita;
    }

    public List<String> getSistemas() {
        return sistemas;
    }

    public void setSistemas(List<String> sistemas) {
        this.sistemas = sistemas;
    }
}
