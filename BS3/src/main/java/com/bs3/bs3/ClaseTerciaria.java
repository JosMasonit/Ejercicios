package com.bs3.bs3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClaseTerciaria {


    @Bean
    CommandLineRunner ejecutame(Parametros p){
        return saludo -> System.out.println("Hola "+p.name+", saludos desde la tercera clase.");
    }

}
