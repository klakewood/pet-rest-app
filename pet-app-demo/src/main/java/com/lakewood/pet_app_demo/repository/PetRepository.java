package com.lakewood.pet_app_demo.repository;

import com.lakewood.pet_app_demo.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
