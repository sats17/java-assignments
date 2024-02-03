package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.PalindromeImpl;
import com.github.sats17.problems.exceptions.ValueOutOfRangeException;

public class PalindromeTest {
	
	/*
	 * Test method for valid input and output.
	 */
	@Test
	public void testPalindromeForValidNumber() throws ValueOutOfRangeException {
		assertEquals(true, PalindromeImpl.isIntegerPalindrome(121));
	}
	
	/*
	 * Test method for negative number.
	 */
	@Test
	public void testPalindromeForNegativeNumber() throws ValueOutOfRangeException {
		assertEquals(false, PalindromeImpl.isIntegerPalindrome(-121));
	}
	
	/*
	 * Test method for number that is not palindrome.
	 */
	@Test
	public void testPalindromeForInValidNumber() throws ValueOutOfRangeException {
		assertEquals(false, PalindromeImpl.isIntegerPalindrome(10));
	}
	
	
	
	
}
