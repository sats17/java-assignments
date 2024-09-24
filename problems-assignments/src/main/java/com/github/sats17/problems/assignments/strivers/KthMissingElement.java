package com.github.sats17.problems.assignments.strivers;

// https://takeuforward.org/arrays/kth-missing-positive-number/
public class KthMissingElement {
	
	public static int find(int[] arr, int k) {
		
		int arrLen = arr.length;
		int low = 0;
		int high = arrLen - 1;
		
		while(low <= high ) { // This condition I have to figure out
			int mid = (low + high) / 2;
			System.out.println("Miod "+mid);
			int calculatedValue = calculateHowManyMissingBefore(arr[mid], mid);
			if(k <= calculatedValue) {
				// travel left
				high = mid - 1;
				System.out.println("if");
				
			} else {
				// travel right
				low = mid + 1;
				System.out.println("else if");
			} 
			
		}
		System.out.println(low);
		System.out.println(high);
		return low + k; // This is mathematical formula or trick for this question.
	}
	
	public static int calculateHowManyMissingBefore(int value, int index) {
		return value - (index + 1);
	}
	
	
	public static void main(String[] args) {
		int[] arr = {4, 7, 8, 10}; // {3, 5, 5, 5}
		int k = 6;
		System.out.println(find(arr, k));
		
	}

}
