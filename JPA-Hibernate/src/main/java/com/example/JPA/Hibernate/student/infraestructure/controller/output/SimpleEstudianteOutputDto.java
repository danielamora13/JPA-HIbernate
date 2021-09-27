package com.example.JPA.Hibernate.student.infraestructure.controller.output;

import com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output.EstudianteAsignaturaOutputDto;
import com.example.JPA.Hibernate.student.domain.Estudiante;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SimpleEstudianteOutputDto extends EstudianteOutputDto {

    List<EstudianteAsignaturaOutputDto> asignaturas;

    public SimpleEstudianteOutputDto(Estudiante estudiante) {
        super(estudiante);

        if (estudiante.getAsignaturas() != null) {
            this.setAsignaturas(estudiante.getAsignaturas().stream().map(l -> new EstudianteAsignaturaOutputDto(l)).collect(Collectors.toList()));
        }
    }
}
