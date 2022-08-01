package com.crud.persona.infraestructure.dto;

import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.persona.domain.PersonaEntity;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;

public class PersonaOutputFullProfesorDTO extends PersonaOutputDTO{

    private ProfesorOutputDTO profesorOutputDTO;

    public PersonaOutputFullProfesorDTO(){

    }

    public PersonaOutputFullProfesorDTO(PersonaEntity persona, ProfesorEntity profesor){
        super(persona);
        profesorOutputDTO = new ProfesorOutputDTO(profesor);
    }
}
