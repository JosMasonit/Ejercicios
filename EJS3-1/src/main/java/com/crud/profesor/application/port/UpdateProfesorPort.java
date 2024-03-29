package com.crud.profesor.application.port;

import com.crud.profesor.infraestructure.dto.ProfesorInputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;

public interface UpdateProfesorPort {
    ProfesorOutputDTO actualizar(String id, ProfesorInputDTO profesorIDTO);
}
