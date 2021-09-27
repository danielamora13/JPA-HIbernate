package com.example.JPA.Hibernate.student.application;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.persona.infraestructure.repository.PersonaRepository;
import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.profesor.infraestructure.repository.ProfesorRepository;
import com.example.JPA.Hibernate.student.domain.Estudiante;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.EstudianteInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.FullEstudianteOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleEstudianteOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.EstudianteOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    EstudianteInputDto estudianteInputDto = new EstudianteInputDto();

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public EstudianteInputDto getEstudiante() {
        return estudianteInputDto;
    }

    @Override
    public SimpleEstudianteOutputDto anhadirEstudiante(EstudianteInputDto estudianteInputDto) throws UnprocesableException, NotFoundException {
        if (estudianteInputDto == null) {
            return null;
        }
        if (estudianteInputDto.numHoursWeek == 0 || estudianteInputDto.branch == null) {
            throw new UnprocesableException("Alguno de los campos necesarios está vacío");
        }

        Estudiante estudiante = estudianteInputDto.studentInputDto();
        Persona persona = personaRepository.findById(estudianteInputDto.idPersona).orElseThrow(() ->
                new NotFoundException("Persona con id "+estudianteInputDto.idPersona+" no encontrada"));

        estudiante.setPersona(persona);
        //persona.setEstudiante(estudiante);

        if (estudianteInputDto.idProfesor != null) {
            Profesor profesor = profesorRepository.findById(estudianteInputDto.idProfesor).orElseThrow(() ->
                    new NotFoundException("Profesor con id "+estudianteInputDto.idProfesor+" no encontrado"));

            estudiante.setProfesor(profesor);
            //profesor.getEstudiantes().add(estudiante);
        }

        estudianteRepository.save(estudiante);

        return new SimpleEstudianteOutputDto(estudiante);
    }

    @Override
    public SimpleEstudianteOutputDto updateEstudianteById(EstudianteInputDto estudianteInputDto, String id) throws NotFoundException, UnprocesableException {
        if (estudianteInputDto == null) {
            return null;
        }

        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Estudiante con id "+id+" no encontrado"));
        estudiante.setStudent(estudianteInputDto);

        if (estudianteInputDto.idProfesor != null) {
            Profesor profesorAnterior = profesorRepository.findById(estudiante.getProfesor().getIdProfesor()).orElseThrow(() ->
                    new NotFoundException("Profesor con id "+estudianteInputDto.idProfesor+" no encontrado"));
            Profesor profesor = profesorRepository.findById(estudianteInputDto.idProfesor).orElseThrow(() ->
                    new NotFoundException("Profesor con id "+estudianteInputDto.idProfesor+" no encontrado"));

            estudiante.setProfesor(profesor);
            profesorAnterior.getEstudiantes().remove(estudiante);
            profesor.getEstudiantes().add(estudiante);
        }

        estudianteRepository.save(estudiante);
        return new SimpleEstudianteOutputDto(estudiante);
    }

    @Override
    public EstudianteOutputDto getEstudianteById(String id, String outputType) throws NotFoundException {
        switch (outputType) {
            case "simple":
                EstudianteOutputDto simpleEstudianteOutputDto = new SimpleEstudianteOutputDto(estudianteRepository.findById(id).orElseThrow(() ->
                        new NotFoundException("Estudiante con id " + id + " no encontrado")));
                return simpleEstudianteOutputDto;
            case "full":
                EstudianteOutputDto fullEstudianteOutputDto = new FullEstudianteOutputDto(estudianteRepository.findById(id).orElseThrow(() ->
                        new NotFoundException("Estudiante con id " + id + " no encontrado")));
                return fullEstudianteOutputDto;
            default:
                throw new NotFoundException("outputType no valido");
        }
    }

    @Override
    public List<SimpleEstudianteOutputDto> getEstudiantes() {

        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream().map(SimpleEstudianteOutputDto::new).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) throws NotFoundException {

        estudianteRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Estudiante con id "+id+" no encontrado"));

        estudianteRepository.deleteById(id);
    }
}
