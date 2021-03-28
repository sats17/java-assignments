package com.github.sats17.problems.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.github.sats17.problems.assignments.SortPalindromeImpl;
import com.github.sats17.problems.exceptions.ValueOutOfRangeException;
import com.github.sats17.problems.exceptions.WrongInputException;

public class SortPalindromeTest {
	/*
	 * Test with all valid inputs.
	 */
	@Test
	public void testValidSorting() throws ValueOutOfRangeException, WrongInputException {
		int values[] = new int[] {545,669,12221,11211,93539};
		int expected[] = new int[] {554,22211,21111,99533};
		assertArrayEquals(expected, SortPalindromeImpl.findAndSort(values));
	}
	
	/*
	 * Test with no palindrome in array.
	 */
	@Test
	public void testValidSortingWithNoPalindrome() throws ValueOutOfRangeException, WrongInputException {
		int values[] = new int[] {123};
		int expected[] = new int[] {};
		assertArrayEquals(expected, SortPalindromeImpl.findAndSort(values));
	}
	
	/*
	 * Test with empty array.
	 */
	@Test(expected = WrongInputException.class)
	public void testWithEmptyArray() throws ValueOutOfRangeException, WrongInputException {
		int values[] = new int[] {};
		SortPalindromeImpl.findAndSort(values);
	}
	
	
	
	
}
