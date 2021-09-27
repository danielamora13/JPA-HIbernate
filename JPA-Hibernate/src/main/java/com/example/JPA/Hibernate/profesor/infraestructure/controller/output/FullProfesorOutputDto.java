package com.example.JPA.Hibernate.profesor.infraestructure.controller.output;

import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleStudentOutputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class FullProfesorOutputDto extends ProfesorOutputDto{
    List<SimpleStudentOutputDto> Students;


    public FullProfesorOutputDto(Profesor profesor) {
        super();
        this.setStudents(profesor.getStudents().stream().map(l -> new SimpleStudentOutputDto(l)).collect(Collectors.toList()));
    }

}
