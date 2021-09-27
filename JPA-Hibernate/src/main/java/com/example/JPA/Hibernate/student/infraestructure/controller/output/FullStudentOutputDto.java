package com.example.JPA.Hibernate.student.infraestructure.controller.output;

import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.StudentAsignaturaOutputDto;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.student.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class FullStudentOutputDto extends StudentOutputDto{

    PersonaOutputDto personaOutputDto;
    //String idProfesor,
    String branch;
    List<StudentAsignaturaOutputDto> asignaturas;

    public FullStudentOutputDto(Student student) {
        super(student);

        this.setPersonaOutputDto(new PersonaOutputDto(student.getPersona()));
        //this.setIdProfesor(s.getIdProfesor());
        this.setBranch(student.getBranch());
        this.setAsignaturas(student.getAsignaturas().stream().map(l -> new StudentAsignaturaOutputDto(l)).collect(Collectors.toList()));
    }
}
