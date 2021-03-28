package com.github.sats17.problems.assignments;

public class FindArmStrongNumberImpl {

	public static int find(int num) {
		int temp = num;
		long result = 0;
		
		// Loop for getting cube and adding each digit.
		while(temp > 0) {
			int remainder = temp % 10;
			result = result + remainder * remainder * remainder;
			temp /= 10;
		}
		
		// If calculate value and given number is same, then return 1 , else -1.
		if(result == num) {
			return 1;
		}
		else {

			return -1;
		}
	}

}
