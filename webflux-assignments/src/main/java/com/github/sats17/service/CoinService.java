package com.github.sats17.service;

import java.time.Duration;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ClientResponse;

import com.github.sats17.configurations.ConfigProperties;
import com.github.sats17.configurations.DownstreamEndpoint;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoinService { 
	
	@Autowired
	ConfigProperties configProperties;
	
	@Autowired
	DownstreamEndpoint coinConfig;
	
	/**
	 * Below implementation - 
	 * As you can see, we have created Flux that produces infinite stream. In that stream we are passing each object as Publisher(Mono)
	 * of webclient call. At last of Flux Stream we required to use flatmap for mapping flux<Mono<String>> to Flux<String>. By doing 
	 * this flatmap we are merging publishers into single publisher. If we don't merge then inner Mono publisher only return his 
	 * future object and it is not getting auto subscribing by webflux.
	 * 
	 * Also, Stream data is getting collected as a eager loading and later on it is getting subscribing after delaying time.
	 * 
	 * Current issue = As you can see from loggers, our currentTimeStamp is not dynamically passing. Because we are passing that time
	 * earlier and stream is eager loading that time kinda looks like fixed.
	 * @param coinCode
	 * @return
	 */
	public Flux<String> getCoinValue(String coinCode) {
		String apiKey = configProperties.getCoins().get("apikey");
		long currentTimestamp = System.currentTimeMillis() / 1000l;
		String uriPath = "/coin/"+coinCode+"/price";
		MultiValueMap<String, String> headerValues = new LinkedMultiValueMap<>();
		MultiValueMap<String, String> queryParamValues = new LinkedMultiValueMap<>();
		headerValues.add("X-RapidAPI-Key", apiKey);
		queryParamValues.add("timestamp", String.valueOf(currentTimestamp));
		
		return Flux.fromStream(Stream.generate(() -> {
			System.out.println(Thread.currentThread().getName()+" Flux Stream is started");
			System.out.println(currentTimestamp);
			return coinConfig.get(uriPath, headerValues, queryParamValues)
					.cast(String.class)
					.doOnSubscribe(onSubscribe -> System.out.println(Thread.currentThread().getName()+" Webclient call to API subscribed from coinService"))
					.doOnNext(result -> System.out.println(Thread.currentThread().getName()+" Do on next invoked for webclient call = result is = "+result));
		})).doOnSubscribe(print -> System.out.println(Thread.currentThread().getName()+" Flux Stream is subscribed from coinService"))
		  .delayElements(Duration.ofMillis(5000))
		  .flatMap(webClientPublisher -> webClientPublisher);	
	}

}
