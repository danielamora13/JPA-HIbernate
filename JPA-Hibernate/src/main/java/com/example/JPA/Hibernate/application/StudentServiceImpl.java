package com.example.JPA.Hibernate.application;

import com.example.JPA.Hibernate.domain.Persona;
import com.example.JPA.Hibernate.domain.Student;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.infraestructure.controller.input.StudentInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.StudentOutputDto;
import com.example.JPA.Hibernate.infraestructure.repository.PersonaRepository;
import com.example.JPA.Hibernate.infraestructure.repository.StudentRepository;
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

    @Override
    public StudentInputDto getStudent() {
        return studentInputDto;
    }

    @Override
    public StudentOutputDto anhadirStudent(StudentInputDto s) throws UnprocesableException, NotFoundException {
        if (s == null) {
            return null;
        }
        if (s.numHoursWeek == 0 || s.branch == null) {
            throw new UnprocesableException("Alguno de los campos necesarios está vacío");
        }

        Student stu = s.studentInputDto();
        Persona p = personaRepository.findById(s.idPersona).orElseThrow(() ->
                new NotFoundException("Persona con id "+s.idPersona+" no encontrada"));
        stu.setPersona(p);
        studentRepository.save(stu);

        return new StudentOutputDto(stu);
    }

    @Override
    public StudentOutputDto updateStudentById(StudentInputDto s, int id) throws NotFoundException, UnprocesableException {
        if (s == null) {
            return null;
        }
        if (s.numHoursWeek == 0 || s.branch == null) {
            throw new UnprocesableException("Alguno de los campos necesarios está vacío");
        }
        Student stu = studentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Estudiante con id "+id+" no encontrado"));
        stu.setStudent(s);

        studentRepository.save(stu);
        return new StudentOutputDto(stu);
    }

    @Override
    public StudentOutputDto getStudentById(int id) throws NotFoundException {
        return new StudentOutputDto(studentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Esrudiante con id "+id+" no encontrado")));
    }

    @Override
    public List<StudentOutputDto> getStudents() {

        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentOutputDto::new).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) throws NotFoundException {

        studentRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Estudiante con id "+id+" no encontrado"));

        studentRepository.deleteById(id);
    }
}
