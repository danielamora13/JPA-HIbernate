package com.example.JPA.Hibernate.student.infraestructure.controller.input;


import com.example.JPA.Hibernate.student.domain.Estudiante;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EstudianteInputDto {

    @NotNull(message = "El id de persona no puede estar vacío")
    public String idPersona;

    @NotNull(message = "El numero de horas no puede estar vacío")
    public int numHoursWeek;
    public String comments;

    @NotNull(message = "El id de profesor no puede estar vacío")
    public String idProfesor;

    @NotNull(message = "La rama no puede estar vacía")
    public String branch;

    public Estudiante studentInputDto() {
        Estudiante estudiante = new Estudiante();
        //s.setPersona(this.idPersona);
        estudiante.setNumHoursWeek(this.numHoursWeek);
        estudiante.setComments(this.comments);
        //s.idProfesor(this.idProfesor);
        estudiante.setBranch(this.branch);
        return estudiante;
    }
}
