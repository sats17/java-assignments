package com.github.sats17.problems.assignments;

import java.util.Arrays;

public class RotateArray {

	/**
	 * Time complexity = O(n), where n is size of array.
	 * Space complexity = O(n * 2) where n is size of array
	 * @param arr
	 * @param rotateSteps
	 */
	public void simpleRotate(int[] arr, int rotateSteps) {
		
		int arrSize = arr.length;
		int rotateStartIndex = arrSize - rotateSteps;
		int newArrIndex = 0;
		int rotateStartIndexLoop = rotateStartIndex;
		int[] myIntArray = new int[arrSize];
		// Start filling values to array those we want to rotate
		while (newArrIndex < rotateSteps) {
			myIntArray[newArrIndex] = arr[rotateStartIndexLoop];
			newArrIndex++;
			rotateStartIndexLoop++;
		}
		
		// Fill remaining values to array. Remaining values are the start one.
		int oldArrStartIndex = 0;
		while (oldArrStartIndex < rotateStartIndex) {
			System.out.println(arr[oldArrStartIndex]);
			myIntArray[newArrIndex] = arr[oldArrStartIndex];
			newArrIndex++;
			oldArrStartIndex++;
		}
		
		// Print new array
		for (int k = 0; k < myIntArray.length; k++) {
			System.out.println("Rotate value " + myIntArray[k]);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };
		RotateArray ra = new RotateArray();
		ra.simpleRotate(arr, 7);
	}

}
