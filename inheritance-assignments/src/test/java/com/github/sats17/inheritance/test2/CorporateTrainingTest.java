package com.github.sats17.inheritance.test2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.inheritance.exceptions.WrongInputException;
import com.github.sats17.inheritance.part2.CorporateTraining;
import com.github.sats17.inheritance.part2.Training;

/**
 * @author sats17
 *
 */
public class CorporateTrainingTest {
	
	Training corpTrain;
	
	@Before
	public void setUp() throws WrongInputException {
		corpTrain = new CorporateTraining("Java", 20000, 31);
		System.out.println(corpTrain.orderValue());
	}
	
	/**
	 * @throws WrongInputException
	 */
	@Test
	public void testWithValidInput() throws WrongInputException {
		assertEquals(620000.0, corpTrain.orderValue(),0.02);
	}
	

	/**
	 * @throws WrongInputException
	 */
	@Test(expected = WrongInputException.class)
	public void testWithInValidInput() throws WrongInputException {
		corpTrain = new CorporateTraining("Java", 20000, -33);
	}
	
	@After
	public void clear() {
		corpTrain = null;
	}
}
