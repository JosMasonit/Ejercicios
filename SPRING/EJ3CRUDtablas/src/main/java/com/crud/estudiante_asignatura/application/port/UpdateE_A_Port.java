package com.crud.estudiante_asignatura.application.port;

import com.crud.estudiante_asignatura.infraestructure.dto.E_A_InputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_OutputDTO;

public interface UpdateE_A_Port {
    E_A_OutputDTO actualizar(String id, E_A_InputDTO e_a_inputDTO);
}
