package com.vitoriaferreira.thymeleafdemo;

import com.vitoriaferreira.thymeleafdemo.validation.Code;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CodeValidator implements ConstraintValidator<Code, String> {

    private String codePrefix;

    @Override
    public void initialize(Code code) {
        codePrefix = code.value(); // Obtém o valor do prefixo da anotação
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        // Se o código for null ou vazio, considerar válido (deixar @NotNull tratar)
        boolean result;
        if (code != null) {
            result = code.startsWith(codePrefix);
        } else {
            result = true; // Se for null, não aplicar validação
        }

        return result;
    }

}
