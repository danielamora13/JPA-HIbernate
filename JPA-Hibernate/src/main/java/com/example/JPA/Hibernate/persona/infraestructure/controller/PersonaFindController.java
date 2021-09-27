package com.example.JPA.Hibernate.persona.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.persona.application.PersonaService;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")
public class PersonaFindController {

    PersonaService personaService;

    @GetMapping("{id}")
    public PersonaOutputDto getPersonaById(@PathVariable String id) throws NotFoundException {
        return personaService.getPersonaById(id);
    }

    @GetMapping("name/{name}")
    public List<PersonaOutputDto> getPersonaByName(@PathVariable String name) {
        return personaService.getPersonaByName(name);
    }

    @GetMapping
    public List<PersonaOutputDto> getPersonas() {
        return personaService.getPersonas();
    }

}
