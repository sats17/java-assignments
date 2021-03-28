package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;

public class FindMatchingStringOccurences {

	public static int getOccurences(String array[], String val) throws WrongInputException {

		// Raise an exception when invalid input are given.
		if (array.length == 0 || val.length() == 0) {
			throw new WrongInputException("Please enter proper input.");
		}

		int occurence = 0;
		// Iterarte over array for checking elements.
		for (int i = 0; i < array.length; i++) {
			// If condition matches occurence increase by 1.
			if (array[i].equals(val)) {
				occurence++;
			}
		}
		return occurence;
	}

}
