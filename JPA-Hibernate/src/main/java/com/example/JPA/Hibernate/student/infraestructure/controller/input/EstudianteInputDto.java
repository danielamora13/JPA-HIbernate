package com.example.JPA.Hibernate.student.infraestructure.controller.input;


import com.example.JPA.Hibernate.student.domain.Estudiante;
import lombok.Data;

@Data
public class EstudianteInputDto {

    public String idEstudiante;
    public String idPersona;
    public int numHoursWeek;
    public String comments;
    public String idProfesor;
    public String branch;

    public Estudiante studentInputDto() {
        Estudiante estudiante = new Estudiante();
        estudiante.setIdEstudiante(this.idEstudiante);
        //s.setPersona(this.idPersona);
        estudiante.setNumHoursWeek(this.numHoursWeek);
        estudiante.setComments(this.comments);
        //s.idProfesor(this.idProfesor);
        estudiante.setBranch(this.branch);
        return estudiante;
    }
}
