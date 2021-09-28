package com.example.JPA.Hibernate.profesor.infraestructure.controller.input;

import com.example.JPA.Hibernate.profesor.domain.Profesor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProfesorInputDto {

    @NotNull(message = "El id de persona no puede estar vacío")
    public String idPersona;
    public String comments;

    @NotNull(message = "La rama no puede estar vacía")
    public String branch;

    public Profesor profesorInputDto() {
        Profesor profesor = new Profesor();
        profesor.setComments(this.comments);
        profesor.setBranch(this.branch);

        return profesor;
    }

}
