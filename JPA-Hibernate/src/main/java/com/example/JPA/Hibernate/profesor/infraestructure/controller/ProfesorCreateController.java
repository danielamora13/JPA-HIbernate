package com.example.JPA.Hibernate.profesor.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.profesor.application.ProfesorService;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.output.ProfesorOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("profesor")
public class ProfesorCreateController {

    ProfesorService profesorService;

    @PostMapping
    public ProfesorOutputDto anhadirProfesor(@Valid @RequestBody ProfesorInputDto profesorInputDto) throws UnprocesableException {
        return profesorService.anhadirProfesor(profesorInputDto);
    }
}
