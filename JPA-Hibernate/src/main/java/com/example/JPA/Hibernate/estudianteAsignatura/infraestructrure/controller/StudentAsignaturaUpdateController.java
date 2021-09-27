package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller;

import com.example.JPA.Hibernate.estudianteAsignatura.application.StudentAsignaturaService;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.StudentAsignaturaInputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.StudentAsignaturaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("studentAsignatura")
public class StudentAsignaturaUpdateController {

    StudentAsignaturaService studentAsignaturaService;

    @PutMapping("{id}")
    public StudentAsignaturaOutputDto updateAsignaturaById(@Valid @RequestBody StudentAsignaturaInputDto studentAsignaturaInputDto, @PathVariable String id) throws Exception{
        return studentAsignaturaService.updateAsignaturaById(studentAsignaturaInputDto, id);
    }
}
