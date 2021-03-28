package com.github.sats17.problems.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.FindMissingNumberImpl;

public class FindMissingNumberTest {

	/*
	 * Test method with all valid input and output.
	 */
	@Test
	public void testMissingNumberWithValidInput() {
		int values[] = new int[] { 3,0,1};
		int expected[] = new int[] {  2 };
		assertArrayEquals(expected, FindMissingNumberImpl.find(values));
	}

//	/*
//	 * Test method with only two inputs.
//	 */
//	@Test
//	public void testMissingNumberWithTwoInput() {
//		int values[] = new int[] { 10, 1 };
//		int expected[] = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };
//		assertArrayEquals(expected, FindMissingNumberImpl.find(values));
//	}
//
//	/*
//	 * Test method that check array has zero missing number.
//	 */
//	@Test
//	public void testMissingNumberWithZeroMissingNumber() {
//		int values[] = new int[] { 1, 2 };
//		int expected[] = new int[] {};
//		assertArrayEquals(expected, FindMissingNumberImpl.find(values));
//	}
//
//	/*
//	 * Test method that contain negative missing numbers.
//	 */
//	@Test
//	public void testMissingNumberWithNegativeMissingNumber() {
//		int values[] = new int[] { -3, 1, 2 };
//		int expected[] = new int[] { -2, -1, 0 };
//		assertArrayEquals(expected, FindMissingNumberImpl.find(values));
//	}
}
