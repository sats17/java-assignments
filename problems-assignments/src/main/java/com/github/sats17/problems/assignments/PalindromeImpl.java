package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.ValueOutOfRangeException;

public class PalindromeImpl {

	public static boolean check(int number) throws ValueOutOfRangeException {
		
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
	
	

}
