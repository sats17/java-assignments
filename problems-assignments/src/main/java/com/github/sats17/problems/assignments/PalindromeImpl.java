package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.ValueOutOfRangeException;

public class PalindromeImpl {

	public static boolean isIntegerPalindrome(int number) throws ValueOutOfRangeException {
		
		if(number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
			throw new ValueOutOfRangeException("Please enter proper value.");
		}
		
		if(number < 0) {
			return false;
		}
		int tempNum = number;
		int checkNum = 0;
		while(tempNum > 0) {
			int remainder = tempNum % 10;
			checkNum = checkNum * 10 + remainder;
			tempNum /= 10;
		}
		if(checkNum == number) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static boolean isStringPalindrome(String str) {
		int startIndex = 0;
		int endIndex = str.length() - 1;
		int i = 0;
		boolean matched = true;
		while(i < str.length() / 2 ) {
			System.out.println("Start index "+str.charAt(startIndex) + " | End index "+ str.charAt(endIndex));
			
			if(str.charAt(startIndex) != str.charAt(endIndex)) {
				matched = false;
				break;
			}
			startIndex++;
			endIndex--;
			i++;
		}
		return matched;
	}
	
	public static void main(String[] args) {
		System.out.println(isStringPalindrome("ab"));
	}
	
}
