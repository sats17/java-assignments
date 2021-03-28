package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.FindArmStrongNumberImpl;

public class FindArmStrongNumberTest {
	
	/*
	 * Test method with valid input.
	 */
	@Test
	public void testArmStrongNumberWithValidInput() {
		assertEquals(1, FindArmStrongNumberImpl.find(153));
	}
	
	/*
	 * Test method for number that is not armstrong.
	 */
	@Test
	public void testNumberIsNotArmStrong() {
		assertEquals(-1, FindArmStrongNumberImpl.find(156));
	}
	
	/*
	 * Test method for negative number that is not armstrong.
	 */
	@Test
	public void testNegativeNumberIsNotArmStrong() {
		assertEquals(-1, FindArmStrongNumberImpl.find(-153));
	}
	
}
