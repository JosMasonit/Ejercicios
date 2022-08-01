package com.crud.estudiante.infraestructure.dto;

import com.crud.estudiante.domain.StudentEntity;
import lombok.Data;

@Data
public class EstudianteOutputSimpleDTO extends EstudianteOutputDTO{

    public EstudianteOutputSimpleDTO(StudentEntity studentEntity){
        super(studentEntity);
    }
}
