package com.github.sats17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ClientResponse;

import com.github.sats17.configurations.ConfigProperties;
import com.github.sats17.configurations.DownstreamEndpoint;

import reactor.core.publisher.Mono;

@Service
public class CoinService { 
	
	@Autowired
	ConfigProperties configProperties;
	
	@Autowired
	DownstreamEndpoint coinConfig;
	
	public Mono<String> getCoinValue(String coinCode) {
		String apiKey = configProperties.getCoins().get("apikey");
		long currentTimestamp = System.currentTimeMillis() / 1000l;
		String uriPath = "/coin/"+coinCode+"/price";
		MultiValueMap<String, String> headerValues = new LinkedMultiValueMap<>();
		MultiValueMap<String, String> queryParamValues = new LinkedMultiValueMap<>();
		headerValues.add("X-RapidAPI-Key", apiKey);
		queryParamValues.add("timestamp", String.valueOf(currentTimestamp));
		System.out.println(headerValues.toString());
		System.out.println(uriPath);
		System.out.println(queryParamValues.toString());
		return coinConfig.get(uriPath, headerValues, queryParamValues).cast(String.class).doOnNext(result -> System.out.println(result));
		
	}

}
