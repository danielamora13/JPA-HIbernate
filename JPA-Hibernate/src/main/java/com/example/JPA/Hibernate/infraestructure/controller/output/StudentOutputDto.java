package com.example.JPA.Hibernate.infraestructure.controller.output;

import com.example.JPA.Hibernate.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentOutputDto {
    int idStudent;
    PersonaOutputDto personaOutputDto;
    int numHoursWeek;
    String comments;
    //String idProfesor,
    String branch;

    public StudentOutputDto(Student s) {
        if (s == null) {
            return;
        }
        this.setIdStudent(s.getIdStudent());
        this.setPersonaOutputDto(new PersonaOutputDto(s.getPersona()));
        this.setNumHoursWeek(s.getNumHoursWeek());
        this.setComments(s.getComments());
        //this.setIdProfesor(s.getIdProfesor());
        this.setBranch(s.getBranch());
    }
}
