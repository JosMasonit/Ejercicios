package com.crud.estudiante_asignatura.application.usecase;

import com.crud.comun.exceptions.NotFoundException;
import com.crud.comun.exceptions.UnprocesableException;
import com.crud.estudiante_asignatura.application.port.UpdateE_A_Port;
import com.crud.estudiante_asignatura.domain.EstudianteAsignaturaEntity;
import com.crud.estudiante_asignatura.infraestructure.dto.AsignaturaOutputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_InputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_OutputDTO;
import com.crud.estudiante_asignatura.infraestructure.repository.EstudianteAsignaturaRepository;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import com.crud.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateE_A_UseCase implements UpdateE_A_Port {

    @Autowired
    ProfesorRepository profesorRepo;

    @Autowired
    EstudianteAsignaturaRepository estudianteAsignaturaRepository;

    public E_A_OutputDTO actualizar(String id, E_A_InputDTO e_a_inputDTO) {
        try{
            String idProfesor = e_a_inputDTO.getId_profesor();
            EstudianteAsignaturaEntity estudianteAsignaturaEntity = estudianteAsignaturaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
            ProfesorEntity profEntity=profesorRepo.findById(idProfesor).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+idProfesor));
            estudianteAsignaturaEntity.setUpdate(e_a_inputDTO, profEntity); //setAll ya se encargar de añadir solo los campos no nulos
            estudianteAsignaturaRepository.saveAndFlush(estudianteAsignaturaEntity);
            E_A_OutputDTO e_a_outputDTO = new E_A_OutputDTO(estudianteAsignaturaEntity);
            return e_a_outputDTO;

        }catch(Exception ex){
            throw new UnprocesableException("Los campos no cumplen los requisitos");
        }
    }
}
