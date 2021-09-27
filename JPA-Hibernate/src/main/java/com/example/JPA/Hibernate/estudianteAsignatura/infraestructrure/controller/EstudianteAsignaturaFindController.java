package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller;

import com.example.JPA.Hibernate.estudianteAsignatura.application.EstudianteAsignaturaService;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.EstudianteAsignaturaOutputDto;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("estudianteAsignatura")
public class EstudianteAsignaturaFindController {

    EstudianteAsignaturaService estudianteAsignaturaService;


    @GetMapping("{id}")
    public EstudianteAsignaturaOutputDto getAsignaturaById(@PathVariable String id)
            throws NotFoundException {
        return estudianteAsignaturaService.getAsignaturaById(id);


    }

//    @GetMapping("/student/name/{name}")
//    public List<PersonaOutputDto> getPersonaByName(@PathVariable String name) {
//        return studentService.getStudentByName(name);
//    }

    @GetMapping
    public List<EstudianteAsignaturaOutputDto> getAsignaturas() {
        return estudianteAsignaturaService.getAsignaturas();
    }

}
