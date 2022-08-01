package com.crud.estudiante_asignatura.application.usecase;

import com.crud.comun.exceptions.NotFoundException;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.estudiante_asignatura.application.port.DeleteE_A_Port;
import com.crud.estudiante_asignatura.infraestructure.dto.AsignaturaOutputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.AsignaturasOutputDTO;
import com.crud.estudiante_asignatura.infraestructure.repository.EstudianteAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteE_A_UseCase implements DeleteE_A_Port {

    @Autowired
    EstudianteAsignaturaRepository eaRepo;

    public void borrarAsignaturas(List<String> listaIDs) {
        for(int i=0; i<listaIDs.size(); i++){
            eaRepo.deleteById(listaIDs.get(i));
        }
    }
}
