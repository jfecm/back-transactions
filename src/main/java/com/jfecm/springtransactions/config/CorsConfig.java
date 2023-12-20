package com.jfecm.springtransactions.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Add CORS configuration specific to the REST route
        registry.addMapping("/api/v1/**")
                .allowedOrigins("http://localhost:4200")
                .allowedHeaders("*")
                .allowedMethods("*");

        // Add CORS configuration specific to the GraphQL route
        registry.addMapping("/graphql")
                .allowedOrigins("http://localhost:4200")
                .allowedHeaders("*")
                .allowedMethods("*");
    }

}
