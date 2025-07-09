package com.dev.validatiom.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI openAPI(){
        return new OpenAPI().info(new Info().title("File upload and download ")
                .description("A spring boot application that allow file upload and download")
                .summary("created by Revocatus Joseph Nduki"));
    }
}
