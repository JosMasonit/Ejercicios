package com.crud.estudiante_asignatura.application.usecase;

import com.crud.comun.exceptions.NotFoundException;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.repository.StudentRepository;
import com.crud.estudiante_asignatura.application.port.ReadE_A_Port;
import com.crud.estudiante_asignatura.domain.EstudianteAsignaturaEntity;
import com.crud.estudiante_asignatura.infraestructure.dto.AsignaturaOutputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.AsignaturasOutputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_OutputDTO;
import com.crud.estudiante_asignatura.infraestructure.repository.EstudianteAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadE_A_UseCase implements ReadE_A_Port {

    @Autowired
    EstudianteAsignaturaRepository eaRepo;

    @Autowired
    StudentRepository studentRepository;


    public E_A_OutputDTO findByID(String id) {
        EstudianteAsignaturaEntity eaEntity =eaRepo.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        E_A_OutputDTO e_a_OutputDTO = new E_A_OutputDTO(eaEntity);
        return e_a_OutputDTO;
    }

    public AsignaturasOutputDTO findByIDestudiante(String id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id));
        List<EstudianteAsignaturaEntity> listaAsignaturas =eaRepo.findByEstudiante(studentEntity);
        List<AsignaturaOutputDTO> listaFinal = new ArrayList();
        AsignaturasOutputDTO asignaturasOutputDTO = new AsignaturasOutputDTO(id);
        for(int i=0; i<listaAsignaturas.size(); i++){
            AsignaturaOutputDTO asignatura = new AsignaturaOutputDTO(listaAsignaturas.get(i));
            listaFinal.add(asignatura);
        }
        asignaturasOutputDTO.setListaAsignaturas(listaFinal);
        return asignaturasOutputDTO;
    }

    public List<E_A_OutputDTO> getAll(){
        List<EstudianteAsignaturaEntity> listaEntity = eaRepo.findAll();
        List<E_A_OutputDTO> listaOutput = new ArrayList();

        for(int i=0; i< listaEntity.size(); i++){
            E_A_OutputDTO eaOutputDTO = new E_A_OutputDTO(listaEntity.get(i));
            listaOutput.add(eaOutputDTO);
        }
        return listaOutput;
    }
}
