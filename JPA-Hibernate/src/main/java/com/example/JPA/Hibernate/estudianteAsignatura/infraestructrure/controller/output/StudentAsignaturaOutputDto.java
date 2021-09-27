package com.example.JPA.Hibernate.estudianteAsignatura.infraestructrure.controller.output;

import com.example.JPA.Hibernate.estudianteAsignatura.domain.StudentAsignatura;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class StudentAsignaturaOutputDto {
    public String id;
    //public String idStudent;
    public String asignatura;
    public String comments;
    public Date initialDate;
    public Date finishDate;

    public StudentAsignaturaOutputDto(StudentAsignatura studentAsignatura) {
        if (studentAsignatura == null) {
            return;
        }
        this.setId(studentAsignatura.getId());
        this.setAsignatura(studentAsignatura.getAsignatura());
        this.setComments(studentAsignatura.getComments());
        this.setInitialDate(studentAsignatura.getInitialDate());
        this.setFinishDate(studentAsignatura.getFinishDate());
    }
}
