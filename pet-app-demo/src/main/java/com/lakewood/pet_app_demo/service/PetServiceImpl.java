package com.lakewood.pet_app_demo.service;

import com.lakewood.pet_app_demo.entity.Pet;
import com.lakewood.pet_app_demo.entity.PetDTO;
import com.lakewood.pet_app_demo.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{
    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    @Override
    public Pet addPet(PetDTO petDTO) {
        Pet pet = new Pet(
                petDTO.name(),
                petDTO.weight(),
                petDTO.breed(),
                petDTO.isVaccinated(),
                petDTO.trainingLevel());

        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Boolean isEligibleForBoatRental(Long id) {
        Pet pet  = petRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Error: pet not found with id " + id));
        return (pet.getWeight() < 25.0 && pet.getIsVaccinated() == true && !pet.getBreed().equalsIgnoreCase("poodle") && pet.getTrainingLevel() >= 3);

    }

    @Override
    public Boolean isUnderTwentyFivePounds(Long id) {
        Pet pet  = petRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Error: pet not found with id " + id));
        return pet.getWeight() < 25.0;
    }

    @Override
    public Boolean isVaccinatedForBoatRental(Long id) {
        Pet pet  = petRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Error: pet not found with id " + id));
        return pet.getIsVaccinated();
    }

    @Override
    public Boolean isNotAPoodle(Long id) {
        Pet pet  = petRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Error: pet not found with id " + id));
        return pet.getBreed().equalsIgnoreCase("poodle");
    }
}
