package com.github.sats17.problems.util;

import java.util.ArrayList;

public class convertArrayListToSimpleArray {
	
	public static int[] convert(ArrayList<Integer> arrayList) {

		int resultArray[] = new int[arrayList.size()];
		int counter = 0;
		for (Object o : arrayList) {
			int i = (int) o;
			resultArray[counter] = i;
			counter++;
		}
		return resultArray;

	}
}
