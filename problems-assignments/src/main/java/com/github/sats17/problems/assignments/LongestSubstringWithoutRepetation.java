package com.github.sats17.problems.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepetation {

	public static String getString(String str) {
		int strLen = str.length();
		List<String> strList = new ArrayList<>();
		int lastVisitedIndex = 0;
		Map<Character, Integer> tempMap = new HashMap<>();
		for (int i = 0; i < strLen; i++) {

			if (!tempMap.containsKey(str.charAt(i))) {
				tempMap.put(str.charAt(i), i);
			} else {
				String newStr = str.substring(lastVisitedIndex, i);
				strList.add(newStr);
				lastVisitedIndex = tempMap.get(str.charAt(i)) + 1;
				i = lastVisitedIndex;
				tempMap = new HashMap<>();
				tempMap.put(str.charAt(i), i);

			}
		}
		System.out.println(lastVisitedIndex);
		String newStr = str.substring(lastVisitedIndex, strLen);
		strList.add(newStr);
		strList.forEach(System.out::println);
		int maxLen = 0;
		String finalString = "";
		for (int i = 0; i < strList.size(); i++) {
			if (maxLen <= strList.get(i).length()) {
				maxLen = strList.get(i).length();
				finalString = strList.get(i);
			}
		}
		return finalString;
	}

	/**
	 * Optimized by removing array list that was storing long strings. And used condition to find out longest substring.
	 */
	public static String getStringV2(String str) {
		int strLen = str.length();
		String longestString = "";
		int lastVisitedIndex = 0;
		Map<Character, Integer> tempMap = new HashMap<>();
		for (int i = 0; i < strLen; i++) {

			if (!tempMap.containsKey(str.charAt(i))) {
				tempMap.put(str.charAt(i), i);
			} else {
				String newStr = str.substring(lastVisitedIndex, i);
				if (longestString.length() < newStr.length()) {
					longestString = newStr;
				}
				lastVisitedIndex = tempMap.get(str.charAt(i)) + 1;
				i = lastVisitedIndex;
				tempMap = new HashMap<>();
				tempMap.put(str.charAt(i), i);
			}
		}
		System.out.println(lastVisitedIndex);
		String newStr = str.substring(lastVisitedIndex, strLen);
		if (longestString.length() < newStr.length()) {
			longestString = newStr;
		}
		return longestString;
	}

	public static void main(String[] args) {
		String input = "dvdf";
		System.out.println("INput = "+input);
		String str = getString(input);
		System.out.println("v1=" + str);
		String str2 = getStringV2(input);
		System.out.println("v2=" + str2);
//		if (str.length() == str2.length()) {
//			System.out.println("Same lenght");
//		} else {
//			System.out.println("Not same length");
//		}

	}

}
