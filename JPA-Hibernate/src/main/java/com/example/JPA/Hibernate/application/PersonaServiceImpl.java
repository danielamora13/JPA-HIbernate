package com.example.JPA.Hibernate.application;

import com.example.JPA.Hibernate.domain.Persona;
import com.example.JPA.Hibernate.infraestructure.controller.input.PersonaInputDto;
import com.example.JPA.Hibernate.infraestructure.controller.output.PersonaOutputDto;
import com.example.JPA.Hibernate.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    PersonaInputDto personaInputDto = new PersonaInputDto();

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaInputDto getPersona()
    {
        return  personaInputDto;
    }

    /**
     * Metodo para anhadir a un usurario a la tabla persona.
     * @param per usuario a anhadir.
     * @return el usuarioi que se ha anhadido.
     * @throws Exception si los email no son validos o no lo es el nombre de usuario.
     */
    public PersonaOutputDto anhadirPersona(PersonaInputDto per) throws Exception {
        if (per == null) {
            return null;
        }
        if (!per.getCompany_email().contains("@")) {
            throw new Exception("El email de compañia no es valido");
        }
        if (!per.getPersonal_email().contains("@")) {
            throw new Exception("El email personal no es valido");
        }

        if (per.getUser().length() < 6 || per.getUser().length() > 10) {
            throw new Exception("El nombre de usuario no es valido");
        }
        Persona p = per.personaInputDto();
        personaRepository.save(p);

        return new PersonaOutputDto(p);
    }

    /**
     * Metodo para actualizar los datos de un usuario en la tabla persona
     * @param per datos nuevos del usuario
     * @param id id del usuario a actualizar
     * @return usuario actualizado
     * @throws Exception si los email no son validos o no lo es el nombre de usuario o el usuario
     * con el id no existe.
     */
    public PersonaOutputDto updatePersonaById(PersonaInputDto per, int id) throws Exception {
        if (per == null) {
            return null;
        }
        if (!per.getCompany_email().contains("@")) {
            throw new Exception("El email de compañia no es valido");
        }
        if (!per.getPersonal_email().contains("@")) {
            throw new Exception("El email personal no es valido");
        }
        if (per.getUser().length() < 6 || per.getUser().length() > 10) {
            throw new Exception("El nombre de usuario no es valido");
        }
        Persona person = personaRepository.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
        person.setPersona(per);

        personaRepository.save(person);

        PersonaOutputDto personaOutputDto = new PersonaOutputDto(person);

        return personaOutputDto;

    }

    /**
     * Metodo que encuentra a un usuario dado su id
     * @param id id del usuario a encontrar
     * @return el usuario buscado
     * @throws Exception si no hay ningun usuario con ese id
     */
    public PersonaOutputDto getPersonaById(int id) throws Exception {
        return new PersonaOutputDto(personaRepository.findById(id).orElseThrow(() -> new Exception("No encontrado")));
    }

    /**
     * Metodo que encuentra a los usuarios dado su nombre
     * @param name nombre de los usuarios a encontrar
     * @return los usuarios buscados
     */
    public List<PersonaOutputDto> getPersonaByName(String name){
        List<Persona> personas = personaRepository.findByName(name);
        return personas.stream().map(l -> new PersonaOutputDto(l)).collect(Collectors.toList());
    }

    /**
     * Metodo que devuelve la listsa de usuarios de la tabla persona
     * @return lista de usuarios de la tabla persona
     */
    public List<PersonaOutputDto> getPersonas() {
        List<Persona> personas = personaRepository.findAll();
        return personas.stream().map(PersonaOutputDto::new).collect(Collectors.toList());
    }

    /**
     * Metodo que borra a un usuario
     * @param id id del usuario a borrar
     */
    public void deleteById(int id) throws Exception {

        personaRepository.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));

        personaRepository.deleteById(id);
    }



}
