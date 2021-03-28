package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;

public class ReverseStringImpl {

	public static String reverse(String string) throws WrongInputException {

		if (string.length() == 0) {
			throw new WrongInputException("String size must be greater than zero.");
		}
		String checkString = "";
		String reverseString = "";

		// Iterate loop over string by chararacter to character.
		for (int i = 0; i < string.length(); i++) {

			/*
			 * If we found any space, that means word has ended so we just update our
			 * reverse string by adding checkString and current character. And make
			 * checkString empty.
			 */
			if (string.charAt(i) == ' ') {
				reverseString = reverseString + checkString + string.charAt(i);
				checkString = "";
			}
			/*
			 * For last word of string and last character of that word we update
			 * reverseString by adding older reverseString , current character and
			 * checkString.
			 */
			else if (i == string.length() - 1) {
				reverseString = reverseString + string.charAt(i) + checkString;
				checkString = "";
			}
			/*
			 * For every character in string, we just added character to checkString.
			 */
			else {
				checkString = string.charAt(i) + checkString;
			}

		}
		return reverseString;
	}

}
