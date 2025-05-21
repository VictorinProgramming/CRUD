package com.projeto.crud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do Swagger usando SpringDoc OpenAPI.
 * A documentação ficará disponível em: http://localhost:8080/swagger-ui.html
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI projetoCrudOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API CRUD de Empregados e Cargos")
                        .description("API REST para gerenciamento de empregados e cargos com filtros, paginação, documentação e boas práticas.")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Victor Estevão")
                                .email("victormorekids@gmai.com")
                                .url("https://github.com/VictorinProgramming"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório no GitHub")
                        .url("https://github.com/VictorinProgramming"));
    }
}
