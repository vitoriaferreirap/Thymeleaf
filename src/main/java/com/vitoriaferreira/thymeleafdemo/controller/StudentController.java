package com.vitoriaferreira.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vitoriaferreira.thymeleafdemo.model.Student;

import jakarta.validation.Valid;

@Controller
public class StudentController {

    // injecao de dependencias para lista de paises (atributos obj)
    @Value("${paises}")
    private List<String> paises;

    @Value("${linguagens}")
    private List<String> linguagens;

    @Value("${sistemas}")
    private List<String> sistemas;

    /*---------------------------------------------------------------------------- */

    // metodos que exibira o formulario
    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        // criar um objeto Student
        Student student = new Student();

        // adicionar o objeto ao modelo
        model.addAttribute("student", student);

        // add a lista de paises
        model.addAttribute("paises", paises);

        // add a linguagem favorita
        model.addAttribute("linguagens", linguagens);

        // add a lista de sistemas operacionais
        model.addAttribute("sistemas", sistemas);

        return "student-form"; // nome do template Thymeleaf
    }

    // metodo que processara o formulario
    @PostMapping("/processStudentForm")
    // usa logica de validação aplicada na class student
    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // se houver erros, retornar ao formulario
            return "student-form";
        } else {
            // logica de negocio(log teminal)
            return "student-confirmation";
        }

    }
}