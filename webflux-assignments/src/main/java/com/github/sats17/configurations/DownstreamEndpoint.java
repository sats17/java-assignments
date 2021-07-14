package com.github.sats17.configurations;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class DownstreamEndpoint {

	private final WebClient webClient;
	
	public DownstreamEndpoint(WebClient webClient) {
		this.webClient = webClient;
	}

	/**
	 * @return the webClient
	 */
	public WebClient getWebClient() {
		return webClient;
	}
	
	@SuppressWarnings("deprecation")
	public Mono<ClientResponse> get(String uriPath) {
		return this.webClient
				   .get()
				   .uri(uriBuilder -> uriBuilder.path(uriPath).build())
				   .exchange();
	}
	
	@SuppressWarnings("deprecation")
	public Mono<ClientResponse> post(String uriPath, Object body) {
		return this.webClient
				   .post()
				   .uri(uriBuilder -> uriBuilder.path(uriPath).build())
				   .bodyValue(body)
				   .exchange();
	}
	
}
