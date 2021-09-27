package com.example.JPA.Hibernate.profesor.infraestructure.controller.output;

import com.example.JPA.Hibernate.profesor.domain.Profesor;
import com.example.JPA.Hibernate.student.domain.Student;
import com.example.JPA.Hibernate.student.infraestructure.controller.output.StudentOutputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProfesorOutputDto {
     String idProfesor;
     //String idPersona;
     String comments;
     //List<StudentOutputDto> Students;
     String branch;

     public ProfesorOutputDto(Profesor profesor) {
         if (profesor == null) {
             return;
         }

         this.setIdProfesor(profesor.getIdProfesor());
         this.setComments(profesor.getComments());
         this.setBranch(profesor.getBranch());
     }

}
