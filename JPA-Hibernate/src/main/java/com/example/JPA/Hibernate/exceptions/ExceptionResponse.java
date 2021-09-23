package com.example.JPA.Hibernate.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String mensaje;
    private int httpCode;

    public ExceptionResponse(Date timestamp, String message, int httpCode) {
        super();
        this.timestamp = timestamp;
        this.mensaje = message;
        this.httpCode=httpCode;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

}
