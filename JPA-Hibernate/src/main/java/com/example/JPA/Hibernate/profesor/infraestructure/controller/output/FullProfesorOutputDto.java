package com.example.JPA.Hibernate.profesor.infraestructure.controller.output;

import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleEstudianteOutputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class FullProfesorOutputDto extends ProfesorOutputDto{
    List<SimpleEstudianteOutputDto> Students;


    public FullProfesorOutputDto(Profesor profesor) {
        super(profesor);
        this.setStudents(profesor.getEstudiantes().stream().map(l -> new SimpleEstudianteOutputDto(l)).collect(Collectors.toList()));
    }

}
