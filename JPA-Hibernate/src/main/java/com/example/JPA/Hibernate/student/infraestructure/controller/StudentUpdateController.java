package com.example.JPA.Hibernate.student.infraestructure.controller;

import com.example.JPA.Hibernate.student.application.StudentService;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.StudentInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleStudentOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("student")
public class StudentUpdateController {

    StudentService studentService;

    @PutMapping("{id}")
    public SimpleStudentOutputDto updateStudentById(@Valid @RequestBody StudentInputDto studentInputDto, @PathVariable String id) throws Exception{
        return studentService.updateStudentById(studentInputDto, id);
    }
}
