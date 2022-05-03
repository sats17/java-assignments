package com.github.sats17.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EndpointConfig {
	
	@Autowired
	ConfigProperties configProperties;

	@Bean
	public DownstreamEndpoint userConfig() {
		String host = configProperties.getUsers().get("host");
		String port = configProperties.getUsers().get("port"); 
		String protocol = configProperties.getUsers().get("protocol");
		return new DownstreamEndpoint(WebClient.create(protocol+"://"+host+":"+port));
	}
	
	@Bean
	public DownstreamEndpoint coinConfig() {
		String host = configProperties.getCoins().get("host");
		String protocol = configProperties.getCoins().get("protocol");
		return new DownstreamEndpoint(WebClient.create(protocol+"://"+host));
	}
	
}
