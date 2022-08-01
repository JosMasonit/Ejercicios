package com.crud.estudiante_asignatura.application.port;

import com.crud.estudiante_asignatura.infraestructure.dto.CreateE_A_InputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_OutputDTO;

import java.util.List;

public interface CreateE_A_Port {
    List<E_A_OutputDTO> addAsignaturas(CreateE_A_InputDTO createEAInputDTO);
}
