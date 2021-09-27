package com.example.JPA.Hibernate.persona.infraestructure.controller.output;

import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.profesor.infraestructure.controller.output.FullProfesorOutputDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaProfesorOutputDto extends PersonaOutputDto {
    FullProfesorOutputDto fullProfesorOutputDto;

    public PersonaProfesorOutputDto(Persona persona) {
        super(persona);
        this.setFullProfesorOutputDto(new FullProfesorOutputDto(persona.getProfesor()));
    }
}
