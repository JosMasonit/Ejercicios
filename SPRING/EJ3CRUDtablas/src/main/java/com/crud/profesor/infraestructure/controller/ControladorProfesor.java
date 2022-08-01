package com.crud.profesor.infraestructure.controller;


import com.crud.estudiante.infraestructure.dto.EstudianteOutputDTO;
import com.crud.persona.infraestructure.dto.PersonaInputDTO;
import com.crud.persona.infraestructure.dto.PersonaOutputDTO;
import com.crud.profesor.application.usecase.CreateProfesorUseCase;
import com.crud.profesor.application.usecase.DeleteProfesorUseCase;
import com.crud.profesor.application.usecase.ReadProfesorUseCase;
import com.crud.profesor.application.usecase.UpdateProfesorUseCase;
import com.crud.profesor.infraestructure.dto.ProfesorInputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ControladorProfesor {

    @Autowired
    ReadProfesorUseCase readProfesorUseCase;

    @GetMapping("/getAll")
    public List<ProfesorOutputDTO> listarProfesor(@RequestParam(defaultValue = "simple", required = false) String outputType) {
        return readProfesorUseCase.getAll(outputType);
    }

    @GetMapping("/getID/{id}")
    public ProfesorOutputDTO buscarId(@PathVariable String id, @RequestParam(defaultValue = "simple", required = false) String outputType) throws Exception {
        System.out.println("outputType: " + outputType);
        return readProfesorUseCase.findByID(id, outputType);
    }


    @Autowired
    CreateProfesorUseCase createProfesorUseCase;

    @PostMapping("/crear")
    public ProfesorOutputDTO crearProfesor(@RequestBody ProfesorInputDTO profesor) throws Exception {
        ProfesorOutputDTO profesorOutputDTO = createProfesorUseCase.addProfesor(profesor);
        return profesorOutputDTO;
    }


    @Autowired
    DeleteProfesorUseCase deleteProfesorUseCase;

    @DeleteMapping("delete/{id}")
    public ProfesorOutputDTO borrarByID(@PathVariable String id) throws Exception {
        ProfesorOutputDTO profesorOutputDTO = deleteProfesorUseCase.borrarProfesor(id);
        return profesorOutputDTO;
    }

    @Autowired
    UpdateProfesorUseCase updateProfesorUseCase;

    @PutMapping("/update/{id}")
    public ProfesorOutputDTO actualizarProfesor(@PathVariable String id, @RequestBody ProfesorInputDTO profesorIDTO) {
        ProfesorOutputDTO profesorOutputDTO = updateProfesorUseCase.actualizar(id, profesorIDTO);
        return profesorOutputDTO;

    }
}
