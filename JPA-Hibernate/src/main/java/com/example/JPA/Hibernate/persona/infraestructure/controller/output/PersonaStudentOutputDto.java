package com.example.JPA.Hibernate.persona.infraestructure.controller.output;

import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.SimpleEstudianteOutputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaStudentOutputDto extends PersonaOutputDto {
    SimpleEstudianteOutputDto simpleStudentOutputDto;

    public PersonaStudentOutputDto (Persona persona) {
        super(persona);
        this.setSimpleStudentOutputDto(new SimpleEstudianteOutputDto(persona.getEstudiante()));
    }
}
