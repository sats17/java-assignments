package com.github.sats17.problems.assignments;

import com.github.sats17.problems.exceptions.WrongInputException;
import com.github.sats17.problems.util.Grade;

public class CheckGradeImpl {

	public static int check(int[] marks) throws WrongInputException {
		
		int passed = 0;
		int promoted = 0;
		int failed = 0;
		for (int i = 0; i < marks.length; i++) {
			
			if(marks[i] > 100 || marks[i] < 0) {
				throw new WrongInputException("Please enter marks between 0 to 100.");
			}
			
			if (marks[i] <= 60) {
				failed++;
			} else {
				promoted++;
				passed++;
			}

		}
		
		if (failed >= 2) {
			return 2; // returns failed.
		} else if (promoted == 2) {
			return 1; // returns promoted.
		} else {
			return 0; // returns passed.
		}
	}
//	public static void main(String[] args) {
//		int v[] = new int[] {41,12,61};
//		System.out.println(check(v));
//	}

}
