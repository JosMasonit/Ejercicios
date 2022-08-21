package com.crud.profesor.application.usecase;

import com.crud.comun.exceptions.UnprocesableException;
import com.crud.estudiante.application.usecase.ReadEstudianteUseCase;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteInputDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.estudiante.infraestructure.repository.StudentRepository;
import com.crud.persona.application.usecase.PersonaService;
import com.crud.persona.domain.PersonaEntity;
import com.crud.profesor.application.port.CreateProfesorPort;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorInputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import com.crud.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateProfesorUseCase implements CreateProfesorPort {

    @Autowired
    PersonaService personaService;

    @Autowired
    ProfesorRepository profesorRepo;

    @Autowired
    ReadEstudianteUseCase readEstudianteUseCase;

    @Autowired
    ReadProfesorUseCase readProfesorUseCase;


    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorIDTO) {
        try{
            ProfesorEntity profesorEntity = new ProfesorEntity();

            System.out.println("buscarId 1");

            personaService.getAll();
            System.out.println("buscarId 2");

            String idPersona = profesorIDTO.getId_persona();
            PersonaEntity persona = personaService.findByIDentity(idPersona);


            StudentEntity posibleEstudiante = readEstudianteUseCase.findByIdPersona(persona);
            if(posibleEstudiante!=null){
                System.out.println("El id_Persona corresponde a un Estudiante");
                throw new UnprocesableException("");
            }
            ProfesorEntity posibleProfesor = readProfesorUseCase.findByIdPersona(persona);
            if(posibleProfesor!=null){
                System.out.println("El id_Persona corresponde a un Profesor");
                throw new UnprocesableException("");
            }

            //Lógica para comprobar que la persona no sea un estudiante
            /*
            List<String> lista = readEstudianteUseCase.getAllIdPersonaEstudiante();
            Boolean idOcupado = false;
            for(int i=0; i<lista.size(); i++){
                if(lista.get(i).equalsIgnoreCase(idPersona)){
                    idOcupado = true;
                }
            }
            if(idOcupado==true) throw new UnprocesableException("El id_Persona corresponde a un Estudiante"); */


            profesorEntity.setId_persona(persona);
            profesorEntity.setComents(profesorIDTO.getComents());
            profesorEntity.setBranch(profesorIDTO.getBranch());

            profesorRepo.save(profesorEntity);
            ProfesorOutputDTO saveOutputDTO = new ProfesorOutputDTO(profesorEntity);
            return saveOutputDTO;

        }catch(Exception ex){

            throw new UnprocesableException("Faltan campos o estos no cumplen los requisitos");
        }
    }
}
