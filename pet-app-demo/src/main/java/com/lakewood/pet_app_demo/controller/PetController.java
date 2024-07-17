package com.lakewood.pet_app_demo.controller;

import com.lakewood.pet_app_demo.entity.Pet;
import com.lakewood.pet_app_demo.entity.PetDTO;
import com.lakewood.pet_app_demo.service.PetService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
    ResponseEntity<List<Pet>> getListOfPets(){
        List<Pet> petList = petService.getAllPets();
        if (petList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(petList, HttpStatus.OK);
    }

    @PostMapping("/add-pet")
    ResponseEntity<Pet> addPetToDatabase(@RequestBody PetDTO petDto){
        Pet pet = petService.addPet(petDto);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
    @GetMapping("/get-pet-weight/{id}")
    ResponseEntity<Boolean> getPetUnderTwentyFive(@PathVariable("id") Long id){
        Boolean isUnderWeight =  petService.isUnderTwentyFivePounds(id);
        return new ResponseEntity<>(isUnderWeight, HttpStatus.OK);
    }

    @GetMapping("/get-vaccination-status/{id}")
    ResponseEntity<Boolean> getVaccinationStatus(@PathVariable("id") Long id){
        Boolean isVaccinated =  petService.isVaccinatedForBoatRental(id);
        return new ResponseEntity<>(isVaccinated, HttpStatus.OK);
    }

    @GetMapping("/is-poodle/{id}")
    ResponseEntity<Boolean> getIsPoodle(@PathVariable("id") Long id){
        Boolean isPoodle =  petService.isNotAPoodle(id);
        return new ResponseEntity<>(isPoodle, HttpStatus.OK);
    }


    @GetMapping("/pet-rental-eligibility/{id}")
    ResponseEntity<Boolean> getPetRentalEligibility(@PathVariable("id") Long id){
        Boolean petIsEligible =  petService.isEligibleForBoatRental(id);
        return new ResponseEntity<>(petIsEligible, HttpStatus.OK);
    }
}
