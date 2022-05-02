package com.github.sats17.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sats17.model.Account;
import com.github.sats17.repository.AccountRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class TraditionalController {
	
	@Autowired
	AccountRepository accountRepo;
	
	@GetMapping("/accounts")
	public List<Account> getAccount() {
		System.out.println("Started requesst");
//		return accService.getAccounts()
//				.doOnNext(test -> System.out.println("result found => "+test.getId()));
//		System.out.println("Return from value");
		Iterable<Account> result = accountRepo.findAll();
		List<Account> accounts = new ArrayList<>();
		result.forEach(account -> {
			accounts.add(account);
		});
		System.out.println(accounts.size());
		
		return accounts;
	}

}
