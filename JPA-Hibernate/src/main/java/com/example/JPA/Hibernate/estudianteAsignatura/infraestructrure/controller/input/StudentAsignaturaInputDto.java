package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.input;

import com.example.JPA.Hibernate.estudianteAsignatura.domain.StudentAsignatura;
import lombok.Data;

import java.util.Date;

@Data
public class StudentAsignaturaInputDto {
    public String id;
    public String idStudent;
    public String asignatura;
    public String comments;
    public Date initialDate;
    public Date finishDate;

    public StudentAsignatura studentAsignaturaInputDto() {
        StudentAsignatura studentAsignatura = new StudentAsignatura();
        studentAsignatura.setId(this.id);
        studentAsignatura.setAsignatura(this.asignatura);
        studentAsignatura.setComments(this.comments);
        studentAsignatura.setInitialDate(this.initialDate);
        studentAsignatura.setFinishDate(this.finishDate);

        return studentAsignatura;
    }
}
