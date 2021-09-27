package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller;

import com.example.JPA.Hibernate.estudianteAsignatura.application.StudentAsignaturaService;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.StudentAsignaturaInputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.StudentAsignaturaOutputDto;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.StudentInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleStudentOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("studentAsignatura")
public class StudentAsignaturaCreateController {

    StudentAsignaturaService studentAsignaturaService;

    @PostMapping
    public StudentAsignaturaOutputDto anhadirAsignatura(@Valid @RequestBody StudentAsignaturaInputDto studentAsignaturaInputDto) throws UnprocesableException {
        return studentAsignaturaService.anhadirAsignatura(studentAsignaturaInputDto);
    }

}
