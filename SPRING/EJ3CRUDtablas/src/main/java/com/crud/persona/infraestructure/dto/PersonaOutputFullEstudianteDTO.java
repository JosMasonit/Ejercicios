package com.crud.persona.infraestructure.dto;

import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.persona.domain.PersonaEntity;
import lombok.Data;

@Data
public class PersonaOutputFullEstudianteDTO extends PersonaOutputDTO{

    private EstudianteOutputDTO estudianteOutputDTO;

    public PersonaOutputFullEstudianteDTO(){

    }

    public PersonaOutputFullEstudianteDTO(PersonaEntity persona, StudentEntity student){
        super(persona);
        estudianteOutputDTO = new EstudianteOutputDTO(student);
    }
}
