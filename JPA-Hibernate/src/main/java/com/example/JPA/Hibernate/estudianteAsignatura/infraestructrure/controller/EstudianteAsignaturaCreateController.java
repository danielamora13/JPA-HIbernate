package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller;

import com.example.JPA.Hibernate.estudianteAsignatura.application.EstudianteAsignaturaService;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.EstudianteAsignaturaInputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.EstudianteAsignaturaOutputDto;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("estudianteAsignatura")
public class EstudianteAsignaturaCreateController {

    EstudianteAsignaturaService estudianteAsignaturaService;

    @PostMapping
    public EstudianteAsignaturaOutputDto anhadirAsignatura(@Valid @RequestBody EstudianteAsignaturaInputDto estudianteAsignaturaInputDto) throws UnprocesableException {
        return estudianteAsignaturaService.anhadirAsignatura(estudianteAsignaturaInputDto);
    }

}
