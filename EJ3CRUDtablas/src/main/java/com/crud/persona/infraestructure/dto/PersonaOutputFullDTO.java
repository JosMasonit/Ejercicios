package com.crud.persona.infraestructure.dto;

import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.persona.domain.PersonaEntity;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonaOutputFullDTO extends PersonaOutputDTO {
    private EstudianteOutputDTO estudianteOutputDTO = null;

    private ProfesorOutputDTO profesorOutputDTO = null;

    public PersonaOutputFullDTO(){

    }
    public PersonaOutputFullDTO(PersonaEntity persona){
        super(persona);
    }

    public PersonaOutputFullDTO(PersonaEntity persona, StudentEntity student){
        super(persona);
        estudianteOutputDTO = new EstudianteOutputDTO(student);
    }
    public PersonaOutputFullDTO(PersonaEntity persona, ProfesorEntity profesor){
        super(persona);
        profesorOutputDTO = new ProfesorOutputDTO(profesor);
    }
}
