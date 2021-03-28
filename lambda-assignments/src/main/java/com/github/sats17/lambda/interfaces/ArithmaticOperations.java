package com.github.sats17.lambda.interfaces;

import com.github.sats17.lambda.exception.InvalidInputException;
import com.github.sats17.lambda.exception.ValueOutOfRangeException;

@FunctionalInterface
public interface ArithmaticOperations {

	public int calculate(long num1,long num2) throws ValueOutOfRangeException,InvalidInputException;
	
}
