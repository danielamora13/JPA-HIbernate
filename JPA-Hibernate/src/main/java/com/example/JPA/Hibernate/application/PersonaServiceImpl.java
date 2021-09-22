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
        person.setUser(per.getUser());
        person.setPassword(per.getPassword());
        person.setName(per.getName());
        person.setSurname(per.getSurname());
        person.setCompany_email(per.getCompany_email());
        person.setPersonal_email(per.getPersonal_email());
        person.setCity(per.getCity());
        person.setActive(per.getActive());
        person.setCreated_date(per.getCreated_date());
        person.setImagen_url(per.getImagen_url());
        person.setTermination_date(per.getTermination_date());
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
     * Metodo que encuentra a un usuario dado su nombre
     * @param name nombre del usuario a encontrar
     * @return el usuario buscado
     * @throws Exception si no hay ningun usuario con ese id
     */
    public PersonaOutputDto getPersonaByName(String name){
        return new PersonaOutputDto(personaRepository.findByName(name));
    }

    /**
     * Metodo que devuelve la listsa de usuarios de la tabla persona
     * @return lista de usuarios de la tabla persona
     */
    public List<PersonaOutputDto> getPersonas() {
        List<Persona> personas = personaRepository.findAll();
        List<PersonaOutputDto> personasOutputDto = new ArrayList<PersonaOutputDto>();
        PersonaOutputDto per;
        for (Persona p: personas) {
            per = new PersonaOutputDto(p);
            personasOutputDto.add(per);
        }
        return personasOutputDto;
    }

    /**
     * Metodo que borra a un usuario
     * @param id id del usuario a borrar
     */
    public void deleteById(int id) {
        personaRepository.deleteById(id);
    }



}
