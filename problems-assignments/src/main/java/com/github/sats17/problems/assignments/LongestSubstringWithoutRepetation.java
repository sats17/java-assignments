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
	 * Optimized by removing array list that was storing long strings. And used
	 * condition to find out longest substring.
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

	/**
	 * 
	 * uses variable sliding algorithm, to iterate over string array. If any
	 * duplicate element we found in tempMap while iterating then we just increased
	 * the first pointer with index + 1 and start removing those values from map,
	 * until the first pointer reaches duplicate element index(Or second pointer),
	 * and once duplicate element got removed from map, the second pointer will move
	 * ahead. While doing this operation, whenever we found second pointer is
	 * duplicate in map, we just perform substring operation and calculate the
	 * longestSubstring.
	 *
	 * The problem here is that we are not removing all previous values from the
	 * duplicate element index, which cause first pointer to iterate n times till duplicate element and with that we are removing those.
	 * Improvement can be if we found the element as duplicate in map then remove that
	 * duplicate element and mark duplicate element index + 1 as first pointer. Also remove all previous values present in hashmap 
	 * which are previous to duplicate element from map. (These is hardest part to do)
	 * 
	 * 
	 */
	public static String getStringV3(String str) {
		int strLen = str.length();
		int firstPointer = 0;
		int secondPointer = 0;
		String longestString = "";
		Map<Character, Integer> tempMap = new HashMap<>();
		while (firstPointer < strLen && secondPointer < strLen) {
			if (!tempMap.containsKey(str.charAt(secondPointer))) {
				tempMap.put(str.charAt(secondPointer), secondPointer);
				secondPointer++;
			} else {
				System.out.println("This value preesnt in map " + str.charAt(secondPointer));
				System.out.println(tempMap.toString());
				String newStr = str.substring(firstPointer, secondPointer);
				if (longestString.length() < newStr.length()) {
					longestString = newStr;
				}
				Character firstPointerValue = str.charAt(firstPointer);
				firstPointer = tempMap.get(firstPointerValue) + 1;
				System.out.println("New first pointer " + firstPointer);
				System.out.println("Value will get remove from map " + firstPointerValue);
				tempMap.remove(firstPointerValue);
			}
		}
		System.out.println("Outside loop");
		System.out.println(tempMap.toString());
		System.out.println("First pointer " + firstPointer);
		String newStr = str.substring(firstPointer, strLen);
		if (longestString.length() < newStr.length()) {
			longestString = newStr;
		}
		return longestString;
	}

	public static void main(String[] args) {
		String input = "abcddcbaa";
		System.out.println("INput = " + input);
//		String str = getString(input);
//		System.out.println("v1=" + str);
//		String str2 = getStringV2(input);
//		System.out.println("v2=" + str2);
		String str3 = getStringV3(input);
		System.out.println("v3=" + str3);
//		if (str.length() == str2.length()) {
//			System.out.println("Same lenght");
//		} else {
//			System.out.println("Not same length");
//		}

	}

}
