package dev.patricksilva.peoplecontroller.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.patricksilva.peoplecontroller.model.People;
import dev.patricksilva.peoplecontroller.repository.PeopleRepository;
import dev.patricksilva.peoplecontroller.shared.PeopleDto;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository repo;

    @Override
    public PeopleDto createPeople(PeopleDto people) {
        return savePeople(people);
    }

    @Override
    public List<PeopleDto> findAll() {
        List<People> people = repo.findAll();

        return people.stream().map(p -> new ModelMapper().map(people, PeopleDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<PeopleDto> findById(String id) {
        Optional<People> people = repo.findById(id);

        if (people.isPresent()) {
            PeopleDto dto = new ModelMapper().map(people.get(), PeopleDto.class);

            return Optional.of(dto);
        }

        return Optional.empty();
    }

    @Override
    public void removePeople(String id) {
        repo.deleteById(id);
    }

    @Override
    public PeopleDto updatePeople(String id, PeopleDto people) {
        people.setId(id);

        return savePeople(people);
    }

    private PeopleDto savePeople(PeopleDto people) {
        ModelMapper mapper = new ModelMapper();
        People peopleEntity = mapper.map(people, People.class);
        peopleEntity = repo.save(peopleEntity);

        return mapper.map(peopleEntity, PeopleDto.class);
    }

}
