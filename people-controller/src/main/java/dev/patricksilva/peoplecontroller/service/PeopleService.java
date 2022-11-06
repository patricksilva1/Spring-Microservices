package dev.patricksilva.peoplecontroller.service;

import java.util.List;
import java.util.Optional;

import dev.patricksilva.peoplecontroller.shared.PeopleDto;

public interface PeopleService {
    PeopleDto createPeople(PeopleDto people);

    List<PeopleDto> findAll();

    Optional<PeopleDto> findById(String id);

    void removePeople(String id);

    PeopleDto updatePeople(String id, PeopleDto people);
}
