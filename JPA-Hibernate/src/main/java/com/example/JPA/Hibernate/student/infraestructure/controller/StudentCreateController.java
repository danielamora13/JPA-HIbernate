package com.example.JPA.Hibernate.student.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.student.application.StudentService;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.StudentInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleStudentOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("student")
public class StudentCreateController {

    StudentService studentService;

    @PostMapping
    public SimpleStudentOutputDto anhadirStudent(@Valid @RequestBody StudentInputDto studentInputDto) throws UnprocesableException {
        return studentService.anhadirStudent(studentInputDto);
    }
}
