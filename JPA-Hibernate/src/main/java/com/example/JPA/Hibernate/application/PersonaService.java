package com.example.JPA.Hibernate.application;

import com.example.JPA.Hibernate.domain.Persona;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.PersonaOutputDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PersonaService {

    PersonaInputDto getPersona();

    PersonaOutputDto anhadirPersona(PersonaInputDto per) throws UnprocesableException;

    PersonaOutputDto updatePersonaById(PersonaInputDto per, int id) throws NotFoundException, UnprocesableException;

    PersonaOutputDto getPersonaById(int id) throws NotFoundException;

    List<PersonaOutputDto> getPersonaByName(String name);

    List<PersonaOutputDto> getPersonas();

    void deleteById(int id) throws NotFoundException;
}
