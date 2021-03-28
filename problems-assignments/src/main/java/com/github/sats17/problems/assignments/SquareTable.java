package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.ValueOutOfRangeException;

public class SquareTable {

	public static int find(long num) throws ValueOutOfRangeException {
		if (num * num > Integer.MAX_VALUE || num * num < Integer.MIN_VALUE) {
			throw new ValueOutOfRangeException("Square value exceeded range.");
		}
		return (int) (num * num);
	}

}
