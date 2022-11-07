package dev.patricksilva.peoplecontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableJpaRepositories
public class PeopleControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleControllerApplication.class, args);
	}

}
