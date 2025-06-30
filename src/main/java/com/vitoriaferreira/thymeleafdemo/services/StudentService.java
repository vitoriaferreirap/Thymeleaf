package com.vitoriaferreira.thymeleafdemo.services;

import java.util.List;

import com.vitoriaferreira.thymeleafdemo.model.Student;

public interface StudentService {
    List<Student> findAll();

    Student findById(int id);

    void saveStudent(Student student);

    void deleteById(int id);
}