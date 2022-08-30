package com.crud;

import com.crud.persona.application.usecase.PersonaService;
import com.crud.persona.domain.PersonaEntity;
import com.crud.persona.infraestructure.dto.PersonaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Db1Application {

	public static void main(String[] args) {
		SpringApplication.run(Db1Application.class, args);
	}


}
