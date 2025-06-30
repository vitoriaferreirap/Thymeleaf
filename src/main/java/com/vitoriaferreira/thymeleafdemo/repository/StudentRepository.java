package com.vitoriaferreira.thymeleafdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoriaferreira.thymeleafdemo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Método para buscar todos os estudantes ordenados por último nome
    List<Student> findAllByOrderByUltimoNomeAsc();

    // Outros métodos de consulta podem ser adicionados aqui conforme necessário

}