package com.gustavo.br.crud_rockeseat_desafio01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
        .info(new Info()
            .title("Desafio 01 trilha java")
            .description( "Essa api é do primeiro desafio da trilha de Java da @Rockeseat")
            .version("1.1")
        );
    }
}
