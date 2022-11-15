package dev.patricksilva.animalcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.patricksilva.animalcontroller.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByOwn(Integer own);
}
