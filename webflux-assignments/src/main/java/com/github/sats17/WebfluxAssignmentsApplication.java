package com.github.sats17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.sats17.model.Account;
import com.github.sats17.repository.AccountCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebfluxAssignmentsApplication {

	@Autowired
	AccountCrudRepository accCrudRepo;

	public static void main(String[] args) {
		SpringApplication.run(WebfluxAssignmentsApplication.class, args);
	}

	@Bean
	public void ingestData() {
		System.out.println("Ingesting data");
		Account acc = new Account();
		acc.setId("17");
		acc.setOwner("Sats");
		acc.setValue(1000);
		accCrudRepo.save(acc)
		.subscribe(entity -> System.out.println("Entity has been saved: {}"+ entity));
	}

}
