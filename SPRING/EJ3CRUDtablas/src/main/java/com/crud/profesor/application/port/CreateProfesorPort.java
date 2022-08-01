package com.crud.profesor.application.port;

import com.crud.profesor.infraestructure.dto.ProfesorInputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;

public interface CreateProfesorPort {
    ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorIDTO);
}
