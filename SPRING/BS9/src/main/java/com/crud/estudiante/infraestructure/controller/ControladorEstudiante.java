package com.crud.estudiante.infraestructure.controller;

import com.crud.estudiante.application.usecase.CreateEstudianteUseCase;
import com.crud.estudiante.application.usecase.DeleteEstudianteUseCase;
import com.crud.estudiante.application.usecase.ReadEstudianteUseCase;
import com.crud.estudiante.application.usecase.UpdateEstudianteUseCase;
import com.crud.estudiante.infraestructure.dto.EstudianteInputDTO;
import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.persona.infraestructure.dto.PersonaInputDTO;
import com.crud.persona.infraestructure.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class ControladorEstudiante {

    @Autowired
    ReadEstudianteUseCase readEstudianteUseCase;

    @GetMapping("/getAll")
    public List<EstudianteOutputDTO> listarEstudiantes(@RequestParam(defaultValue = "simple", required = false) String outputType){
        return readEstudianteUseCase.getAll(outputType);
    }

    @GetMapping("/getID/{id}")
    public EstudianteOutputDTO buscarId(@PathVariable String id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        System.out.println("outputType: "+outputType);
        return readEstudianteUseCase.findByID(id, outputType);
    }


    @Autowired
    CreateEstudianteUseCase createEstudianteUseCase;

    @PostMapping("/crear")
    public EstudianteOutputDTO crearEstudiante(@RequestBody EstudianteInputDTO student) throws Exception {
        EstudianteOutputDTO estudianteOutputDTO = createEstudianteUseCase.addEstudiante(student);
        return estudianteOutputDTO;
    }


    @Autowired
    UpdateEstudianteUseCase updateEstudianteUseCase;

    @PutMapping("/update/{id}")
    public EstudianteOutputDTO actualizar(@PathVariable String id, @RequestBody EstudianteInputDTO estudianteInputDTO) throws Exception {
        EstudianteOutputDTO estudianteOutputDTO = updateEstudianteUseCase.actualizar(id, estudianteInputDTO);
        return estudianteOutputDTO;
    }


    @Autowired
    DeleteEstudianteUseCase deleteEstudianteUseCase;
    @DeleteMapping("delete/{id}")
    public EstudianteOutputDTO borrarByID(@PathVariable String id) throws Exception {
        EstudianteOutputDTO estudianteOutputDTO = deleteEstudianteUseCase.borrarEstudiante(id);
        return estudianteOutputDTO;
    }
}
