package com.crud.estudiante_asignatura.infraestructure.controller;

import com.crud.estudiante.application.usecase.CreateEstudianteUseCase;
import com.crud.estudiante.infraestructure.dto.EstudianteInputDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.estudiante_asignatura.application.usecase.CreateE_A_UseCase;
import com.crud.estudiante_asignatura.application.usecase.DeleteE_A_UseCase;
import com.crud.estudiante_asignatura.application.usecase.ReadE_A_UseCase;
import com.crud.estudiante_asignatura.application.usecase.UpdateE_A_UseCase;
import com.crud.estudiante_asignatura.infraestructure.dto.AsignaturasOutputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.CreateE_A_InputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_InputDTO;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_OutputDTO;
import com.crud.persona.infraestructure.dto.PersonaOutputFullDTO;
import com.crud.profesor.application.usecase.UpdateProfesorUseCase;
import com.crud.profesor.infraestructure.dto.ProfesorInputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studentTopic")
public class ControladorEstudianteAsignatura {

    @Autowired
    ReadE_A_UseCase readE_A_UseCase;

    @GetMapping("/getAll")
    public List<E_A_OutputDTO> listarTodo(){
        return readE_A_UseCase.getAll();
    }
    @GetMapping("/getID/{id}")
    public E_A_OutputDTO buscarID(@PathVariable String id) throws Exception {
        return readE_A_UseCase.findByID(id);
    }

    @GetMapping("/getEstudiante/{estudiante}")
    public AsignaturasOutputDTO buscarUsuario(@PathVariable String estudiante){
        return readE_A_UseCase.findByIDestudiante(estudiante);
    }


    @Autowired
    CreateE_A_UseCase createE_A_UseCase;

    @PostMapping("/crear")
    public List<E_A_OutputDTO> crearEstudiante(@RequestBody CreateE_A_InputDTO createEAInputDTO) throws Exception {
        List<E_A_OutputDTO> lista = createE_A_UseCase.addAsignaturas(createEAInputDTO);
        return lista;
    }


    @Autowired
    DeleteE_A_UseCase deleteEAUseCase;

    @PostMapping("/delete")
    public void borrarAsignaturas(@RequestBody List<String> lista){
        deleteEAUseCase.borrarAsignaturas(lista);
    }


    @Autowired
    UpdateE_A_UseCase updateEAUseCase;

    @PutMapping("/update/{id}")
    public E_A_OutputDTO actualizarProfesor(@PathVariable String id, @RequestBody E_A_InputDTO e_a_inputDTO) {
        E_A_OutputDTO eaOutputDTO = updateEAUseCase.actualizar(id, e_a_inputDTO);
        return eaOutputDTO;

    }
}
