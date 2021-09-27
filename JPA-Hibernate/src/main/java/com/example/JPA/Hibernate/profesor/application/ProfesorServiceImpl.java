package com.example.JPA.Hibernate.profesor.application;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.persona.infraestructure.repository.PersonaRepository;
import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.output.ProfesorOutputDto;
import com.example.JPA.Hibernate.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    ProfesorInputDto profesorInputDto = new ProfesorInputDto();

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public ProfesorInputDto getProfesor() {
        return profesorInputDto;
    }

    @Override
    public ProfesorOutputDto anhadirProfesor(ProfesorInputDto profesorInputDto) throws UnprocesableException {
        if (profesorInputDto == null) {
            return null;
        }
        if (profesorInputDto.branch == null) {
            throw new UnprocesableException("Alguno de los campos necesarios está vacío");
        }

        Profesor profesor = profesorInputDto.profesorInputDto();

        Persona persona = personaRepository.findById(profesorInputDto.idPersona).orElseThrow(() ->
                new NotFoundException("Persona con id "+profesorInputDto.idPersona+" no encontrada"));

        profesor.setPersona(persona);
        //persona.setProfesor(profesor);

        profesorRepository.save(profesor);

        return new ProfesorOutputDto(profesor);
    }

    @Override
    public ProfesorOutputDto updateProfesorById(ProfesorInputDto profesorInputDto, String id) throws NotFoundException, UnprocesableException {
        if (profesorInputDto == null) {
            return null;
        }

        Profesor profesor = profesorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Profesor con id "+id+" no encontrado"));

        profesor.setProfesor(profesorInputDto);

        profesorRepository.save(profesor);

        return new ProfesorOutputDto(profesor);
    }

    @Override
    public ProfesorOutputDto getProfesorById(String id) throws NotFoundException {
        return new ProfesorOutputDto(profesorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Profesor con id "+id+" no encontrado")));
    }

    @Override
    public List<ProfesorOutputDto> getProfesors() {

        List<Profesor> profesores = profesorRepository.findAll();
        return profesores.stream().map(ProfesorOutputDto::new).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        profesorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Profesor con id "+id+" no encontrado"));

        profesorRepository.deleteById(id);

    }
}
