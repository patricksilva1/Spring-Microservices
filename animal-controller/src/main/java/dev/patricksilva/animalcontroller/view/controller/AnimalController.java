package dev.patricksilva.animalcontroller.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.patricksilva.animalcontroller.service.AnimalService;
import dev.patricksilva.animalcontroller.shared.AnimalDto;
import dev.patricksilva.animalcontroller.view.model.AnimalModelAlteration;
import dev.patricksilva.animalcontroller.view.model.AnimalModelInclusion;
import dev.patricksilva.animalcontroller.view.model.AnimalModelResponse;

@RestController
@RequestMapping(value = "/api/animals")
public class AnimalController {
    @Autowired
    private AnimalService service;

    @GetMapping(value = "/status")
    public String statusService(@Value("${local.server.port}") String port) {
        return String.format("Service running at port: ", port);
    }

    @PostMapping
    public ResponseEntity<AnimalModelResponse> createAnimal(@RequestBody @Valid AnimalModelInclusion Animal) {
        ModelMapper mapper = new ModelMapper();
        AnimalDto dto = mapper.map(Animal, AnimalDto.class);
        dto = service.createAnimal(dto);

        return new ResponseEntity<>(mapper.map(dto, AnimalModelResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnimalModelResponse>> findAll() {
        List<AnimalDto> dtos = service.findAll();

        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<AnimalModelResponse> resp = dtos.stream()
                .map(dto -> mapper.map(dto, AnimalModelResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/{own}/list")
    public ResponseEntity<List<AnimalModelResponse>> findByOwn(@PathVariable Integer own) {
        List<AnimalDto> dtos = service.findByOwn(own);

        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<AnimalModelResponse> resp = dtos.stream().map(dto -> mapper.map(dto, AnimalModelResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AnimalModelResponse> findById(@PathVariable Integer id) {
        Optional<AnimalDto> Animal = service.findById(id);

        if (Animal.isEmpty()) {
            return new ResponseEntity<>(new ModelMapper().map(Animal.get(), AnimalModelResponse.class), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AnimalModelResponse> updateAnimal(@PathVariable Integer id,
            @Valid @RequestBody AnimalModelAlteration Animal) {
        ModelMapper mapper = new ModelMapper();

        AnimalDto dto = mapper.map(Animal, AnimalDto.class);
        dto = service.updateAnimal(id, dto);

        return new ResponseEntity<>(mapper.map(dto, AnimalModelResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> removeAnimal(@PathVariable Integer id) {
        service.removeAnimal(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> defineByDead(@PathVariable Integer id) {
        if (service.defineByDead(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
