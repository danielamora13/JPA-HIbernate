package com.example.JPA.Hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {

    @Id
    @GeneratedValue
    Integer id;
    @Column(nullable = false)
    String user;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String name;
    String surname;
    @Column(nullable = false)
    String company_email;
    @Column(nullable = false)
    String personal_email;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    Boolean active;
    @Column(nullable = false, columnDefinition = "date")
    String created_date;
    String imagen_url;
    @Column(columnDefinition = "date")
    String termination_date;

}
