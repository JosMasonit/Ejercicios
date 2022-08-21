package com.crud.estudiante.infraestructure.dto;

import com.crud.comun.exceptions.NotFoundException;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.persona.application.usecase.PersonaService;
import com.crud.persona.domain.PersonaEntity;
import com.crud.persona.infraestructure.dto.PersonaOutputDTO;
import com.crud.persona.infraestructure.repository.PersonaRepositorio;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
public class EstudianteInputDTO {
    private String id_estudiante;
    private String id_persona;
    private Integer num_hours_week;
    private String coments;
    private String id_profesor;
    private String branch;


    public EstudianteInputDTO(){

    }
    /*
    public EstudianteInputDTO(String id_estudiante, String id_persona){
        setId_estudiante(id_estudiante);
        setId_persona(id_persona);
    }*/

}
