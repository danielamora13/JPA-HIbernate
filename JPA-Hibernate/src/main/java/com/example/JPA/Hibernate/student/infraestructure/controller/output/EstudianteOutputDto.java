package com.example.JPA.Hibernate.student.infraestructure.controller.output;

import com.example.JPA.Hibernate.student.domain.Estudiante;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class EstudianteOutputDto {
    String idStudent;
    int numHoursWeek;
    String comments;

    public EstudianteOutputDto(Estudiante estudiante) {
        if (estudiante == null) {
            return;
        }
        this.setIdStudent(estudiante.getIdEstudiante());
        this.setNumHoursWeek(estudiante.getNumHoursWeek());
        this.setComments(estudiante.getComments());
    }
}
