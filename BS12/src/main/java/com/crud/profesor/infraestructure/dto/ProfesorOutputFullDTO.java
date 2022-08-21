package com.crud.profesor.infraestructure.dto;

import com.crud.persona.infraestructure.dto.PersonaOutputDTO;
import com.crud.profesor.domain.ProfesorEntity;
import lombok.Data;

@Data
public class ProfesorOutputFullDTO extends ProfesorOutputDTO{

    private PersonaOutputDTO personaOutputDTO;



    public ProfesorOutputFullDTO(){

    }
    public ProfesorOutputFullDTO(ProfesorEntity profesor){
        super(profesor);
        personaOutputDTO = new PersonaOutputDTO(profesor.getId_persona());
    }
}
