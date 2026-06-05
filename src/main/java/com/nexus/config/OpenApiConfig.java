package com.nexus.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI nexusOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Nexus API")
                .description("Multimodal Communication & Healthcare Intelligence Platform")
                .version("v1.0")
                .contact(new Contact()
                    .name("Group 109")
                    .email("narh-emma@example.com")))
            // Adds the "Authorize" button to Swagger UI so you can paste a JWT
            .addSecurityItem(new SecurityRequirement().addList("Bearer"))
            .components(new Components()
                .addSecuritySchemes("Bearer", new SecurityScheme()
                    .name("Bearer")
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")));
    }
}
