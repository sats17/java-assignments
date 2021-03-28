package com.github.sats17.problems.assignments;

import java.util.ArrayList;

import com.github.sats17.problems.util.convertArrayListToSimpleArray;

public class FindArmStrongNumberInRangeImpl {

	public static int[] find(int num1, int num2) {
		ArrayList<Integer> resultArr = new ArrayList<Integer>();
		for(int i = num1; i <= num2;i++) {
			if(FindArmStrongNumberImpl.find(i) == 1) {
				resultArr.add(i);
			}
		}
		
		return convertArrayListToSimpleArray.convert(resultArr);
	}
}
