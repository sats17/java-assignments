package com.github.sats17.main;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapConverter {

	public static StringBuilder convert(HashMap<String,String> map) {
		StringBuilder result = new StringBuilder();
		Set<Entry<String, String>> s = map.entrySet();
		s.forEach(str -> {
			System.out.println(str);
			result.append(str);
		});
		System.out.println(result);
		return result;
		
	}
	
}
