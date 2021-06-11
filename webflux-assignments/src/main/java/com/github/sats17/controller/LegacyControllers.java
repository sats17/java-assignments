package com.github.sats17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sats17.model.Account;
import com.github.sats17.service.AccountService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/legacy")
public class LegacyControllers {

	
	@Autowired
	AccountService accService;
	
	@GetMapping("/user/{id}")
	public Mono<Account> getById(@PathVariable String id){
		return accService.getUserById(id);
	}
	
	@PostMapping("/user")
	public Mono<Account> ingestUser(@RequestBody Account acc){
		// flatmap working as async and will work on worker thread
		Mono<Account> mon = accService.ingestUser(acc).flatMap(transformer -> {
			System.out.println("From flatmap, will print second => "+transformer.getValue());
			
			transformer.setValue(11230);
			return Mono.just(transformer);
		});
		// Below line printing on main thread, and printing thread sleep to check.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("From outside, will print first => "+mon);
		return mon; // After returning we are calling subscribing which is done by webflux itself
	}
	
	
	
}
