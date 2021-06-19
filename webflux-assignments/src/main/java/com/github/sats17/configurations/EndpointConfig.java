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
		System.out.println(configProperties.getTest());
		System.out.println("Users data "+configProperties.getUserConfig());
//		String host = configProperties.getUsers().get("host");
//		String port = configProperties.getUsers().get("port"); 
//		String protocol = configProperties.getUsers().get("protocol");
		System.out.println("test");
		return new DownstreamEndpoint(WebClient.create("test"));
	}
	
}
