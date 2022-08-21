package com.crud.estudiante_asignatura.infraestructure.dto;

import com.crud.estudiante_asignatura.domain.EstudianteAsignaturaEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class E_A_OutputDTO implements Serializable {

    private String id_estudiante_asignatura;
    private String id_estudiante;
    private String id_profesor;
    private String id_asignatura;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;


    public E_A_OutputDTO(){

    }

    public E_A_OutputDTO(EstudianteAsignaturaEntity estudiante){
        setId_estudiante_asignatura(estudiante.getId_estudiante_asignatura());
        setId_estudiante(estudiante.getEstudiante().getId_estudiante());
        setId_profesor(estudiante.getId_profesor().getId_profesor());
        setId_asignatura(estudiante.getId_asignatura());
        setAsignatura(estudiante.getAsignatura());
        setComents(estudiante.getComents());
        setInitial_date(estudiante.getInitial_date());
        setFinish_date(estudiante.getFinish_date());

    }
}
