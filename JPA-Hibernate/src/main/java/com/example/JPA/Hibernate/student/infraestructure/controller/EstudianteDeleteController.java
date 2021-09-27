package com.example.JPA.Hibernate.student.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.student.application.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("estudiante")
public class EstudianteDeleteController {

    EstudianteService estudianteService;

    @DeleteMapping("{id}")
    public void deleteEstudianteById(@PathVariable String id) throws NotFoundException {
        estudianteService.deleteById(id);
    }

}
