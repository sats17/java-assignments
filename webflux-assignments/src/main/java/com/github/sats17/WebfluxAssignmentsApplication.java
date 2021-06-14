package com.github.sats17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.sats17.model.Account;
//import com.github.sats17.repository.AccountReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebfluxAssignmentsApplication {

//	@Autowired
//	AccountReactiveRepository accCrudRepo;

	public static void main(String[] args) {
		SpringApplication.run(WebfluxAssignmentsApplication.class, args);
	}

//	@Bean
//	public String ingestData() {
//		System.out.println("Ingesting data");
//		Account acc = new Account();
//		acc.setId("10");
//		acc.setOwner("esgs");
//		acc.setValue(1000);
//		accCrudRepo.save(acc).subscribe();
//		accCrudRepo.findAll().subscribe(entity -> System.out.println("Entity has been saved: {}"+ entity));;
//		return null;
//	}

}
