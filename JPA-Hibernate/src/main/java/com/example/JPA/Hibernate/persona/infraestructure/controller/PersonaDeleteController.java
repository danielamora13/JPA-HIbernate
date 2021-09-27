package com.example.JPA.Hibernate.persona.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.persona.application.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")
public class PersonaDeleteController {

    PersonaService personaService;

    @DeleteMapping("/persona/{id}")
    public void deletePersonaById(@PathVariable String id) throws NotFoundException {
        personaService.deleteById(id);
    }
}
