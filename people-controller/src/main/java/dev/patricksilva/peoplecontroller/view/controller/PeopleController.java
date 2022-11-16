package dev.patricksilva.peoplecontroller.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.patricksilva.peoplecontroller.model.People;
import dev.patricksilva.peoplecontroller.service.PeopleService;
import dev.patricksilva.peoplecontroller.shared.PeopleDto;
import dev.patricksilva.peoplecontroller.view.model.PeopleModelRequest;
import dev.patricksilva.peoplecontroller.view.model.PeopleModelResponse;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    @Autowired
    private PeopleService service;

    @GetMapping(value = "/status")
    public String statusService(@Value("${local.server.port}") String port) {

        return String.format("Running at $s", port);
    }

    @PostMapping
    public ResponseEntity<PeopleModelResponse> createPeople(@RequestBody @Valid PeopleModelRequest people) {
        ModelMapper mapper = new ModelMapper();
        PeopleDto dto = mapper.map(people, PeopleDto.class);
        dto = service.createPeople(dto);

        return new ResponseEntity<>(mapper.map(dto, PeopleModelResponse.class),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PeopleModelResponse>> findAll() {
        List<PeopleDto> dtos = service.findAll();

        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<PeopleModelResponse> resp = dtos.stream()
                .map(dto -> mapper.map(dto, PeopleModelResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PeopleModelResponse> findById(@PathVariable String id) {
        Optional<PeopleDto> people = service.findById(id);

        if (people.isPresent()) {
            return new ResponseEntity<>(new ModelMapper().map(people.get(), PeopleModelResponse.class),
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PeopleModelResponse> updatePeople(@PathVariable String id,
            @Valid @RequestBody People people) {

        ModelMapper mapper = new ModelMapper();

        PeopleDto dto = mapper.map(people, PeopleDto.class);

        dto = service.updatePeople(id, dto);

        return new ResponseEntity<>(mapper.map(dto, PeopleModelResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> removePeople(@PathVariable String id) {
        service.removePeople(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
