package com.github.sats17.inheritance.part2;

import com.github.sats17.inheritance.exceptions.WrongInputException;

/**
 * @author sats17
 *
 */
public class PublicTraining extends Training {
	
	private int participants;
	
	/**
	 * @param subject
	 * @param fees
	 * @param participants
	 * @throws WrongInputException
	 */
	public PublicTraining(String subject,double fees,int participants) throws WrongInputException {
		super(subject,fees);
		if(fees <=0 || participants <= 0) {
			throw new WrongInputException("Invalid input.");
		}
		
		this.participants = participants;
		
	}
	
	public double orderValue() {
		return this.getFees() * this.participants;
	}
	
}
