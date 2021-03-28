package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.ReverseStringImpl;
import com.github.sats17.problems.exceptions.WrongInputException;

public class ReverseStringTest {
	
	/*
	 * Test method with valid input and output.
	 */
	@Test
	public void testValidOutputForReverseString() throws WrongInputException {
		assertEquals("olleH ,71staS s'tel od ti", ReverseStringImpl.reverse("Hello Sats17, let's do it"));
	}
	
	/*
	 * Test method with empty string.
	 */
	@Test(expected = WrongInputException.class)
	public void testWithEmptyString() throws WrongInputException {
		ReverseStringImpl.reverse("");
	}
	
} 
