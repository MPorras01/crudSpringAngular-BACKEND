package com.personalsoft.crudSpringAngular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class CrudSpringAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringAngularApplication.class, args);
	}

}
