package com.example.JPA.Hibernate.profesor.infraestructure.controller;

import com.example.JPA.Hibernate.profesor.application.ProfesorService;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.output.ProfesorOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("profesor")
public class ProfesorUpdateController {

    ProfesorService profesorService;

    @PutMapping("{id}")
    public ProfesorOutputDto updateProfesorById(@Valid @RequestBody ProfesorInputDto profesorInputDto, @PathVariable String id) throws Exception{
        return profesorService.updateProfesorById(profesorInputDto, id);
    }
}
