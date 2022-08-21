package com.crud.profesor.application.usecase;

import com.crud.comun.exceptions.NotFoundException;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputFullDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputSimpleDTO;
import com.crud.persona.domain.PersonaEntity;
import com.crud.profesor.application.port.ReadProfesorPort;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputFullDTO;
import com.crud.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadProfesorUseCase implements ReadProfesorPort {
    
    @Autowired
    ProfesorRepository profesorRepo;
    
    
    public List<ProfesorOutputDTO> getAll(String outputType){
        List<ProfesorEntity> listaEntity = profesorRepo.findAll();
        List<ProfesorOutputDTO> listaOutput = new ArrayList();
        if(outputType.equalsIgnoreCase("simple")){
            for(int i=0; i< listaEntity.size(); i++){
                ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(listaEntity.get(i));
                listaOutput.add(profesorOutputDTO);
            }
            return listaOutput;
        }else{
            for(int i=0; i< listaEntity.size(); i++){
                ProfesorOutputFullDTO profesorOutputFullDTO = new ProfesorOutputFullDTO(listaEntity.get(i));
                listaOutput.add(profesorOutputFullDTO);
            }
            return listaOutput;
        }
    }


    public ProfesorOutputDTO findByID(String id, String outputType) {
        ProfesorEntity pEntity=profesorRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        if(outputType.equalsIgnoreCase("simple")){
            ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(pEntity);
            return profesorOutputDTO;
        }else{
            ProfesorOutputFullDTO profesorOutputFullDTO = new ProfesorOutputFullDTO(pEntity);
            return profesorOutputFullDTO;
        }
    }

    public ProfesorEntity findByIDentity(String id){
        ProfesorEntity pEntity=profesorRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        return pEntity;
    }

    public ProfesorEntity findByIdPersona(PersonaEntity personaEntity) {
        ProfesorEntity profesorEntity;
        profesorEntity=profesorRepo.findByIdPersona(personaEntity);
        return profesorEntity;
    }

}
