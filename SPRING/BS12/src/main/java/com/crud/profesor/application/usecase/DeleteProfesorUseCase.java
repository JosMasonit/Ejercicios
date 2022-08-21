package com.crud.profesor.application.usecase;

import com.crud.comun.exceptions.NotFoundException;

import com.crud.profesor.application.port.DeleteProfesorPort;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import com.crud.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfesorUseCase implements DeleteProfesorPort {

    @Autowired
    ProfesorRepository profesorRepo;

    public ProfesorOutputDTO borrarProfesor(String id) {
        ProfesorEntity profesorEntity = profesorRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesorEntity);
        profesorRepo.deleteById(id);
        return profesorOutputDTO;
    }

}
