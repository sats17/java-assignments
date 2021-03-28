package com.github.sats17.inheritance.part2;

import com.github.sats17.inheritance.exceptions.WrongInputException;

/**
 * @author sats17
 *
 */
public class CorporateTraining extends Training {

	
	private int days;
	
	/**
	 * @param subject
	 * @param fees
	 * @param days
	 * @throws WrongInputException
	 */
	public CorporateTraining(String subject,double fees,int days) throws WrongInputException {
		super(subject,fees);
		if(fees <= 0 || days <=0 ) {
			throw new WrongInputException("invalid input.");
		}
		this.days = days;
		
	}
	
	public double orderValue() {
		return this.getFees() * this.days;
	}
	
	public static void main(String[] args) throws WrongInputException {
		Training corpTrain = new CorporateTraining("Java", 20000, 31);
		System.out.println(corpTrain.orderValue());
	}
	
}
