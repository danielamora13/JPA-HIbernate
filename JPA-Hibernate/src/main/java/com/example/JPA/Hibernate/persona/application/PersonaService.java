package com.example.JPA.Hibernate.persona.application;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.persona.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;

import java.util.List;

public interface PersonaService {

    PersonaInputDto getPersona();

    PersonaOutputDto anhadirPersona(PersonaInputDto personaInputDto) throws UnprocesableException;

    PersonaOutputDto updatePersonaById(PersonaInputDto personaInputDto, String id) throws NotFoundException, UnprocesableException;

    PersonaOutputDto getPersonaById(String id) throws NotFoundException;

    List<PersonaOutputDto> getPersonaByName(String name);

    List<PersonaOutputDto> getPersonas();

    void deleteById(String id) throws NotFoundException;
}
