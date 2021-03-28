package com.github.sats17.main;

import java.util.ArrayList;

public class StringWithFirstLetter {
	
	public static StringBuilder stringFilter(ArrayList<String> strings) {
		StringBuilder myString = new StringBuilder();
		strings.forEach(string -> myString.append(string.charAt(0)));
		return myString;
	}
	
}
