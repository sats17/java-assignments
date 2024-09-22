package com.github.sats17.problems.assignments.strivers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
public class MajorityElementsInArray {

	public static int findMajorityElementFromArray(int n, int[] arr) {
		
		int limit = n / 2;
		
		Map<Integer, Integer> tempData = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			tempData.compute(arr[i], (k,v) -> v == null ? 1 : v + 1);
		}
		
		Iterator<Entry<Integer, Integer>> iterator = tempData.entrySet().iterator();
		
		int ans = -1;
		
		while(iterator.hasNext()) {
			Entry<Integer, Integer> next = iterator.next();
			
			if(next.getValue() > limit) {
				ans = next.getKey();
			}
		}

		
		
		return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 4, 4, 4};
		int ans = findMajorityElementFromArray(3, arr);
		System.out.println(ans);
	}
	
}
