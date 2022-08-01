package com.crud.estudiante.application.port;

import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;

public interface DeleteEstudiantePort {
    EstudianteOutputDTO borrarEstudiante(String id);
}
