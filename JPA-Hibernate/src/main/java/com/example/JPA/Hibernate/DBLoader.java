package com.example.JPA.Hibernate;

import com.example.JPA.Hibernate.persona.domain.Persona;
import com.example.JPA.Hibernate.persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class DBLoader implements ApplicationRunner {

    private final PersonaRepository personaRepository;

    @Autowired
    DBLoader(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }


    public void run(ApplicationArguments applicationArguments) throws Exception {

        String[] citys = {
                "op and running with %s",
                "%s Basics",
                "%s for Beginners",
                "%s for Neckbeards",
                "Under the hood: %s",
                "Discovering %s",
                "A short guide to %s",
                "%s with Baeldung"
        };

        String[] users = {
                "Spring REST Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate",
                "Spring HATEOS",
                "The HAL Browser",
                "Spring webflux",
        };

        String[] names = {
                "John %s",
                "Steve %s",
                "Samantha %s",
                "Gale %s",
                "Tom %s"
        };

        String[] passwords = {
                "qqqq",
                "Gilwwwwl",
                "wwww",
                "Armeeeeestrong"
        };

        String[] surnames = {
                "Giles",
                "Gill",
                "Smith",
                "Armstrong"
        };

        Boolean[] actives = {
                false,
                true
        };

        String[] company_emails = {
                "Giles@ddd.com",
                "dsa@ddd.com",
                "asfsa@kadgfad.com",
                "Armstrong@dd.com"
        };

        String[] personal_emails = {
                "ss@Giles.com",
                "ejemplo@Gill.com",
                "Smith@ejemplo.com",
                "Armstrong@whynot.com"
        };

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date[] created_dates = {
                format.parse ( "2009-12-31" ),
                format.parse("2021-10-11")
        };

        Date[] termination_dates = {
                format.parse ( "2030-12-31" ),
                format.parse("2031-10-11")
        };

        String[] imagen_urls = {
                "ss@Giles.com",
                "ejemplo@Gill.com",
                "Smith@ejemplo.com",
                "Armstrong@whynot.com"
        };

        Random random = new Random();

        IntStream.range(0, 100)
                .forEach(i -> {
                    String user = users[i % users.length];
                    String password = passwords[i % passwords.length];
                    String name = names[i % names.length];
                    String surname = surnames[i % surnames.length];
                    String company_email = company_emails[i % company_emails.length];
                    String personal_email = personal_emails[i % personal_emails.length];
                    Boolean active = actives[i % actives.length];
                    String city = citys[i % citys.length];
                    Date created_date = created_dates[i % created_dates.length];
                    String imagen_url = imagen_urls[i % imagen_urls.length];
                    Date termination_date = termination_dates[i % termination_dates.length];

                    Persona persona = new Persona(user, password, name, surname, company_email, personal_email,
                            city, active, created_date, imagen_url, termination_date);

                    personaRepository.save(persona);

                    System.out.println(persona);

                });



    }
}
