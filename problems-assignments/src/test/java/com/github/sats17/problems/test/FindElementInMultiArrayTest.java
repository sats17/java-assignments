package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.FindElementInMultiArrayImpl;
import com.github.sats17.problems.exceptions.WrongInputException;

public class FindElementInMultiArrayTest {

	/*
	 * Test With all valid input and output.
	 */
	@Test
	public void testWithValidInput() throws WrongInputException {
		int[][] values = new int[][] {{1,2,3},{8,6}};
		assertEquals(1, FindElementInMultiArrayImpl.check(values,3));
	}
	
	
	/*
	 *  Test to check when number is not present in array.
	 */
	@Test
	public void testWithValidInputButDataNotInArray() throws WrongInputException {
		int[][] values = new int[][] {{1,2,3},{8,6}};
		assertEquals(-1, FindElementInMultiArrayImpl.check(values,10));
	}
	
	
	/*
	 *  Test to raise exception when array size is zero.
	 */
	@Test(expected = WrongInputException.class)
	public void testWithArraySizeZero() throws WrongInputException {
		int[][] values = new int[][] {};
		FindElementInMultiArrayImpl.check(values, 2);
	}
	
}
