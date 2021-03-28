package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;

public class RemoveDuplicateImpl {

	public static String getDuplicate(String string) throws WrongInputException {

		if (string.length() == 0) {
			throw new WrongInputException("Please enter proper input.");
		}

		char[] stringArr = string.toCharArray();
		String uniqueString = "";

		for (int i = 0; i < stringArr.length; i++) {
			// Ignore when iteration when duplicate found.
			if (uniqueString.indexOf(stringArr[i]) != -1) {
				continue;
			} else {
				uniqueString = uniqueString + stringArr[i];
			}
		}
		return uniqueString;
	}

}
