package com.github.sats17.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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

	public void getUserById(String id) {
		String snsResponse = "False";
		String uriBuilder = "/users/" + id;
		List<Mono<User>> list = new ArrayList<>();
		test(uriBuilder);
		System.out.println("After sub");
	}
//		if(a.getId().equals("1") && ab.equals("False")) {
//			return false;
//		} else {
//			return true;
//		
//		for (int i = 0; i < 10; i++) {
//			list.add(test(uriBuilder));
////			Mono<User> b = test(uriBuilder);
//			
//		}
//		return Flux.merge(list).flatMap(test -> {
//			if(test.getId().equals("2")) {
//				return Mono.just("test1");
//			} else {
//				return Mono.just("test");
//			}
//		});
//	}

	public Mono<User> test(String uriBuilder) {

		userConfig.post(uriBuilder, null).doOnError(test -> {
			System.out.println("We got error Test");
		}).subscribe(consumer -> {
			if (consumer.statusCode().isError()) {
				System.out.println("Test rom subs");
			}

		});
		return null;

	}

	public String ingestAndForget(List<User> users) {
		users.stream().forEach(user -> {
			userConfig.post("/users", user).doOnError(clientError -> {
				System.out.println("Error occurs from webclient while ingesting data ");
			}).subscribe(response -> {
				if (response.statusCode().isError()) {
					System.out.println("Error occurs from downstream");
				} else {
					System.out.println("Data ingested");
				}
			});
		});

		return "Data will ingested soon";
	}

}
