package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output;

import com.example.JPA.Hibernate.estudianteAsignatura.domain.EstudianteAsignatura;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class EstudianteAsignaturaOutputDto {
    public String id;
    //public String idStudent;
    public String asignatura;
    public String comments;
    public Date initialDate;
    public Date finishDate;

    public EstudianteAsignaturaOutputDto(EstudianteAsignatura estudianteAsignatura) {
        if (estudianteAsignatura == null) {
            return;
        }
        this.setId(estudianteAsignatura.getId());
        this.setAsignatura(estudianteAsignatura.getAsignatura());
        this.setComments(estudianteAsignatura.getComments());
        this.setInitialDate(estudianteAsignatura.getInitialDate());
        this.setFinishDate(estudianteAsignatura.getFinishDate());
    }
}
