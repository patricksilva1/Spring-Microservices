package dev.patricksilva.peoplecontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import dev.patricksilva.peoplecontroller.model.People;

@Repository
@EnableJpaRepositories
public interface PeopleRepository extends JpaRepository<People, String>{

}