package com.github.sats17.configurations;

import org.springframework.web.reactive.function.client.WebClient;

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
	
}
