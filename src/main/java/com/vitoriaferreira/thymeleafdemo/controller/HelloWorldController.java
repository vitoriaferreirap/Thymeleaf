package com.vitoriaferreira.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
    // novo metodo controlle para iniciar um forms html
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form"; // retorna o nome do template HTML
    }

    // novo metodo controlle para processar um forms html

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld"; // retorna o nome do template HTML
    }

    // novo metodo controlle para ler um forms data e add data no model
    @RequestMapping("/processFormVerisionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // ler o request data do form HTML
        String theName = request.getParameter("studentName");
        // converte para maiusculo
        theName = theName.toUpperCase();
        // criar uma mensagem
        String result = "Yo! " + theName;
        // add mensagem ao model
        model.addAttribute("message", result);

        return "helloworld"; // retorna o nome do template HTML
    }

    @RequestMapping("/processFormVerisionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        // converte para maiusculo
        theName = theName.toUpperCase();
        // criar uma mensagem
        String result = "Hey My Friend from v3! " + theName;
        // add mensagem ao model
        model.addAttribute("message", result);

        return "helloworld"; // retorna o nome do template HTML
    }
}
