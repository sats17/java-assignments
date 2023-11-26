package com.github.sats17.problems.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithoutRepetation {

	public static String getString(String str) {
		int strLen = str.length();
		List<String> strList = new ArrayList<>();
		int lastVisitedIndex = 0;
		Map<Character, Integer> tempMap = new HashMap<>();
		for (int i = 0; i < strLen; i++) {

			if (!tempMap.containsKey(str.charAt(i))) {
				System.out.println("adding i " + str.charAt(i));
				tempMap.put(str.charAt(i), i);
			} else {
				System.out.println(" in else block");
				String newStr = str.substring(lastVisitedIndex, i);
				strList.add(newStr);
				lastVisitedIndex = tempMap.get(str.charAt(i)) + 1;
				i = lastVisitedIndex;
				tempMap = new HashMap<>();
				tempMap.put(str.charAt(i), i);
				
			}
		}
		String newStr = str.substring(lastVisitedIndex, strLen);
		strList.add(newStr);
		System.out.println(strList);
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

	public static void main(String[] args) {
		String str = getString("dvdf");
		System.out.println(str);
	}

}
