package com.crud.profesor.infraestructure.dto;

import lombok.Data;

@Data
public class ProfesorInputDTO {

    private String id_profesor;
    private String id_persona;
    private String coments;
    private String branch;


    public ProfesorInputDTO(){

    }
    public ProfesorInputDTO(String id_profesor, String id_persona, String coments, String branch){
        setId_profesor(id_profesor);
        setId_persona(id_persona);
        setComents(coments);
        setBranch(branch);
    }

}
