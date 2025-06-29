package com.vitoriaferreira.thymeleafdemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vitoriaferreira.thymeleafdemo.CodeValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CodeValidator.class) // define a classe que implementa a lógica de validação
@Target({ ElementType.METHOD, ElementType.FIELD }) // responsavel por definir onde a anotação pode ser aplicada
@Retention(RetentionPolicy.RUNTIME) // define que a anotação estará disponível em tempo de execução
public @interface Code {

    public String value() default "LUV"; // valor padrão da anotação

    public String message() default "precisa começar com LUV"; // mensagem de erro padrão

    public Class<?>[] groups() default {}; // permite agrupar validações

    public Class<? extends Payload>[] payload() default {}; // permite associar metadados adicionais à anotação

}
