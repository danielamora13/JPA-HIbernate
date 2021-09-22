package com.example.JPA.Hibernate.infraestructure.controller;

import com.example.JPA.Hibernate.domain.Persona;
import com.example.JPA.Hibernate.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.application.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persona")
public class Controlador {

    //@Autowired
    PersonaService personaService;

    @PostMapping
    public PersonaOutputDto anhadirPersona(@RequestBody PersonaInputDto per) throws Exception{
        return personaService.anhadirPersona(per);
    }

    @GetMapping("id/{id}")
    public PersonaOutputDto getPersonaById(@PathVariable int id) throws Exception {
        return personaService.getPersonaById(id);
    }

    @GetMapping("name/{name}")
    public PersonaOutputDto getPersonaByName(@PathVariable String name) {
        return personaService.getPersonaByName(name);
    }

    @GetMapping("all")
    public List<PersonaOutputDto> getPersonas() {
        return personaService.getPersonas();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id){
        personaService.deleteById(id);
    }

    @PutMapping("{id}")
    public PersonaOutputDto updatePersonaById(@RequestBody PersonaInputDto per, @PathVariable int id) throws Exception{
        return personaService.updatePersonaById(per, id);
    }
}
