package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;

public class FindElementInMultiArrayImpl {

	public static int check(int[][] valuesArr, int value) throws WrongInputException {
		
		//Will raise an exception when array size is zero.
		if (valuesArr.length <= 0) {
			throw new WrongInputException("Array size must be greater than 0.");
		}

		int result = -1;
		
		//Iterating over outer loop.
		for (int i = 0; i < valuesArr.length; i++) {
			//Iterating over inner loop.
			for (int j = 0; j < valuesArr[i].length; j++) {
				if (valuesArr[i][j] == value) {
					result = 1;
					break;		//Break the loop when value found.
				}
			}
		}
		return result;
	}

}
