
package com.vitoriaferreira.thymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // criar um mapeamento para o "hello"
    @GetMapping("/hello")
    public String sayHello(Model model) {

        // adicionar atributo ao modelo
        model.addAttribute("theDate", new Date());

        // retornar o nome da view
        return "helloWorld"; // busca por um template chamado "helloworls.html"
    }
}
