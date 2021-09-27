package com.example.JPA.Hibernate.student.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.student.application.EstudianteService;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.EstudianteInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleEstudianteOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("estudiante")
public class EstudianteCreateController {

    EstudianteService estudianteService;

    @PostMapping
    public SimpleEstudianteOutputDto anhadirEstudiante(@Valid @RequestBody EstudianteInputDto estudianteInputDto) throws UnprocesableException {
        return estudianteService.anhadirEstudiante(estudianteInputDto);
    }
}
