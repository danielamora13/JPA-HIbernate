package com.example.JPA.Hibernate.student.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.student.application.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("student")
public class StudentDeleteController {

    StudentService studentService;

    @DeleteMapping("{id}")
    public void deleteStudentById(@PathVariable String id) throws NotFoundException {
        studentService.deleteById(id);
    }

}
