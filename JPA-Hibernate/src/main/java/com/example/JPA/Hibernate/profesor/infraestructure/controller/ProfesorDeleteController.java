package com.example.JPA.Hibernate.profesor.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.profesor.application.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("profesor")
public class ProfesorDeleteController {

    ProfesorService profesorService;

    @DeleteMapping("{id]")
    public void deleteProfesorById(@PathVariable String id) throws NotFoundException {
        profesorService.deleteById(id);
    }

}
