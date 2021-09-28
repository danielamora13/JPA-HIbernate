package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input;

import com.example.JPA.Hibernate.estudianteAsignatura.domain.EstudianteAsignatura;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class EstudianteAsignaturaInputDto {
    public List<String> idEstudiantes;
    public String asignatura;
    public String comments;

    @NotNull(message = "La fecha inicial no puede estar vacía")
    public Date initialDate;
    public Date finishDate;

    public EstudianteAsignatura estudianteAsignaturaInputDto() {
        EstudianteAsignatura estudianteAsignatura = new EstudianteAsignatura();
        estudianteAsignatura.setAsignatura(this.asignatura);
        estudianteAsignatura.setComments(this.comments);
        estudianteAsignatura.setInitialDate(this.initialDate);
        estudianteAsignatura.setFinishDate(this.finishDate);

        return estudianteAsignatura;
    }
}
