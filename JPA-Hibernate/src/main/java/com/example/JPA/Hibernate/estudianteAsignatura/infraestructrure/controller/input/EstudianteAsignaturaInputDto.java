package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input;

import com.example.JPA.Hibernate.estudianteAsignatura.domain.EstudianteAsignatura;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EstudianteAsignaturaInputDto {
    public String id;
    public List<String> idEstudiantes;
    public String asignatura;
    public String comments;
    public Date initialDate;
    public Date finishDate;

    public EstudianteAsignatura estudianteAsignaturaInputDto() {
        EstudianteAsignatura estudianteAsignatura = new EstudianteAsignatura();
        estudianteAsignatura.setId(this.id);
        estudianteAsignatura.setAsignatura(this.asignatura);
        estudianteAsignatura.setComments(this.comments);
        estudianteAsignatura.setInitialDate(this.initialDate);
        estudianteAsignatura.setFinishDate(this.finishDate);

        return estudianteAsignatura;
    }
}
