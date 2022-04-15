package com.github.sats17.basicassignment;

import java.util.HashMap;
import java.util.Map;

/**
 * Immutable class means, values inside this class won't change later on.
 * Making class as final so, no one can inherit this.
 * @author Sats17
 *
 */
public final class ImmutableClass {
	
	// All fields should be final, so it will not change later
	private final String name;
	private final String lastName;
	private final Map<String, String> toys;

	/**
	 * Constructor is only way to set fields.
	 * @param name
	 * @param lastName
	 * @param toys
	 */
	public ImmutableClass(String name, String lastName, Map<String, String> toys) {
		this.name = name;
		this.lastName = lastName;
		this.toys = new HashMap<>();
		toys.forEach((key, value) -> {
			this.toys.put(key, value);
		});
	}


	public String getName() {
		return name;
	}


	public String getLastName() {
		return lastName;
	}

	/**
	 * Returning tempToys because no one from outside can modified toys hashmap
	 * @return
	 */
	public Map<String, String> getToys() {
 		Map<String, String> tempToys = new HashMap<>();
 		this.toys.forEach((key, value) -> {
			tempToys.put(key, value);
		});
		return tempToys;
	}
	
	
}
