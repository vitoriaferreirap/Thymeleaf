package com.vitoriaferreira.thymeleafdemo.model;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {

    private String primeiroNome;
    // regras validaçao
    @NotNull(message = "campo obrigatorio") // não pode ser vazio
    @Size(min = 1, message = "campo obrigatorio") // tamanho mínimo 1
    private String ultimoNome = "";

    @Min(value = 0, message = "deve ser maior ou igual a zero") // valor mínimo 0
    @Max(value = 10, message = "deve ser menor ou igual a dez") // valor máximo 10
    private int passesGratis;

    private String pais;
    private String linguagemFavorita;
    private List<String> sistemas;

    public Student() {
    }

    public Student(String primeiroNome, String ultimoNome, String pais, String linguagemFavorita,
            List<String> sistemas) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.pais = pais;
        this.linguagemFavorita = linguagemFavorita;
        this.sistemas = sistemas;
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

    public int getPassesGratis() {
        return passesGratis;
    }

    public void setPassesGratis(int passesGratis) {
        this.passesGratis = passesGratis;
    }
}
