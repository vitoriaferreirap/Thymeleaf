package com.vitoriaferreira.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
