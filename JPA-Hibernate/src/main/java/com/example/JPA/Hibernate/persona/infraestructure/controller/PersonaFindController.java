package com.example.JPA.Hibernate.persona.infraestructure.controller;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.persona.application.PersonaService;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")
public class PersonaFindController {

    PersonaService personaService;

    @GetMapping("{id}")
    public PersonaOutputDto getPersonaById(@PathVariable String id,
                                           @RequestParam(name = "type", defaultValue = "simple") String type)
            throws NotFoundException {
        return personaService.getPersonaById(id, type);
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
