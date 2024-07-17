package com.lakewood.pet_app_demo.entity;

public record PetDTO(String name, Double weight, String breed, Boolean isVaccinated, Integer trainingLevel) {
}
