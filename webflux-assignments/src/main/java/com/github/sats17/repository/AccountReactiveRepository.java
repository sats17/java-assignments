package com.github.sats17.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.github.sats17.model.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountReactiveRepository extends ReactiveCrudRepository<Account, String> {

	Flux<Account> findAllByValue(Integer value);
    Mono<Account> findFirstByOwner(Mono<String> owner);
	
}
