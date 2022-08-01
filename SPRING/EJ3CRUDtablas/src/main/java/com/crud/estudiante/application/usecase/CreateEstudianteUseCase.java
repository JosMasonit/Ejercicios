package com.crud.estudiante.application.usecase;

import com.crud.comun.exceptions.UnprocesableException;
import com.crud.estudiante.application.port.CreateEstudiantePort;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteInputDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.estudiante.infraestructure.repository.StudentRepository;
import com.crud.persona.application.usecase.PersonaService;
import com.crud.persona.domain.PersonaEntity;
import com.crud.profesor.application.usecase.ReadProfesorUseCase;
import com.crud.profesor.domain.ProfesorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateEstudianteUseCase implements CreateEstudiantePort {

    @Autowired
    PersonaService personaService;
    @Autowired
    ReadProfesorUseCase readProfesorUseCase;

    @Autowired
    ReadEstudianteUseCase readEstudianteUseCase;

    @Autowired
    StudentRepository estudianteRepo;
/*
    public EstudianteOutputDTO addEstudiante(EstudianteInputDTO estudianteIDTO) {
        try{
            StudentEntity estudianteEntity = new StudentEntity(estudianteIDTO);
            estudianteRepo.save(estudianteEntity);
            EstudianteOutputDTO saveOutputDTO = new EstudianteOutputDTO(estudianteEntity);
            String id = estudianteEntity.getId_estudiante();
            System.out.println((estudianteRepo.findById(id)).toString());
            return saveOutputDTO;

        }catch(Exception ex){

            throw new UnprocesableException("Faltan campos o estos no cumplen los requisitos");
        }
    } */

    public EstudianteOutputDTO addEstudiante(EstudianteInputDTO estudianteIDTO) {
        try{
            StudentEntity estudianteEntity = new StudentEntity();
            /*
            System.out.println("crearEstudiante 1");

            personaService.getAll();
            readProfesorUseCase.getAll();
            System.out.println("crearEstudiante 2"); */

            String idProfesor = estudianteIDTO.getId_profesor();
            String idPersona = estudianteIDTO.getId_persona();
            PersonaEntity persona = personaService.findByIDentity(idPersona);
            ProfesorEntity profesor = readProfesorUseCase.findByIDentity(idProfesor);

            ProfesorEntity posibleProfesor = readProfesorUseCase.findByIdPersona(persona);
            if(posibleProfesor!=null){
                System.out.println("El id_Persona corresponde a un Profesor");
                throw new UnprocesableException("");
            }
            StudentEntity posibleEstudiante = readEstudianteUseCase.findByIdPersona(persona);
            if(posibleEstudiante!=null){
                System.out.println("El id_Persona corresponde a un Estudiante");
                throw new UnprocesableException("");
            }

            /*
            if(estudiante==null) throw new UnprocesableException("El id_Persona corresponde a un Estudiante");

            //Lógica para comprobar que la persona no sea un profesor
            List<String> lista = readProfesorUseCase.getAllIdPersonaProfesor();
            List<String> lista = readProfesorUseCase.getAllIdPersonaProfesor();
            Boolean idOcupado = false;
            for(int i=0; i<lista.size(); i++){
                if(lista.get(i).equalsIgnoreCase(idPersona)){
                    idOcupado = true;
                }
            }
            if(idOcupado==true) throw new UnprocesableException("El id_Persona corresponde a un Profesor"); */


            estudianteEntity.setId_persona(persona);
            estudianteEntity.setId_profesor(profesor);
            estudianteEntity.setNum_hours_week(estudianteIDTO.getNum_hours_week());
            estudianteEntity.setComents(estudianteIDTO.getComents());
            estudianteEntity.setBranch(estudianteIDTO.getBranch());

            estudianteRepo.save(estudianteEntity);
            EstudianteOutputDTO saveOutputDTO = new EstudianteOutputDTO(estudianteEntity);
            return saveOutputDTO;

        }catch(Exception ex){

            throw new UnprocesableException("Faltan campos o estos no cumplen los requisitos");
        }
    }
}
