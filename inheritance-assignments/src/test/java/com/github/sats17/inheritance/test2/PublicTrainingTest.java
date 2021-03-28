package com.github.sats17.inheritance.test2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.inheritance.exceptions.WrongInputException;
import com.github.sats17.inheritance.part2.PublicTraining;
import com.github.sats17.inheritance.part2.Training;

/**
 * @author sats17
 *
 */
public class PublicTrainingTest {
	
	Training trainObj ;
	
	/**
	 * @throws WrongInputException 
	 * 
	 */
	@Before
	public void setUp() throws WrongInputException {
		trainObj = new PublicTraining("Java", 20000, 31);
	}
	
	/*
	 * Test method for valid input.
	 */
	/**
	 * @throws WrongInputException
	 */
	@Test
	public void testWithValidInput() throws WrongInputException {
		assertEquals(620000.0, trainObj.orderValue(),0.02);
	}
	
	/**
	 * @throws WrongInputException
	 */
	@Test(expected = WrongInputException.class)
	public void testWithInvalidInput() throws WrongInputException {
		new PublicTraining("Java", 1232, -35);
	}
	
	/**
	 * Test method for correct order values calculator.
	 */
	@Test
	public void testOrderValues() {
		assertEquals(620000.0, trainObj.orderValue(),0.02);
	}
	
	/**
	 * Clear the all objects.
	 */
	@After
	public void clear() {
		trainObj = null;
	}
}
