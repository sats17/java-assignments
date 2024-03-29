package com.github.sats17.configurations;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
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
	
	public Mono<ClientResponse> get(String uriPath) {
		return this.webClient
				   .get()
				   .uri(uriBuilder -> uriBuilder.path(uriPath).build())
				   .exchangeToMono(response -> {
					   return response.bodyToMono(ClientResponse.class);
				   });
	}
	
	public Mono<Object> get(String uriPath, MultiValueMap<String, String> headers, MultiValueMap<String, String> queryParams) {
		return this.webClient
				   .get()
				   .uri(uriBuilder -> uriBuilder.path(uriPath).queryParams(queryParams).build())
				   .headers(headersList -> {
					   headersList.addAll(headers);
				   })
				   .exchangeToMono(response -> {
					   return response.bodyToMono(String.class);
				   });
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
