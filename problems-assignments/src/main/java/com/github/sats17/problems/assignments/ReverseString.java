package com.github.sats17.problems.assignments;

public class ReverseString {
	
	// Time complexity O(n) where n is length of string,
	public static String reverseStringWithLoop(String str) {
		int len = str.length();
		String finalString = "";
		System.out.println(len);
		for(int i = len - 1; i >= 0; i--) {
			System.out.println(str.charAt(i));
			finalString = finalString + str.charAt(i);
		}
		return finalString;
	}

	public static void main(String[] args) {
		String str = "satish";
		System.out.println(reverseStringWithLoop(str));
	}
	
}
