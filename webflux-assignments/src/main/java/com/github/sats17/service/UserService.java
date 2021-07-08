package com.github.sats17.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sats17.configurations.DownstreamEndpoint;
import com.github.sats17.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	DownstreamEndpoint userConfig;
	
	public Flux<Object> getUserById(String id) {
		String uriBuilder = "/users/"+id;
		List<Mono<User>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(test(uriBuilder));
//			Mono<User> b = test(uriBuilder);
			
		}
		return Flux.merge(list).flatMap(test -> {
			if(test.getId().equals("2")) {
				return Mono.just("test1");
			} else {
				return Mono.just("test");
			}
		});
	}
	
	public Mono<User> test(String uriBuilder) {
		
		return userConfig.get(uriBuilder)
		.flatMap(transformer -> transformer.bodyToMono(User.class));
		
	}
	
}
