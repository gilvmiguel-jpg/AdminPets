package com.admin.pets.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient petstoreRestClient() {
        return RestClient.builder()
                .baseUrl("https://petstore.swagger.io/v2") // URL base de la API v2
                .build();
    }
}