package dev.patricksilva.animalcontroller.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.patricksilva.animalcontroller.repository.AnimalRepository;
import dev.patricksilva.animalcontroller.shared.AnimalDto;
import dev.patricksilva.animalcontroller.model.Animal;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository repo;

    @Override
    public AnimalDto createAnimal(AnimalDto animal) {
        return saveAnimal(animal);
    }

    @Override
    public List<AnimalDto> findAll() {

        List<Animal> animals = repo.findAll();

        return animals.stream()
                .map(animal -> new ModelMapper().map(animal, AnimalDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<AnimalDto> findById(Integer id) {
        Optional<Animal> animal = repo.findById(id);

        if (animal.isPresent()) {
            return Optional.of(new ModelMapper().map(animal.get(), AnimalDto.class));
        }

        return Optional.empty();
    }

    @Override
    public List<AnimalDto> findByOwn(Integer own) {
        List<Animal> animals = repo.findByOwn(own);

        return animals.stream()
                .map(animal -> new ModelMapper().map(animal, AnimalDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public void removeAnimal(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public boolean defineByDead(Integer id) {
        Optional<Animal> animal = repo.findById(id);

        if (animal.isPresent()) {
            animal.get().setAlive(false);
            repo.save(animal.get());

            return true;
        }

        return false;
    }

    @Override
    public AnimalDto updateAnimal(Integer id, AnimalDto animal) {

        animal.setId(id);
        return saveAnimal(animal);
    }

    private AnimalDto saveAnimal(AnimalDto animal) {
        ModelMapper mapper = new ModelMapper();
        Animal animalEntity = mapper.map(animal, Animal.class);
        animalEntity = repo.save(animalEntity);

        return mapper.map(animalEntity, AnimalDto.class);
    }

}
