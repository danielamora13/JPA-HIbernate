package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller;

import com.example.JPA.Hibernate.estudianteAsignatura.application.EstudianteAsignaturaService;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("estudianteAsignatura")
public class EstudianteAsignaturaDeleteController {

    EstudianteAsignaturaService estudianteAsignaturaService;

    @DeleteMapping("{id}")
    public void deleteAsignaturaById(@PathVariable String id) throws NotFoundException {
        estudianteAsignaturaService.deleteById(id);
    }

}
