package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.IncomeTaxCalculatorImpl;
import com.github.sats17.problems.exceptions.WrongInputException;

public class IncomeTaxCalculator {
	
	/*
	 * Test method for valid ctc.
	 */
	@Test
	public void testIncomeTaxCalculatorWithValidInput() throws WrongInputException {
		assertEquals(2000.2, IncomeTaxCalculatorImpl.getTax(200020),0.02);
	}
	
	/*
	 * Test method for ctc greater than 1000000.
	 */
	@Test(expected = WrongInputException.class)
	public void testIncomeTaxCalculatorWithInvalidInput() throws WrongInputException {
		IncomeTaxCalculatorImpl.getTax(10000002);
	}
	
}
