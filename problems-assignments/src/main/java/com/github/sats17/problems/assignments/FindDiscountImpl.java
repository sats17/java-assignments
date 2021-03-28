package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;

public class FindDiscountImpl {

	public static float find(int price, int discount) throws WrongInputException {

		/*
		 * Will raise an exception when price and discount are less than zero
		 */
		if (price <= 0 || discount <= 0) {
			throw new WrongInputException("Please enter values properly.");
		}

		// Formula for discount price.
		float discountAmt = price * discount / 100;
		return price - discountAmt;
	}
}
