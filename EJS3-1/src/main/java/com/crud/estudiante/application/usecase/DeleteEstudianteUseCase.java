package com.crud.estudiante.application.usecase;


import com.crud.comun.exceptions.NotFoundException;
import com.crud.estudiante.application.port.DeleteEstudiantePort;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.estudiante.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEstudianteUseCase implements DeleteEstudiantePort {

    @Autowired
    StudentRepository estudianteRepo;

    public EstudianteOutputDTO borrarEstudiante(String id) {
        StudentEntity studentEntity = estudianteRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO(studentEntity);
        estudianteRepo.deleteById(id);
        return estudianteOutputDTO;
    }
}
