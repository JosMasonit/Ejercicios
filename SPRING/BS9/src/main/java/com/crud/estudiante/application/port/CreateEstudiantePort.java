package com.crud.estudiante.application.port;

import com.crud.estudiante.infraestructure.dto.EstudianteInputDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;

public interface CreateEstudiantePort {
    EstudianteOutputDTO addEstudiante(EstudianteInputDTO estudianteIDTO);
}
