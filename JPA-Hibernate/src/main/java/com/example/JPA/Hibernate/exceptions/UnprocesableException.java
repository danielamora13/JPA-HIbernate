package com.example.JPA.Hibernate.exceptions;

public class UnprocesableException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UnprocesableException(String message) {
        super(message);
    }
}
