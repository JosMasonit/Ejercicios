package com.crud.estudiante_asignatura.application.port;


import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante_asignatura.domain.EstudianteAsignaturaEntity;
import com.crud.estudiante_asignatura.infraestructure.dto.AsignaturasOutputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_OutputDTO;

import java.util.List;

public interface ReadE_A_Port {
    List<E_A_OutputDTO> getAll();

    E_A_OutputDTO findByID(String id);

    AsignaturasOutputDTO findByIDestudiante(String id);
}
