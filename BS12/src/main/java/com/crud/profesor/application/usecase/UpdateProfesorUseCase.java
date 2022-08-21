package com.crud.profesor.application.usecase;

import com.crud.comun.exceptions.NotFoundException;
import com.crud.comun.exceptions.UnprocesableException;
import com.crud.profesor.application.port.UpdateProfesorPort;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorInputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import com.crud.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfesorUseCase implements UpdateProfesorPort {

    @Autowired
    ProfesorRepository profesorRepo;

    public ProfesorOutputDTO actualizar(String id, ProfesorInputDTO profesorIDTO) {
        try{
            ProfesorEntity profEntity=profesorRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
            profEntity.setUpdate(profesorIDTO); //setAll ya se encargar de añadir solo los campos no nulos
            profesorRepo.saveAndFlush(profEntity);
            ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profEntity);
            return profesorOutputDTO;

        }catch(Exception ex){
            throw new UnprocesableException("Los campos no cumplen los requisitos");
        }
    }
}
