package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.SpaceAndWordRemoverImpl;
import com.github.sats17.problems.exceptions.WrongInputException;

public class SpaceAndWordRemoverTest {
	
	/*
	 * Test method with all valid input and output.
	 */
	@Test
	public void testWithValidInput() throws WrongInputException {
		assertEquals("hi hello bro", 
				SpaceAndWordRemoverImpl.refractorer("hi   sats17  hello     bro","sats17" , 2));
	}
	
	/*
	 * Test method with wrong position.
	 */
	@Test(expected = WrongInputException.class)
	public void testWithInvalidPositionInput() throws WrongInputException {
		SpaceAndWordRemoverImpl.refractorer("hi sats17   hello brother", "hello", 5);
	}
	
	/*
	 * Test method with mismatch of word and position.
	 */
	
	@Test(expected = WrongInputException.class)
	public void testWithMismatchOfPositionAndWord() throws WrongInputException {
		SpaceAndWordRemoverImpl.refractorer("hi sats17   hello brother", "sats17", 3);
	}
}
