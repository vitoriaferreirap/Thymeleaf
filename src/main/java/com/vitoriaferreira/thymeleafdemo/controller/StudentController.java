package com.vitoriaferreira.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitoriaferreira.thymeleafdemo.model.Student;
import com.vitoriaferreira.thymeleafdemo.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    // Injetar o StudentService para usar o banco de dados
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // injecao de dependencias para lista de paises (atributos obj)
    @Value("${paises}")
    private List<String> paises;

    @Value("${linguagens}")
    private List<String> linguagens;

    @Value("${sistemas}")
    private List<String> sistemas;

    /*---------------------------------------------------------------------------- */

    // validação para não aceitar espaços no campo do forms
    @InitBinder // registra editores personalizados e tira espaços em branco
    public void initBinder(WebDataBinder dataBinder) {
        // editor de propriedades que converte strings em branco em null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    // método para listar todos os estudantes
    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students/student-confirmation-list";
    }

    // metodos que exibira o formulario para adicionar um novo estudante
    @GetMapping("/showForm")
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

        return "students/student-form"; // nome do template Thymeleaf
    }

    // metodo que processara o formulario
    @PostMapping("/process")
    // usa logica de validação aplicada na class student
    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
            Model model) {

        System.out.println("Binding Result: " + bindingResult.toString());
        if (bindingResult.hasErrors()) {
            // adicionar novamente as listas ao modelo em caso de erro
            model.addAttribute("paises", paises);
            model.addAttribute("linguagens", linguagens);
            model.addAttribute("sistemas", sistemas);
            // se houver erros, retornar ao formulario
            return "students/student-form";
        } else {
            // SALVAR o estudante no banco de dados
            studentService.saveStudent(student);

            System.out
                    .println("Estudante salvo no banco: " + student.getPrimeiroNome() + " " + student.getUltimoNome());

            // redirecionar para a lista de estudantes
            return "redirect:/student/list";
        }
    }

    // metodo que exibira o formulario para atualizar um estudante
    @GetMapping("/showFormUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
        // buscar o estudante pelo ID
        Student student = studentService.findById(id);

        // adicionar o estudante ao modelo para pré-preencher o formulário
        model.addAttribute("student", student);

        // add as listas ao modelo
        model.addAttribute("paises", paises);
        model.addAttribute("linguagens", linguagens);
        model.addAttribute("sistemas", sistemas);

        return "students/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
            Model model) {

        return "redirect:/student/list";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int id) {
        // deletar o estudante
        studentService.deleteById(id);

        // redirecionar para a lista
        return "redirect:/student/list";
    }

}
