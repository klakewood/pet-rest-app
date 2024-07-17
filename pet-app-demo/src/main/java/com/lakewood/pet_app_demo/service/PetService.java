package com.lakewood.pet_app_demo.service;

import com.lakewood.pet_app_demo.entity.Pet;
import com.lakewood.pet_app_demo.entity.PetDTO;

import java.util.List;

public interface PetService {
    Pet addPet(PetDTO petDTO);
    List<Pet> getAllPets();
    Boolean isEligibleForBoatRental(Long Id);
    Boolean isUnderTwentyFivePounds(Long id);
    Boolean isVaccinatedForBoatRental(Long id);
    Boolean isNotAPoodle(Long id);
}