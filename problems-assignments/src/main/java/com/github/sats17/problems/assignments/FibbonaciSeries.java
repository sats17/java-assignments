package com.github.sats17.problems.assignments;

import java.util.HashMap;

public class FibbonaciSeries {

	public static int getFibboNumberAtIndex(Integer index) {
		int val1 = 0;
		int val2 = 1;
		for(int i = 1; i < index - 1; i++) {
			val2 = val1 + val2;
			val1 = val2 - val1;
		}
		return val2;
	}

	public static int getFibboNumberAtIndexRecur(HashMap<Integer, Integer> map, Integer index) {
//		if(map.containsKey(index)) {
//			return map.get(index).intValue();
//		}
		if(index <= 1) {
			return index;
		} else {
			System.out.println("Loop");
			Integer val1 = getFibboNumberAtIndexRecur(map, index - 1);
			Integer val2 = getFibboNumberAtIndexRecur(map, index - 2);
			map.put(index, val1 + val2);
			return val1 + val2;
		}
	}
	
	public static void main(String[] args) {
//		getFibboNumberAtIndexRecur(new HashMap<>(), 20);
		String s1 = "satu";
		String s2 = "satu";
		System.out.println(s1 == s2);
	}
	
}
