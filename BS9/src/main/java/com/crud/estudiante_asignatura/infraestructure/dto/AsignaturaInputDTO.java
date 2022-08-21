package com.crud.estudiante_asignatura.infraestructure.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AsignaturaInputDTO {

    private String idAsignatura;
    private String asignatura;
    private String idProfesor;
    private Date initial_date;
}
