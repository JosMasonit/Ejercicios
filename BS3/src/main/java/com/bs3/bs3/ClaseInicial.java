package com.bs3.bs3;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClaseInicial {

    @PostConstruct
    public void primeraFuncion(){
        System.out.println("Hola desde clase inicial");
    }
}
