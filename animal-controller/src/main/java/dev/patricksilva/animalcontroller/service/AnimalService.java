package dev.patricksilva.animalcontroller.service;

import java.util.List;
import java.util.Optional;

import dev.patricksilva.animalcontroller.shared.AnimalDto;

public interface AnimalService {
    AnimalDto createAnimal(AnimalDto animal);

    List<AnimalDto> findAll();

    Optional<AnimalDto> findById(Integer id);

    List<AnimalDto> findByOwn(Integer own);

    void removeAnimal(Integer id);

    boolean defineByDead(Integer id);

    AnimalDto updateAnimal(Integer id, AnimalDto animal);
}
