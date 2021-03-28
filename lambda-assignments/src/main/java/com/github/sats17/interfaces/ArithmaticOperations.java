package com.github.sats17.interfaces;

import com.github.sats17.exception.InvalidInputException;
import com.github.sats17.exception.ValueOutOfRangeException;

@FunctionalInterface
public interface ArithmaticOperations {

	public int calculate(long num1,long num2) throws ValueOutOfRangeException,InvalidInputException;
	
}
