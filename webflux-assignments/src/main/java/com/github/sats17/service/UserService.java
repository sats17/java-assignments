package com.github.sats17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sats17.configurations.DownstreamEndpoint;
import com.github.sats17.model.User;

import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	DownstreamEndpoint userConfig;
	
	public Mono<User> getUserById(String id) {
		String uriBuilder = "/users/"+id;
		return userConfig.get(uriBuilder)
				.flatMap(transformer -> transformer.bodyToMono(User.class));
	}
	
}
