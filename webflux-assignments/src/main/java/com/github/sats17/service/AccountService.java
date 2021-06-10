package com.github.sats17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sats17.model.Account;
import com.github.sats17.repository.AccountCrudRepository;

import reactor.core.publisher.Mono;

@Service
public class AccountService {

	@Autowired
	AccountCrudRepository accCrudRepo;
	
	public Mono<Account> getUserById(String id){
		return accCrudRepo.findById(id);
	}
	
}
