package com.github.sats17.problems.assignments;

import java.util.ArrayList;

import com.github.sats17.problems.exceptions.WrongInputException;
import com.github.sats17.problems.util.convertArrayListToSimpleArray;

public class AbsoluteDifference {

	/*
	 * find Method will return array of values , that are same in given array and in
	 * particular range .
	 */
	public static int[] find(int[] values, int range) throws WrongInputException {
		if(range > values.length) {
			throw new WrongInputException("Please enter valid range.");
		}
		ArrayList<Integer> tempArrList = new ArrayList<Integer>();
		for (int i = 0; i < values.length - 1; i++) {
			int currentRange = range;
			int diff = values.length - i;
			
			/*
			 * Check for if range is will exceed the array size.
			 */
			if (currentRange > diff) {
				currentRange = diff - 1;
			}
			int j = i + 1;
			int helper = 1;
			/*
			 * Runs the inner loop in given range.
			 */
			while (helper < currentRange) {
				if (values[i] == values[j]) {
					tempArrList.add(values[i]);
				}
				helper++;
				j++;
			}

		}

		return convertArrayListToSimpleArray.convert(tempArrList);
	}

}
