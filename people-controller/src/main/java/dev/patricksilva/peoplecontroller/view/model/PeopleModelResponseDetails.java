package dev.patricksilva.peoplecontroller.view.model;

import java.util.List;

import dev.patricksilva.peoplecontroller.shared.AnimalDto;

public class PeopleModelResponseDetails extends PeopleModelResponse {
    private List<AnimalDto> animals;

    public List<AnimalDto> getAnimals() {
        return animals;
    }

    public void setAnimals(List<AnimalDto> animals) {
        this.animals = animals;
    }

}
