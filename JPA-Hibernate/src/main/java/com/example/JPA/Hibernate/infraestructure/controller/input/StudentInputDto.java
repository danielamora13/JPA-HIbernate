package com.example.JPA.Hibernate.infraestructure.controller.input;

import com.example.JPA.Hibernate.domain.Persona;
import com.example.JPA.Hibernate.domain.Student;
import lombok.Data;

@Data
public class StudentInputDto {

    public int idStudent;
    public int idPersona;
    public int numHoursWeek;
    public String comments;
    //public String idProfesor,
    public String branch;

    public Student studentInputDto() {
        Student s = new Student();
        //s.setPersona(this.idPersona);
        s.setNumHoursWeek(this.numHoursWeek);
        s.setComments(this.comments);
        //s.idProfesor(this.idProfesor);
        s.setBranch(this.branch);
        return s;
    }
}
