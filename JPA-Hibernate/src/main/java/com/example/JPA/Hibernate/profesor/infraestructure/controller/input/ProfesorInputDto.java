package com.example.JPA.Hibernate.profesor.infraestructure.controller.input;

import com.example.JPA.Hibernate.profesor.domain.Profesor;
import lombok.Data;

@Data
public class ProfesorInputDto {
    public String idPersona;
    public String comments;
    //public List<String> idStudents;
    public String branch;

    public Profesor profesorInputDto() {
        Profesor profesor = new Profesor();
        profesor.setComments(this.comments);
        profesor.setBranch(this.branch);

        return profesor;
    }

}
