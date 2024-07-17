package com.lakewood.pet_app_demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
@Entity(name = "pet")
public class Pet {
    @Id
    @SequenceGenerator(
            name = "pet_sequence",
            sequenceName = "pet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "pet_sequence"
    )
    @Column(name = "pet_id", updatable = false)
    private Long id;
    private String name;
    @Column(name = "pet_weight", nullable = false)
    private Double weight;
    @Column(name = "pet_breed", nullable = false)
    private String breed;
    @Column(name = "vaccination_status", nullable = false)
    private Boolean isVaccinated;
    @Max(value = 10)
    @Column(name = "training_level", nullable = false)
    private Integer trainingLevel;

    public Pet(String name, Double weight, String breed, Boolean isVaccinated, Integer trainingLevel) {
        this.name = name;
        this.weight = weight;
        this.breed = breed;
        this.isVaccinated = isVaccinated;
        this.trainingLevel = trainingLevel;
    }
}
