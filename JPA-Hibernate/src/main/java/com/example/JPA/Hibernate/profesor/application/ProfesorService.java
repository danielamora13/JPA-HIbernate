package com.example.JPA.Hibernate.profesor.application;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.output.ProfesorOutputDto;

import java.util.List;

public interface ProfesorService {

    ProfesorInputDto getProfesor();

    ProfesorOutputDto anhadirProfesor(ProfesorInputDto profesorInputDto) throws UnprocesableException;

    ProfesorOutputDto updateProfesorById(ProfesorInputDto profesorInputDto, String id) throws NotFoundException, UnprocesableException;

    ProfesorOutputDto getProfesorById(String id) throws NotFoundException;

    //List<ProfesorOutputDto> getProfesorByName(String name);

    List<ProfesorOutputDto> getProfesors();

    void deleteById(String id) throws NotFoundException;
}
