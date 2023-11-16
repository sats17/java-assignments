package com.github.sats17.basicassignment;

import java.util.ArrayList;
import java.util.List;

public class StringValidation {
	
	public static boolean valiateString(String[] arr, String input) {
		String tempString = input;
		int i;
		for(i = 0; i < arr.length ; i++) {
			System.out.println(arr[i]);
			tempString = tempString.replaceAll(arr[i], "");
			if(tempString.equals("")) {
				break;
			}
			
		}
		if(tempString.equals("")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[] strings = {"llo","he","om","ll","h"};
		String input = "hheheheh";
		System.out.println(valiateString(strings, input));
//		List<String> test = new ArrayList<>();
//		test.add("Test");
//		test.add("Sats");
//		Object[] abc = test.stream().filter(s -> s.equals("s")).toArray();
//		for(int i = 0; i < abc.length ; i++) {
//			System.out.println("ith index "+abc[i]);
//			
//		}
		
 	}
	
}
