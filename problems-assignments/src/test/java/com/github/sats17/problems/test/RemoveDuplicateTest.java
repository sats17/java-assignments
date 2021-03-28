package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.RemoveDuplicateImpl;
import com.github.sats17.problems.exceptions.WrongInputException;

public class RemoveDuplicateTest {

	/*
	 * Test method with all valid input.
	 */
	@Test
	public void testWithValidInput() throws WrongInputException {
		assertEquals("as7bo.", RemoveDuplicateImpl.getDuplicate("as7abboo.."));
	}

	/*
	 * Test method with all unique characters string.
	 */
	@Test
	public void testWithContainsAllUniqueInput() throws WrongInputException {
		assertEquals("uniqe", RemoveDuplicateImpl.getDuplicate("uniqe"));
	}

	/*
	 * Test method with empty string.
	 */
	@Test(expected = WrongInputException.class)
	public void testWithEmptyString() throws WrongInputException {
		RemoveDuplicateImpl.getDuplicate("");
	}

}
