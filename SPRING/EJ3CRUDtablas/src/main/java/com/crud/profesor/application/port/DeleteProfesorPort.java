package com.crud.profesor.application.port;

import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;

public interface DeleteProfesorPort {
    ProfesorOutputDTO borrarProfesor(String id) throws Exception;
}
