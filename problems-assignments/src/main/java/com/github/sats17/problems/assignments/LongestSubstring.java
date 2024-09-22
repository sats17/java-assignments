package com.github.sats17.problems.assignments;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static String findLongestSubstringWithoutRepeation(String str) {
		
		// pwwked
		
		int leng = str.length();
		
		int counter = 0;
		
		Map<String, Integer> tempData = new HashMap<>();
		StringBuilder longestSubstring = new StringBuilder();
		while(counter < leng) {
			String letter = Character.toString(str.charAt(counter));
			if(tempData.containsKey(letter)) {
				counter = tempData.get(letter) + 1;
				longestSubstring = new StringBuilder("");
				tempData.clear();
			} else {
				tempData.put(letter, counter);
				counter++;
				longestSubstring.append(letter);
			}
		}
		
		return longestSubstring.toString();
	}
	
	public static void main(String[] args) {
		String str = "ppppp";
		String op = findLongestSubstringWithoutRepeation(str);
		System.out.println(op);
	}
}
