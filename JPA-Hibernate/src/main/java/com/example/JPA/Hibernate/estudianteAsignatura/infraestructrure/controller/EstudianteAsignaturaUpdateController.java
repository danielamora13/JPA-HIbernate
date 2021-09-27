package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller;

import com.example.JPA.Hibernate.estudianteAsignatura.application.EstudianteAsignaturaService;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.EstudianteAsignaturaInputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.EstudianteAsignaturaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("estudianteAsignatura")
public class EstudianteAsignaturaUpdateController {

    EstudianteAsignaturaService estudianteAsignaturaService;

    @PutMapping("{id}")
    public EstudianteAsignaturaOutputDto updateAsignaturaById(@Valid @RequestBody EstudianteAsignaturaInputDto estudianteAsignaturaInputDto, @PathVariable String id) throws Exception{
        return estudianteAsignaturaService.updateAsignaturaById(estudianteAsignaturaInputDto, id);
    }
}
