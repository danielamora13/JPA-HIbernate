package com.example.JPA.Hibernate.student.infraestructure.controller;

import com.example.JPA.Hibernate.student.application.EstudianteService;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.EstudianteInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleEstudianteOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("estudiante")
public class EstudianteUpdateController {

    EstudianteService estudianteService;

    @PutMapping("{id}")
    public SimpleEstudianteOutputDto updateEstudianteById(@Valid @RequestBody EstudianteInputDto estudianteInputDto, @PathVariable String id) throws Exception{
        return estudianteService.updateEstudianteById(estudianteInputDto, id);
    }
}
