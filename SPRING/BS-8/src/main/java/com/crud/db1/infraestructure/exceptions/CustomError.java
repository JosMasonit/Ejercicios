package com.crud.db1.infraestructure.exceptions;

import java.util.Date;

public class CustomError {
    private Date timestamp;
    private int httpCode;
    private String mensaje;

    public CustomError(Date timestamp, int httpCode, String mensaje){
        super();
        this.timestamp=timestamp;
        this.mensaje=mensaje;
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
