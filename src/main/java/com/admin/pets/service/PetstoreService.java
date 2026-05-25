package com.admin.pets.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import com.admin.pets.model.PetDto;

@Service
public class PetstoreService {

    private final RestClient restClient;

    // Spring inyecta automáticamente el Bean que configuramos antes
    public PetstoreService(RestClient petstoreRestClient) {
        this.restClient = petstoreRestClient;
    }
 

    public PetDto getPetById(Long petId) {
        return restClient.get()
                .uri("/pet/{petId}", petId) // Reemplaza {petId} de forma segura
                .retrieve()
                .body(PetDto.class); // Mapea el JSON directamente a tu DTO
    }
    
    
    public PetDto createPet(PetDto newPet) {
        return restClient.post()
                .uri("/pet")
                .contentType(MediaType.APPLICATION_JSON)
                .body(newPet)
                .retrieve()
                // Si la API externa responde con un error 4xx o 5xx, lo manejamos aquí
//                .onStatus(HttpStatus::isError, (request, response) -> {
//                    throw new RuntimeException("Error al conectar con Petstore. Código: " 
//                            + response.getStatusCode() + " - " + response.getStatusText());
//                })
                .body(PetDto.class);
    }
}