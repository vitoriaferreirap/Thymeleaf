package com.vitoriaferreira.thymeleafdemo.model;

import java.util.List;

import com.vitoriaferreira.thymeleafdemo.validation.Code;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "primeiro_nome")
    private String primeiroNome;

    // regras validaçao
    @NotNull(message = "campo obrigatorio") // não pode ser vazio
    @Size(min = 1, message = "campo obrigatorio") // tamanho mínimo 1
    @Column(name = "ultimo_nome")
    private String ultimoNome = "";

    @NotNull(message = "campo obrigatorio")
    @Min(value = 0, message = "deve ser maior ou igual a zero") // valor mínimo 0
    @Max(value = 10, message = "deve ser menor ou igual a dez") // valor máximo 10
    @Column(name = "passes_gratis")
    private Integer passesGratis;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "deve conter 5 digitos") // regex valida o formato
    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Code // anotação personalizada para validação
    @Column(name = "code")
    private String code;

    private String pais;
    private String linguagemFavorita;
    private List<String> sistemas;

    public Student() {
    }

    public Student(String primeiroNome, String ultimoNome, String pais, String linguagemFavorita,
            List<String> sistemas, Integer passesGratis, String codigoPostal) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.pais = pais;
        this.linguagemFavorita = linguagemFavorita;
        this.sistemas = sistemas;
        this.passesGratis = passesGratis;
        this.codigoPostal = codigoPostal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getPassesGratis() {
        return passesGratis;
    }

    public void setPassesGratis(Integer passesGratis) {
        this.passesGratis = passesGratis;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}