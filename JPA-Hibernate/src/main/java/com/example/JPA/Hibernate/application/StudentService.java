package com.example.JPA.Hibernate.application;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.infraestructure.controller.input.StudentInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.StudentOutputDto;

import java.util.List;

public interface StudentService {
    StudentInputDto getStudent();

    StudentOutputDto anhadirStudent(StudentInputDto s) throws UnprocesableException;

    StudentOutputDto updateStudentById(StudentInputDto per, int id) throws NotFoundException, UnprocesableException;

    StudentOutputDto getStudentById(int id) throws NotFoundException;

    //List<PersonaOutputDto> getStudentByName(String name);

    List<StudentOutputDto> getStudents();

    void deleteById(int id) throws NotFoundException;
}
