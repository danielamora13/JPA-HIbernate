package com.example.JPA.Hibernate.student.application;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.EstudianteInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleEstudianteOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.EstudianteOutputDto;

import java.util.List;

public interface EstudianteService {

    EstudianteInputDto getEstudiante();

    SimpleEstudianteOutputDto anhadirEstudiante(EstudianteInputDto studentInputDto) throws UnprocesableException;

    SimpleEstudianteOutputDto updateEstudianteById(EstudianteInputDto studentInputDto, String id) throws NotFoundException, UnprocesableException;

    EstudianteOutputDto getEstudianteById(String id, String outputType) throws NotFoundException;

    //List<SimpleStudentOutputDto> getEstudianteByName(String name);

    List<SimpleEstudianteOutputDto> getEstudiantes();

    void deleteById(String id) throws NotFoundException;
}
