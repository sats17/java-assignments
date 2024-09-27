package com.github.sats17.problems.assignments.strivers;

public class SearchInSortedArray {

	public static boolean findIn2DArrayWithFormula(int[][] arr, int k) {
		int arrLen = arr.length;

		
		int left = 0;
		int right = (arr.length * arr[0].length) - 1;
		
		while(left <= right) {
			
			int mid = left + (right - left) / 2;
			int midValue = arr[mid / arr[0].length][mid % arr[0].length];
			if (midValue == k) {
				return true;
			} else if (midValue < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			
		}
		
		return false;
	}

	
	public static boolean findIn2DArrayWithBinarySearch(int[][] arr, int k) {
		int arrLen = arr.length;
		// Iterate each row
		for(int i = 0; i < arrLen; i++) {
			int left = 0;
			int right = arr[i].length - 1;
			// Find out if value present in row by checking first and last element. Since array is sorted
			// We can do this.
			if(arr[i][left] <= k && arr[i][right] >= k) {

				// If value is present perform binary search on that row.
				while(left <= right) {
					int mid = left + (right - left) / 2;
					
					if (arr[i][mid] == k) {
						System.out.println("Item found at index "+i+","+mid);
						return true;
					} else if(arr[i][mid]  > k) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				}
			}
			

		}
		
		
		return false;
	}

	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9, 10, 11, 12 } };

		// Printing the 2D array
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------");
		boolean ans = findIn2DArrayWithBinarySearch(matrix, 2);
		System.out.println(ans);
	}

}
