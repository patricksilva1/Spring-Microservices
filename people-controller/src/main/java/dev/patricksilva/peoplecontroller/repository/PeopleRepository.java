package dev.patricksilva.peoplecontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.patricksilva.peoplecontroller.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, String>{

}