package dev.patricksilva.peoplecontroller.http;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.patricksilva.peoplecontroller.shared.AnimalDto;

@FeignClient(name = "ms-animals-controller")
public interface AnimalsFeignClient {

    @GetMapping(path = "/api/animals/{own}/list")
    List<AnimalDto> findAnimals(@PathVariable Integer own);

}
