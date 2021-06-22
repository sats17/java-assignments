package com.github.sats17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.github.sats17.configurations.ConfigProperties;
import com.github.sats17.model.Account;
//import com.github.sats17.repository.AccountReactiveRepository;
import com.github.sats17.repository.AccountReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class WebfluxAssignmentsApplication {

	@Autowired
	AccountReactiveRepository accCrudRepo;

	public static void main(String[] args) {
		SpringApplication.run(WebfluxAssignmentsApplication.class, args);
	}

	@Bean
	public String ingestData() {
		System.out.println("Ingesting data");
		for(int i = 0; i < 10; i++) {
			Account acc = new Account();
			acc.setId(String.valueOf(i));
			acc.setOwner(UUID.randomUUID().toString());
			acc.setValue(i + 1000);
			accCrudRepo.save(acc).subscribe(entity -> System.out.println("Entity has been saved: {}"+ entity));
		}
		Account acc = new Account();
		acc.setId(String.valueOf(55));
		acc.setOwner(UUID.randomUUID().toString());
		acc.setValue(5 + 1000);
		accCrudRepo.save(acc).subscribe(entity -> System.out.println("Entity has been saved: {}"+ entity));
		return null;
	}

}
