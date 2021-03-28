package com.github.sats17.problems.assignments;

public class SearchingOnUnsortedArray {

	public static boolean search(int[] arr,int num) {
		
		for(int i = 0 ; i < arr.length;i++) {
			if(num == arr[i]) {
				return true;
			}
		}
		return false;
	}
	
}
