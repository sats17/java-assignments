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
	
	public Flux<Account> getAccountsByValue(Integer value) {
		System.out.println("Return from value");
		Flux<Account> result = accReactRepo.findAllByValue(value)
							.doOnNext(test -> System.out.println("result found => "+test.getId()));
		System.out.println("After hitting query from service");
		return result;
	}
	
}
