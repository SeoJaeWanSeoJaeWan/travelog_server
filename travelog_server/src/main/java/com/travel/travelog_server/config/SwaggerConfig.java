package com.travel.travelog_server.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI () {
        Server server = new Server();
        server.setUrl("http://localhost:8080");

        Info info = new Info().title("Travelog API").version("v1.0.0").description("Travelog API 명세서");

        return new OpenAPI().info(info).addServersItem(server);
    }
}
