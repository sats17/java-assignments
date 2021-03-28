package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.FindDiscountImpl;
import com.github.sats17.problems.exceptions.WrongInputException;

public class FindDiscountTest {

	/*
	 * Test with all valid input and output.
	 */
	@Test
	public void testDiscountWithValidInput() throws WrongInputException {
		assertEquals(00, FindDiscountImpl.find(50, 100), 0.02f);
	}

	/*
	 * Test with wrong price input.
	 */
	@Test(expected = WrongInputException.class)
	public void testDiscountCalculationWithWrongPriceInput() throws WrongInputException {
		FindDiscountImpl.find(-1, 12);
	}

	/*
	 * Test with wrong discount input.
	 */
	@Test(expected = WrongInputException.class)
	public void testDiscountCalculationWithWrongDiscountInput() throws WrongInputException {
		FindDiscountImpl.find(1, -12);
	}

}
