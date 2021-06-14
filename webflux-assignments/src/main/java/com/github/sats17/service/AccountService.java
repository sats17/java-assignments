package com.github.sats17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sats17.model.Account;
import com.github.sats17.repository.AccountReactiveRepository;

import reactor.core.publisher.Mono;

@Service
public class AccountService {

	@Autowired
	AccountReactiveRepository accReactRepo;
	
	public Mono<Account> getUserById(String id){
		return accReactRepo.findById(id);
	}

	public Mono<Account> ingestUserByReactive(Account acc) {
		Mono<Account> mono = accReactRepo.save(acc);
		System.out.println(mono);
		return mono;
	}
	
}
