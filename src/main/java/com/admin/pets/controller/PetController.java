package com.admin.pets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.pets.model.PetDto;
import com.admin.pets.service.PetstoreService;

@RestController
@RequestMapping("/api/v1/mis-mascotas")
public class PetController {

    private final PetstoreService petstoreService;

    public PetController(PetstoreService petstoreService) {
        this.petstoreService = petstoreService;
    }

    @GetMapping("/{id}")
    public PetDto buscarMascotaEnPetstore(@PathVariable Long id) {
        return petstoreService.getPetById(id);
    }
}