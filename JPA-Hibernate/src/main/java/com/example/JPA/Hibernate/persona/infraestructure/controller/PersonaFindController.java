package com.example.JPA.Hibernate.persona.infraestructure.controller;

import com.example.JPA.Hibernate.IFeignServer;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.persona.application.PersonaService;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.output.ProfesorOutputDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/persona")
public class PersonaFindController {

    PersonaService personaService;

    @Autowired
    IFeignServer iFeignServer;

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

    @GetMapping("template/{id}")
    ResponseEntity<ProfesorOutputDto> getProfesorByIdRestTemplate(@PathVariable String id) {
        ResponseEntity<ProfesorOutputDto> profesorOutputDto = new RestTemplate()
                .getForEntity("http://localhost:8081/profesor/"+id, ProfesorOutputDto.class);
        return ResponseEntity.ok(profesorOutputDto.getBody());
    }

    @GetMapping("prof/{id}")
    ResponseEntity<ProfesorOutputDto> getProfesorByIdFeign(@PathVariable String id) {
        ResponseEntity<ProfesorOutputDto> respuesta = iFeignServer.callProfesor(id);
        return respuesta;
    }

}
