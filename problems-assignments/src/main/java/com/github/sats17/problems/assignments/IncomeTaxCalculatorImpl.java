package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;

public class IncomeTaxCalculatorImpl {

	public static double getTax(double ctc) throws WrongInputException {
		if(ctc >=0 && ctc <= 180000) {
			return ctc * 00;
		}
		else if(ctc >= 181001 && ctc <= 300000) {
			return ctc * 0.01;
		}
		else if(ctc >= 300001 && ctc <= 500000) {
			return ctc * 0.02;
		}
		else if(ctc >= 500001 && ctc <= 1000000) {
			return ctc * 0.03;
		}
		else {
			throw new WrongInputException("CTC is not valid for this calculator.");
		}
	}
	
}
