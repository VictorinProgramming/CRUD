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
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestão de Empregados e Cargos")
                        .description("API RESTful para gerenciamento de empregados e seus respectivos cargos. Documentação gerada automaticamente com Swagger.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Seu Nome")
                                .email("seuemail@exemplo.com")
                                .url("https://github.com/seuusuario"))
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}
