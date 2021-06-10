package com.github.sats17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
}
