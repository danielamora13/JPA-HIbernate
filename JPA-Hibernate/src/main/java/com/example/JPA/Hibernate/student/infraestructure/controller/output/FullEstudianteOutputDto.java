package com.example.JPA.Hibernate.student.infraestructure.controller.output;

import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.EstudianteAsignaturaOutputDto;
import com.example.JPA.Hibernate.persona.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.student.domain.Estudiante;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class FullEstudianteOutputDto extends EstudianteOutputDto {

    PersonaOutputDto personaOutputDto;
    //String idProfesor,
    String branch;
    List<EstudianteAsignaturaOutputDto> asignaturas;

    public FullEstudianteOutputDto(Estudiante estudiante) {
        super(estudiante);

        this.setPersonaOutputDto(new PersonaOutputDto(estudiante.getPersona()));
        //this.setIdProfesor(s.getIdProfesor());
        this.setBranch(estudiante.getBranch());
        this.setAsignaturas(estudiante.getAsignaturas().stream().map(l -> new EstudianteAsignaturaOutputDto(l)).collect(Collectors.toList()));
    }
}
