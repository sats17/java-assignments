package com.github.sats17.lambda.main;

import java.util.ArrayList;

public class OddLenghtRemoval {

	public static ArrayList<String> remove(ArrayList<String> mylist) {
		mylist.removeIf(i -> i.length() % 2 != 0);
		return mylist;
	};
	
}
