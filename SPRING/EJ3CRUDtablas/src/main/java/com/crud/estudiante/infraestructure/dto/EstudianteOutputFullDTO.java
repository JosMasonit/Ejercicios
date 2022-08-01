package com.crud.estudiante.infraestructure.dto;

import com.crud.estudiante.domain.StudentEntity;
import com.crud.persona.infraestructure.dto.PersonaOutputDTO;
import lombok.Data;

@Data
public class EstudianteOutputFullDTO extends EstudianteOutputDTO{
    private PersonaOutputDTO personaOutputDTO;

    public EstudianteOutputFullDTO(StudentEntity studentEntity){
        super(studentEntity);
        personaOutputDTO= new PersonaOutputDTO(studentEntity.getId_persona());
    }
}
