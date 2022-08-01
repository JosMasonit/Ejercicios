package com.crud.estudiante_asignatura.application.usecase;

import com.crud.comun.exceptions.NotFoundException;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante.infraestructure.repository.StudentRepository;
import com.crud.estudiante_asignatura.application.port.CreateE_A_Port;
import com.crud.estudiante_asignatura.domain.EstudianteAsignaturaEntity;
import com.crud.estudiante_asignatura.infraestructure.dto.AsignaturaInputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.CreateE_A_InputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_OutputDTO;
import com.crud.estudiante_asignatura.infraestructure.repository.EstudianteAsignaturaRepository;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateE_A_UseCase implements CreateE_A_Port {

    @Autowired
    EstudianteAsignaturaRepository estAsignaturaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    public List<E_A_OutputDTO> addAsignaturas(CreateE_A_InputDTO createEAInputDTO){
        String id_estudiante = createEAInputDTO.getId_estudiante();
        StudentEntity studentEntity = studentRepository.findById(id_estudiante).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id_estudiante));
        List<AsignaturaInputDTO> listAsinaturas = createEAInputDTO.getListaAsignaturas();
        List<E_A_OutputDTO> listaFinal = new ArrayList();
        for(int i=0; i<listAsinaturas.size(); i++){
            AsignaturaInputDTO asignatura = listAsinaturas.get(i);
            EstudianteAsignaturaEntity estudianteAsignatura = new EstudianteAsignaturaEntity();
            estudianteAsignatura.setEstudiante(studentEntity);
            estudianteAsignatura.setId_asignatura(asignatura.getIdAsignatura());
            estudianteAsignatura.setAsignatura(asignatura.getAsignatura());
            estudianteAsignatura.setInitial_date(asignatura.getInitial_date());

            String id_profesor = asignatura.getIdProfesor();
            ProfesorEntity profesorEntity = profesorRepository.findById(id_profesor).orElseThrow(() -> new NotFoundException("No se ha encontrado el ID: "+id_profesor));
            estudianteAsignatura.setId_profesor(profesorEntity);
            estAsignaturaRepository.save(estudianteAsignatura);
            E_A_OutputDTO e_a_outputDTO = new E_A_OutputDTO(estudianteAsignatura);
            listaFinal.add(e_a_outputDTO);
        }
        return listaFinal;
    }
}
