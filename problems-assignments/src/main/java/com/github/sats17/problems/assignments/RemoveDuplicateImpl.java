package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;

public class RemoveDuplicateImpl {

	public static String getDuplicateFromString(String string) throws WrongInputException {

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
	
	public static int removeDuplicateFromIntArrAndGetUniqueCount(int[] intArr) {
		int pointer1 = 0;
		int pointer2 = 0;
		int uniqueCount = 0;
		while(pointer1 < intArr.length && pointer2 < intArr.length) {
			System.out.println("Printed");
			if(intArr[pointer1] == intArr[pointer2]) {
				pointer2++;
				if(pointer2 >= intArr.length) {
					uniqueCount++;
				}
			} else {
				pointer1 = pointer2;
				uniqueCount++;
			}
		}
		
		return uniqueCount;
	}

	public static void main(String[] args) {
		int[] intArr = {1,2,3};
		int ans = removeDuplicateFromIntArrAndGetUniqueCount(intArr);
		System.out.println("Answer: " + ans);
	}
	
}
