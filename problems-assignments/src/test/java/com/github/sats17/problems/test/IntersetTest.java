package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.InterestImpl;
import com.github.sats17.problems.exceptions.WrongInputException;

public class IntersetTest {
	
	/*
	 * Test simpleInterest method with valid input.
	 */
	@Test
	public void testSimpleInterestWithValidInput() throws WrongInputException {
		assertEquals(1515.15, InterestImpl.simpleInterest(20202,2.5,3),0.02);
	}
	
	/*
	 * Test compound interest method with valid input.
	 */
	@Test
	public void testCompundInterestWithValidInput() throws WrongInputException {
		assertEquals(1333.09, InterestImpl.compoundInterest(1200,5.4,2),0.02);
	}
	
	/*
	 * Test compound interest method with Invalid input.
	 */
	@Test(expected = WrongInputException.class)
	public void testCompundInterestWithInvalidInput() throws WrongInputException {
		InterestImpl.compoundInterest(00,5.4,2);
	}
	
	/*
	 * Test compound interest method with Invalid input.
	 */
	@Test(expected = WrongInputException.class)
	public void testSimpleInterestWithInvalidInput() throws WrongInputException {
		InterestImpl.simpleInterest(00,5.4,2);
	}

}
