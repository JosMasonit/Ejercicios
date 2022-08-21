package com.crud.estudiante.application.port;

import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.persona.domain.PersonaEntity;

import java.util.List;

public interface ReadEstudiantePort {
    List<EstudianteOutputDTO> getAll(String outputType);

    EstudianteOutputDTO findByID(String id, String outputType);

    StudentEntity findByIdPersona(PersonaEntity personaEntity);

}
