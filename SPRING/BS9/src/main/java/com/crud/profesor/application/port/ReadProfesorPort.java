package com.crud.profesor.application.port;

import com.crud.persona.domain.PersonaEntity;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;

import java.util.List;

public interface ReadProfesorPort {

    List<ProfesorOutputDTO> getAll(String outputType);

    ProfesorOutputDTO findByID(String id, String outputType);

    ProfesorEntity findByIDentity(String id);

    ProfesorEntity findByIdPersona(PersonaEntity personaEntity);
}
