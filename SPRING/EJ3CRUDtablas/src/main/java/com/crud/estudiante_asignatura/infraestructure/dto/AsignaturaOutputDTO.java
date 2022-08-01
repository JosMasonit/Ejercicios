package com.crud.estudiante_asignatura.infraestructure.dto;

import com.crud.estudiante_asignatura.domain.EstudianteAsignaturaEntity;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
public class AsignaturaOutputDTO {

    private String id_estudiante_asignatura;
    private String idAsignatura;
    private String asignatura;
    private String idProfesor;
    private String coments;
    private Date initial_date;
    private Date finish_date;

    public AsignaturaOutputDTO(){

    }

    public AsignaturaOutputDTO(EstudianteAsignaturaEntity eaEntity){
        setId_estudiante_asignatura(eaEntity.getId_estudiante_asignatura());
        setIdAsignatura(eaEntity.getId_asignatura());
        setAsignatura(eaEntity.getAsignatura());
        setIdProfesor(eaEntity.getId_profesor().getId_profesor());
        setComents(eaEntity.getComents());
        setInitial_date(eaEntity.getInitial_date());
        setFinish_date(eaEntity.getFinish_date());
    }
}
