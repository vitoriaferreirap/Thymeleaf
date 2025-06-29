package com.vitoriaferreira.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vitoriaferreira.thymeleafdemo.model.Student;

@Controller
public class StudentController {
    // metodos que exibira o formulario
    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        // criar um objeto Student
        Student student = new Student();

        // adicionar o objeto ao modelo
        model.addAttribute("student", student);

        return "student-form"; // nome do template Thymeleaf
    }

    // metodo que processara o formulario
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {
        // logica de negocio
        System.out.println("Student: " + student.getPrimeiroNome() + " " + student.getUltimoNome());

        return "student-confirmation"; // nome do template Thymeleaf
    }
}