package com.travel.travelog_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173","http://localhost:4173", "http://192.168.0.72", "http://192.168.0.69")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH");
    }
}
