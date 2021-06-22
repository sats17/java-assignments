package com.github.sats17.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.sats17.configurations.DownstreamEndpoint;
import com.github.sats17.model.User;

import reactor.core.publisher.Mono;

public class UserService {

	@Autowired
	DownstreamEndpoint userConfig;
	
	Mono<User> getUserById(String id) {
		return null;
	}
	
}
