package com.github.sats17.problems.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.AbsoluteDifference;
import com.github.sats17.problems.exceptions.WrongInputException;

public class AbsoluteDifferenceTest {
	
	/*
	 * Test method for valid inputs.
	 */
	@Test
	public void testDifferenceWithValidInputs() throws WrongInputException {
		int[] values = new int[] { 1, 3, 1, 6, 7, 8, 9, 3, 4, 5, 9 };
		int[] expected = new int[] { 1 };
		assertArrayEquals(expected, AbsoluteDifference.find(values, 4));
	}
	
	/*
	 * Test method for check whether range will exceed the array size or not.
	 */
	@Test
	public void testDifferenceWithValidRangeInputWithMatchingAtEndOfArray() throws WrongInputException {
		int[] values = new int[] { 1, 3, 1, 1, 7, 8, 9, 3, 4, 3, 9 };
		int[] expected = new int[] { 1, 1, 1,9, 3 };
		assertArrayEquals(expected, AbsoluteDifference.find(values, 5));
	}
	
	/*
	 * Test method for entered invalid input.
	 */
	@Test(expected = WrongInputException.class)
	public void testDifferenceWithInvalidRangeInput() throws WrongInputException {
		int[] values = new int[] { 1, 3, 1, 1};
		AbsoluteDifference.find(values, 5);
	}

}
