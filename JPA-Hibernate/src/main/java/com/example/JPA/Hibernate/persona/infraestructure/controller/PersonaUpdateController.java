package com.example.JPA.Hibernate.persona.infraestructure.controller;

import com.example.JPA.Hibernate.persona.application.PersonaService;
import com.example.JPA.Hibernate.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")
public class PersonaUpdateController {

    PersonaService personaService;

    @PutMapping("/persona/{id}")
    public PersonaOutputDto updatePersonaById(@Valid @RequestBody PersonaInputDto personaInputDto, @PathVariable String id) throws Exception{
        return personaService.updatePersonaById(personaInputDto, id);
    }
}
