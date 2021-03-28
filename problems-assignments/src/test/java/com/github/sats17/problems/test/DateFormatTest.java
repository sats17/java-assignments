package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.DateFormatImpl;
import com.github.sats17.problems.exceptions.WrongInputException;

public class DateFormatTest {
	
	/*
	 * Test method for valid date input.
	 */
	@Test
	public void testDateFormatWithValidInput() throws WrongInputException {
		assertEquals("09/Apr/1999", DateFormatImpl.fomater("09,04,1999"));
	}
	
	/*
	 * Test for invalid format.
	 */
	@Test(expected = WrongInputException.class)
	public void testDateFormatWithInvalidInput() throws WrongInputException {
		DateFormatImpl.fomater("22/12/1929");
	}
	
	/*
	 * Test for invalid year.
	 */
	@Test(expected = WrongInputException.class)
	public void testDateFormatWithInvalidYearInput() throws WrongInputException {
		DateFormatImpl.fomater("22,12,19292");
	}
	
	/*
	 * Test for invalid month.
	 */
	@Test(expected = WrongInputException.class)
	public void testDateFormatWithInvalidMonthInput() throws WrongInputException {
		DateFormatImpl.fomater("22,13,1929");
	}
	
	/*
	 * Test for invalid day.
	 */
	@Test(expected = WrongInputException.class)
	public void testDateFormatWithInvalidDayInput() throws WrongInputException {
		DateFormatImpl.fomater("34/12/1929");
	}
	
	/*
	 * Test for invalid leap year.
	 */
	@Test(expected = WrongInputException.class)
	public void testDateFormatWithInvalidLeapInput() throws WrongInputException {
		DateFormatImpl.fomater("31/02/2020");
	}
	
}
