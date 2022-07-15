package com.ejercicio3.ejercicio3;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador {


    @Autowired
    @Qualifier("bean1")
    PersonaService p1;
    @Autowired
    @Qualifier("bean2")
    PersonaService p2;
    @Autowired
    @Qualifier("bean3")
    PersonaService p3;

    @GetMapping("/controlador/bean/{bean}")
    public String getUser(@PathVariable String bean) {
        if(bean.equals("bean1")){
            p1.setNombre();
            return p1.getNombre();
        }
        else if(bean.equals("bean2")){
            p2.setNombre();
            return p2.getNombre();
        }
        else if(bean.equals("bean3")){
            p3.setNombre();
            return p3.getNombre();
        }
        else{
            return "Bean no encontrado";
        }

    }
}
