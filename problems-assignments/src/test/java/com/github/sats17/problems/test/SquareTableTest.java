package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.SquareTable;
import com.github.sats17.problems.exceptions.ValueOutOfRangeException;

public class SquareTableTest {
	/*
	 * Test method with valid input.
	 */
	@Test
	public void testSquareTableWithValidInput() throws ValueOutOfRangeException {
		assertEquals(25, SquareTable.find(5));
	}

	/*
	 * Test method with valid negative input.
	 */
	@Test
	public void testSquareTableWithValidNegativeInput() throws ValueOutOfRangeException {
		assertEquals(25, SquareTable.find(-5));
	}

	/*
	 * Test method with out of range output.
	 */
	@Test(expected = ValueOutOfRangeException.class)
	public void testSquareTableWithOutOfRangeOutput() throws ValueOutOfRangeException {
		SquareTable.find(2147483647);
	}
}
