package com.example.JPA.Hibernate.persona.infraestructure.controller.output;

import com.example.JPA.Hibernate.profesor.infraestructure.controller.output.ProfesorOutputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaProfesorOutputDto extends PersonaOutputDto {
    ProfesorOutputDto profesorOutputDto;
}
