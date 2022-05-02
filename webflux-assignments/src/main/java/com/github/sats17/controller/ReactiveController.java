package com.github.sats17.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sats17.model.Account;
import com.github.sats17.repository.AccountReactiveRepository;
import com.github.sats17.service.AccountService;
import com.github.sats17.service.UserService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/reactive")
public class ReactiveController {
	
	@Autowired
	AccountService accService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountReactiveRepository accReactRepo;
	
	@GetMapping("/accounts")
	public Flux<Account> getAccount() {
		// Use Accept header as test/event-stream to see the result. Gitbash/postman does not support reactive way, try to use 
		// other command line
		return accReactRepo.findAll().delayElements(Duration.ofMillis(1000))
				.doOnNext(tst -> System.out.println(tst.getId()));
	}
	

}
