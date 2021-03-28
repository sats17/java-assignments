package com.github.sats17.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.exception.InvalidInputException;
import com.github.sats17.exception.ValueOutOfRangeException;
import com.github.sats17.main.ArithmaticOperationsImpl;

public class ArithmaticOperationTest {
	
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAdditionOfTwoValidNumbers() throws ValueOutOfRangeException, InvalidInputException {
		
		assertEquals(new Integer(10), ArithmaticOperationsImpl.add.apply(5, 5));
		assertEquals(120, ArithmaticOperationsImpl.addition.calculate(60,60));
	}
	
	@Test(expected = ValueOutOfRangeException.class)
	public void testAdditionBeyondLimit() throws ValueOutOfRangeException, InvalidInputException {
		ArithmaticOperationsImpl.addition.calculate(2147483647, 999999999);
	}
	
	@Test
	public void testValidMultiplication() throws ValueOutOfRangeException, InvalidInputException {
		assertEquals(25, ArithmaticOperationsImpl.multiplication.calculate(5, 5));
	}
	
	@Test(expected = ValueOutOfRangeException.class)
	public void testMultiplicationBeyondLimit () throws ValueOutOfRangeException, InvalidInputException {
		ArithmaticOperationsImpl.multiplication.calculate(999999999,999999999);
	}
	
	@Test
	public void testValidDivision() throws InvalidInputException, ValueOutOfRangeException {
		assertEquals(3, ArithmaticOperationsImpl.division.calculate(15, 5),0.02);
	}
	
	@Test(expected = InvalidInputException.class)
	public void testDivisionWithZero() throws InvalidInputException, ValueOutOfRangeException {
		System.out.println(ArithmaticOperationsImpl.division.calculate(15, 0));
	}
	
	@Test(expected = ValueOutOfRangeException.class)
	public void testSubstractionBeyondLimit() throws ValueOutOfRangeException, InvalidInputException {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MIN_VALUE - 1);
		ArithmaticOperationsImpl.substraction.calculate(4, -2147483647);
	}

}
