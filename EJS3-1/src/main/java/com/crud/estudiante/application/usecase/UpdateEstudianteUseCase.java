package com.crud.estudiante.application.usecase;


import com.crud.comun.exceptions.NotFoundException;
import com.crud.comun.exceptions.UnprocesableException;
import com.crud.estudiante.application.port.UpdateEstudiantePort;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteInputDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.estudiante.infraestructure.repository.StudentRepository;
import com.crud.profesor.application.usecase.ReadProfesorUseCase;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorInputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEstudianteUseCase implements UpdateEstudiantePort {

    @Autowired
    StudentRepository estudianteRepo;

    @Autowired
    ReadProfesorUseCase readProfesorUseCase;

    public EstudianteOutputDTO actualizar(String id, EstudianteInputDTO estudianteIDTO) {
        try{
            StudentEntity studentEntity=estudianteRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
            studentEntity.setUpdate(estudianteIDTO); //setAll ya se encargar de añadir solo los campos no nulos
            if(estudianteIDTO.getId_profesor()!=null){
                ProfesorEntity profesor = readProfesorUseCase.findByIDentity(estudianteIDTO.getId_profesor());
                if(profesor!=null){
                    studentEntity.setId_profesor(profesor);
                }
                else{
                    System.out.println("El id de profesor :"+estudianteIDTO.getId_profesor()+"no existe");
                }
            }
            estudianteRepo.saveAndFlush(studentEntity);
            EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(studentEntity);
            return estudianteOutputDTO;

        }catch(Exception ex){
            throw new UnprocesableException("Los campos no cumplen los requisitos");
        }
    }
}
