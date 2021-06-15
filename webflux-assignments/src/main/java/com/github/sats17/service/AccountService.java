package com.github.sats17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sats17.model.Account;
import com.github.sats17.repository.AccountReactiveRepository;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

	@Autowired
	AccountReactiveRepository accReactRepo;
	
	public Mono<Account> getAccountById(String id){
		// Auto subscribe will happen here by webflux after returning
		return accReactRepo.findById(id).doOnNext(result -> System.out.println("result found => "+result.getId()));
	}

	public Mono<Account> ingestAccountByReactive(Account acc) {
		Mono<Account> mono = accReactRepo.save(acc);
		System.out.println(mono);
		return mono;
	}
	
	public Flux<Account> getAccountsByValue(String value) {
		// Need to fix this
		System.out.println("Return from value");
		accReactRepo.findAllByValue(value).subscribe(result -> System.out.println("resilt ="+result));
		return null;
	}
	
}
