package com.crud.estudiante.infraestructure.dto;

import com.crud.estudiante.domain.StudentEntity;
import lombok.Data;

@Data
public class EstudianteOutputDTO {
    private String id_estudiante;
    private String id_persona;
    private int num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;

    public EstudianteOutputDTO(){

    }
    public EstudianteOutputDTO(StudentEntity student){
        setId_estudiante(student.getId_estudiante());
        setId_persona(student.getId_persona().getId_persona());
        setNum_hours_week(student.getNum_hours_week());
        setComents(student.getComents());
        setId_profesor(student.getId_profesor().getId_profesor());
        setBranch(student.getBranch());
    }
}
