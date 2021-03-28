package com.github.sats17.problems.assignments;

import java.util.ArrayList;
import java.util.Collections;

import com.github.sats17.problems.assignments.PalindromeImpl;
import com.github.sats17.problems.exceptions.ValueOutOfRangeException;
import com.github.sats17.problems.exceptions.WrongInputException;
import com.github.sats17.problems.util.convertArrayListToSimpleArray;

public class SortPalindromeImpl {

	public static int[] findAndSort(int array[]) throws ValueOutOfRangeException, WrongInputException {

		if (array.length == 0) {
			throw new WrongInputException("Array size must be greater than 0.");
		}

		ArrayList<Integer> resultArr = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {
			// Here we verify number is palindrome or not.
			if (PalindromeImpl.check(array[i])) {

				int tempVal = array[i];
				ArrayList<Integer> tempArr = new ArrayList<Integer>();

				// Logic for adding seperate digit in array.
				do {
					tempArr.add(tempVal % 10);
					tempVal /= 10;
				} while (tempVal > 0);

				int sortedVal = 0;

				// Sorting the values in descending order.
				Collections.sort(tempArr, Collections.reverseOrder());

				for (int j = 0; j < tempArr.size(); j++) {

					sortedVal = sortedVal * 10 + tempArr.get(j);

				}

				resultArr.add(sortedVal);

			}
		}
		// Calling other class method for conversion.
		return convertArrayListToSimpleArray.convert(resultArr);
	}

}
