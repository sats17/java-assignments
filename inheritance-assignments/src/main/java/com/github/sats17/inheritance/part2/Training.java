package com.github.sats17.inheritance.part2;

import com.github.sats17.inheritance.exceptions.WrongInputException;

/**
 * @author sats17
 *
 */
public class Training {
	
	private int id;
	private String subject;
	private double fees;
	
	/**
	 * Default constructor used for generate id.
	 */
	public Training() {
		++this.id;
	}
	
	/**
	 * @param subject
	 * @param fees
	 * @throws WrongInputException
	 */
	public Training(String subject,double fees) throws WrongInputException {
		this();
		if(subject.length() == 0) {
			throw new WrongInputException("Invalid input.");
		}
		this.subject = subject;
		this.fees = fees;
	}

	/**
	 * @return fees
	 */
	public double getFees() {
		return fees;
	}

	/**
	 * @param fees
	 */
	public void setFees(double fees) {
		this.fees = fees;
	};
	
	/**
	 * @return fees
	 */
	public double orderValue() {
		return this.fees;
	}
	
	
	
}
