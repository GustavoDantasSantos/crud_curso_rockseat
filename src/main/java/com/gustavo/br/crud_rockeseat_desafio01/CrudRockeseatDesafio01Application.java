package com.gustavo.br.crud_rockeseat_desafio01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Desafio 01 trilha java",
		description = "Essa api é do primeiro desafio da trilha de Java da @Rockeseat",
		version = "1.0"
	)
)
public class CrudRockeseatDesafio01Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudRockeseatDesafio01Application.class, args);
	}

}
