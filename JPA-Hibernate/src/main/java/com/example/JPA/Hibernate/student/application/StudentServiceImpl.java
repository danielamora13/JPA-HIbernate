package com.example.JPA.Hibernate.student.application;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.persona.infraestructure.repository.PersonaRepository;
import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.profesor.infraestructure.repository.ProfesorRepository;
import com.example.JPA.Hibernate.student.domain.Student;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.StudentInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.FullStudentOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleStudentOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.StudentOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    StudentInputDto studentInputDto = new StudentInputDto();

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public StudentInputDto getStudent() {
        return studentInputDto;
    }

    @Override
    public SimpleStudentOutputDto anhadirStudent(StudentInputDto studentInputDto) throws UnprocesableException, NotFoundException {
        if (studentInputDto == null) {
            return null;
        }
        if (studentInputDto.numHoursWeek == 0 || studentInputDto.branch == null) {
            throw new UnprocesableException("Alguno de los campos necesarios está vacío");
        }

        Student student= studentInputDto.studentInputDto();
        Persona persona = personaRepository.findById(studentInputDto.idPersona).orElseThrow(() ->
                new NotFoundException("Persona con id "+studentInputDto.idPersona+" no encontrada"));

        student.setPersona(persona);
        //persona.setStudent(student);

        if (studentInputDto.idProfesor != null) {
            Profesor profesor = profesorRepository.findById(studentInputDto.idProfesor).orElseThrow(() ->
                    new NotFoundException("Profesor con id "+studentInputDto.idProfesor+" no encontrado"));

            student.setProfesor(profesor);
            //profesor.getStudents().add(student);
        }

        studentRepository.save(student);

        return new SimpleStudentOutputDto(student);
    }

    @Override
    public SimpleStudentOutputDto updateStudentById(StudentInputDto studentInputDto, String id) throws NotFoundException, UnprocesableException {
        if (studentInputDto == null) {
            return null;
        }

        Student student = studentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Estudiante con id "+id+" no encontrado"));
        student.setStudent(studentInputDto);

        if (studentInputDto.idProfesor != null) {
            Profesor profesorAnterior = profesorRepository.findById(student.getProfesor().getIdProfesor()).orElseThrow(() ->
                    new NotFoundException("Profesor con id "+studentInputDto.idProfesor+" no encontrado"));
            Profesor profesor = profesorRepository.findById(studentInputDto.idProfesor).orElseThrow(() ->
                    new NotFoundException("Profesor con id "+studentInputDto.idProfesor+" no encontrado"));

            student.setProfesor(profesor);
            profesorAnterior.getStudents().remove(student);
            profesor.getStudents().add(student);
        }

        studentRepository.save(student);
        return new SimpleStudentOutputDto(student);
    }

    @Override
    public StudentOutputDto getStudentById(String id, String outputType) throws NotFoundException {
        switch (outputType) {
            case "simple":
                StudentOutputDto simpleStudentOutputDto = new SimpleStudentOutputDto(studentRepository.findById(id).orElseThrow(() ->
                        new NotFoundException("Estudiante con id " + id + " no encontrado")));
                return simpleStudentOutputDto;
            case "full":
                StudentOutputDto fullStudentOutputDto = new FullStudentOutputDto(studentRepository.findById(id).orElseThrow(() ->
                        new NotFoundException("Estudiante con id " + id + " no encontrado")));
                return fullStudentOutputDto;
            default:
                throw new NotFoundException("outputType no valido");
        }
    }

    @Override
    public List<SimpleStudentOutputDto> getStudents() {

        List<Student> students = studentRepository.findAll();
        return students.stream().map(SimpleStudentOutputDto::new).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) throws NotFoundException {

        studentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Estudiante con id "+id+" no encontrado"));

        studentRepository.deleteById(id);
    }
}
