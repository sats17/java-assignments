package com.github.sats17.configurations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties
public class ConfigProperties {

	private Map<String, String> users = new HashMap<>();

	/**
	 * @return the users
	 */
	public Map<String, String> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Map<String, String> users) {
		this.users = users;
	}

}
