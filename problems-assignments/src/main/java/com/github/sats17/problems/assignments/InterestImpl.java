package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;

public class InterestImpl {
	
	/*
	 * Method for finding simple interest.
	 */
	public static double simpleInterest(double principle, double rate, double time) throws WrongInputException {
		
		checkValidInput(principle, rate, time);
		
		double simpleInterest;
        simpleInterest = (principle * rate * time) / 100;
		return simpleInterest;
	}
	
	/*
	 * Method for finding compound interest.
	 */
	public static double compoundInterest(double principle, double rate, double time) throws WrongInputException {
		
		checkValidInput(principle, rate, time);
		
		double compundInterest = principle * 
                (Math.pow((1 + rate / 100), time)); 
		return compundInterest;
	}
	
	static void checkValidInput(double principle,double rate,double time) throws WrongInputException {
		if(principle <= 0 || rate <= 0 || time <= 0) {
			throw new WrongInputException("Please enter proper values");
		}
	}
	
}
