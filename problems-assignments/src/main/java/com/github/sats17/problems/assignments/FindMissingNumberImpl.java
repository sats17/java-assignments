package com.github.sats17.problems.assignments;

import java.util.ArrayList;
import java.util.Arrays;

import com.github.sats17.problems.util.convertArrayListToSimpleArray;

public class FindMissingNumberImpl {

	public static int[] find(int[] values) {

		// Sorting array in ascending order.
		Arrays.sort(values);
		System.out.println(values[0]);
		ArrayList<Integer> missingValues = new ArrayList<Integer>();

		// Iterating over array by n - 2 range.
		for (int i = 0; i < values.length - 1; i++) {

			int getCurrentVal = values[i];
			int getNextVal = values[i + 1];

			/*
			 * We will check difference between current iterator value and next iterator
			 * value.
			 */
			int findDiff = getNextVal - getCurrentVal;
			
			/*
			 * If there is one or no difference then there is no missing value between them.
			 */
			if (findDiff == 0 || findDiff == 1) {
				continue;
			}
			/*
			 * Else, we will check size of difference and according to size we 
			 * will add missing values.
			 */
			else {
				int flag = 1;
				findDiff--;
				while (findDiff > 0) {
					missingValues.add(values[i] + flag);
					flag++;
					findDiff--;
				}
			}
		}
		
		//Calling method from other class that convert ArrayList to Array.
		return convertArrayListToSimpleArray.convert(missingValues);

	}

}
