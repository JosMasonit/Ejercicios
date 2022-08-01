package com.crud.estudiante_asignatura.application.port;

import java.util.List;

public interface DeleteE_A_Port {
    void borrarAsignaturas(List<String> listaIDs);
}
