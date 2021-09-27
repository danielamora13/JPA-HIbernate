package com.example.JPA.Hibernate.student.application;

import com.example.JPA.Hibernate.exceptions.NotFoundException;
import com.example.JPA.Hibernate.exceptions.UnprocesableException;
import com.example.JPA.Hibernate.student.infraestructure.controller.input.StudentInputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.FullStudentOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleStudentOutputDto;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.StudentOutputDto;

import java.util.List;

public interface StudentService {

    StudentInputDto getStudent();

    SimpleStudentOutputDto anhadirStudent(StudentInputDto studentInputDto) throws UnprocesableException;

    SimpleStudentOutputDto updateStudentById(StudentInputDto studentInputDto, String id) throws NotFoundException, UnprocesableException;

    StudentOutputDto getStudentById(String id, String outputType) throws NotFoundException;

    //List<SimpleStudentOutputDto> getStudentByName(String name);

    List<SimpleStudentOutputDto> getStudents();

    void deleteById(String id) throws NotFoundException;
}
