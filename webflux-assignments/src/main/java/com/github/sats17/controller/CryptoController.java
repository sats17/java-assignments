package com.github.sats17.controller;

import java.time.Duration;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;

import com.github.sats17.service.CoinService;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {
	
	@Autowired
	CoinService coinService;

	@GetMapping("/price")
	public Flux<String> getCurrentPriceOfCoin() {
		System.out.println("Getting coin price");
		return coinService.getCoinValue("razxDUgYGNAdQ");
	}
	
}
