package com.github.sats17.main;

import java.util.function.BiFunction;

import com.github.sats17.exception.InvalidInputException;
import com.github.sats17.exception.ValueOutOfRangeException;
import com.github.sats17.interfaces.ArithmaticOperations;

public class ArithmaticOperationsImpl {

	/**
	 * UserDefine Interface,lambda function.
	 */
	public static ArithmaticOperations addition = (num1, num2) ->{
		long result = num1 + num2;
		if(result > Integer.MAX_VALUE)
			throw new ValueOutOfRangeException("System error");
		return (int) (result);
	};
	
	
	/**
	 * lambda function use BiFunction interface for addition.
	 */
	public static BiFunction<Integer, Integer,Integer> add = (n1,n2) -> n1 + n2;

	public static ArithmaticOperations substraction = (num1, num2) ->{
		long result = num1 - num2;
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			throw new ValueOutOfRangeException("System error");
		return (int) (result);
	};
	
	public static int substra(int n, int m , BiFunction<Integer, Integer, Integer> fun) {
		fun.apply(n, m);
		return m;
	}
	
	
	public static ArithmaticOperations multiplication = (num1, num2) ->{
		long result = num1 * num2;
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			throw new ValueOutOfRangeException("System error");
		return (int) (result);
	};
	
	public static ArithmaticOperations division = (num1, num2) ->{
		if(num2 == 0) {
			throw new InvalidInputException("Divider cannot be zero."); 
		}
		long result = num1 / num2;
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			throw new ValueOutOfRangeException("System error");
		return (int) (result);
	};

}
	

