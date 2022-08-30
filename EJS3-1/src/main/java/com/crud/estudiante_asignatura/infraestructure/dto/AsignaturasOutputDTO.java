package com.crud.estudiante_asignatura.infraestructure.dto;

import com.crud.estudiante_asignatura.domain.EstudianteAsignaturaEntity;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
public class AsignaturasOutputDTO {

    private String id_estudiante;

    private List<AsignaturaOutputDTO> listaAsignaturas;

    public AsignaturasOutputDTO(String estudiante){
        setId_estudiante(estudiante);
    }
}
