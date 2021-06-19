package com.github.sats17.configurations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class ConfigProperties {
	
	private String test;

	private Map<String, String> user = new HashMap<>();

	/**
	 * @return the user
	 */
	public Map<String, String> getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Map<String, String> user) {
		this.user = user;
	}

	/**
	 * @return the usersConfig
	 */
	public Map<String, String> getUserConfig() {
		return user;
	}

	/**
	 * @return the test
	 */
	public String getTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(String test) {
		this.test = test;
	}

}
