package com.crud.profesor.infraestructure.dto;

import com.crud.profesor.domain.ProfesorEntity;
import lombok.Data;

@Data
public class ProfesorOutputDTO {

    private String id_profesor;
    private String id_persona;
    private String coments;
    private String branch;


    public ProfesorOutputDTO(){

    }
    public ProfesorOutputDTO(ProfesorEntity profesor){
        setId_profesor(profesor.getId_profesor());
        setId_persona(profesor.getId_persona().getId_persona());
        setComents(profesor.getComents());
        setBranch(profesor.getBranch());
    }
}
