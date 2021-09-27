package com.example.JPA.Hibernate.estudianteAsignatura.application;

import com.example.JPA.Hibernate.estudianteAsignatura.domain.StudentAsignatura;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input.StudentAsignaturaInputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.StudentAsignaturaOutputDto;
import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.repository.StudentAsignaturaRepository;
import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.student.domain.Student;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleStudentOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentAsignaturaServiceImpl implements StudentAsignaturaService{

    StudentAsignaturaInputDto studentAsignaturaInputDto = new StudentAsignaturaInputDto();

    @Autowired
    StudentAsignaturaRepository studentAsignaturaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentAsignaturaInputDto getAsignatura() {
        return studentAsignaturaInputDto;
    }

    @Override
    public StudentAsignaturaOutputDto anhadirAsignatura(StudentAsignaturaInputDto studentAsignaturaInputDto) throws UnprocesableException {
        if (studentAsignaturaInputDto == null) {
            return null;
        }
        if (studentAsignaturaInputDto.initialDate == null) {
            throw new UnprocesableException("Alguno de los campos necesarios está vacío");
        }

        StudentAsignatura studentAsignatura= studentAsignaturaInputDto.studentAsignaturaInputDto();

        if (studentAsignaturaInputDto.idStudent != null) {
            Student student = studentRepository.findById(studentAsignaturaInputDto.idStudent).orElseThrow(() ->
                    new NotFoundException("Estudiante con id "+studentAsignaturaInputDto.idStudent+" no encontrado"));

            student.getAsignaturas().add(studentAsignatura);
            studentAsignatura.setStudent(student);
        }

        studentAsignaturaRepository.save(studentAsignatura);

        return new StudentAsignaturaOutputDto(studentAsignatura);
    }

    @Override
    public StudentAsignaturaOutputDto updateAsignaturaById(StudentAsignaturaInputDto studentAsignaturaInputDto, String id) throws NotFoundException, UnprocesableException {
        if (studentAsignaturaInputDto == null) {
            return null;
        }

        StudentAsignatura studentAsignatura = studentAsignaturaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Asignatura con id "+id+" no encontrada"));
        studentAsignatura.setStudentAsignatura(studentAsignaturaInputDto);

        if (studentAsignaturaInputDto.idStudent != null) {
            Student studentAnterior = studentRepository.findById(studentAsignatura.getStudent().getIdStudent()).orElseThrow(() ->
                    new NotFoundException("Estudiante con id "+studentAsignaturaInputDto.idStudent+" no encontrado"));

            Student student = studentRepository.findById(studentAsignaturaInputDto.idStudent).orElseThrow(() ->
                    new NotFoundException("Estudiante con id "+studentAsignaturaInputDto.idStudent+" no encontrado"));

            studentAnterior.getAsignaturas().remove(studentAsignatura);
            student.getAsignaturas().add(studentAsignatura);
            studentAsignatura.setStudent(student);
        }

        studentAsignaturaRepository.save(studentAsignatura);

        return new StudentAsignaturaOutputDto(studentAsignatura);
    }

    @Override
    public StudentAsignaturaOutputDto getAsignaturaById(String id) throws NotFoundException {
        return new StudentAsignaturaOutputDto(studentAsignaturaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Asignatura con id "+id+" no encontrada")));
    }

    @Override
    public List<StudentAsignaturaOutputDto> getAsignaturas() {
        List<StudentAsignatura> asignaturas = studentAsignaturaRepository.findAll();
        return asignaturas.stream().map(StudentAsignaturaOutputDto::new).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        studentAsignaturaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Asignatura con id "+id+" no encontrada"));

        studentAsignaturaRepository.deleteById(id);
    }
}
