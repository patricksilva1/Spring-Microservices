package dev.patricksilva.peoplecontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class PeopleControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleControllerApplication.class, args);
	}

}
