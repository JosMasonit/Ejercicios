package com.crud.estudiante_asignatura.infraestructure.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateE_A_InputDTO {

    private String id_estudiante;

    private List<AsignaturaInputDTO> listaAsignaturas;

}
