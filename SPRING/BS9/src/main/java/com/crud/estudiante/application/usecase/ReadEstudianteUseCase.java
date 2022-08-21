package com.crud.estudiante.application.usecase;

import com.crud.comun.exceptions.NotFoundException;
import com.crud.estudiante.application.port.ReadEstudiantePort;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputFullDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputSimpleDTO;
import com.crud.estudiante.infraestructure.repository.StudentRepository;
import com.crud.persona.domain.PersonaEntity;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputFullDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadEstudianteUseCase implements ReadEstudiantePort {
    @Autowired
    StudentRepository estudianteRepo;


    public EstudianteOutputDTO findByID(String id, String outputType) {
        StudentEntity pEntity=estudianteRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        if(outputType.equalsIgnoreCase("simple")){
            EstudianteOutputSimpleDTO estudianteOutputSimpleDTO = new EstudianteOutputSimpleDTO(pEntity);
            return estudianteOutputSimpleDTO;
        }else{
            EstudianteOutputFullDTO estudianteOutputFullDTO = new EstudianteOutputFullDTO(pEntity);
            return estudianteOutputFullDTO;
        }
    }

    public List<EstudianteOutputDTO> getAll(String outputType){
        List<StudentEntity> listaEntity = estudianteRepo.findAll();
        List<EstudianteOutputDTO> listaOutput = new ArrayList();
        if(outputType.equalsIgnoreCase("simple")){
            for(int i=0; i< listaEntity.size(); i++){
                EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(listaEntity.get(i));
                listaOutput.add(estudianteOutputDTO);
            }
            return listaOutput;
        }else{
            for(int i=0; i< listaEntity.size(); i++){
                EstudianteOutputFullDTO estudianteOutputFullDTO = new EstudianteOutputFullDTO(listaEntity.get(i));
                listaOutput.add(estudianteOutputFullDTO);
            }
            return listaOutput;
        }
    }

    public StudentEntity findByIdPersona(PersonaEntity personaEntity) {
        StudentEntity studentEntity;
        studentEntity=estudianteRepo.findByIdPersona(personaEntity);
        return studentEntity;
    }

    //Esto al final se a hecho con @Query
 /*   public List<String> getAllIdPersonaEstudiante(){
    List<StudentEntity> listaEntity = estudianteRepo.findAll();
    List<String> lista = new ArrayList();
    for(int i=0; i< listaEntity.size(); i++){
        String id_persona = (listaEntity.get(i).getId_persona().getId_persona());
        lista.add(id_persona);
    }
    return lista;
} */
}
