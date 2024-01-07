package com.github.sats17.problems.assignments;

public class RotateArray {

	public int[] reverse(int[] arr, int startIndex, int endIndex) {
		if (endIndex - startIndex == 1) {
			int startIndexVal = arr[startIndex];
			arr[startIndex] = arr[endIndex];
			arr[endIndex] = startIndexVal;
		} else {
			int median = (startIndex + endIndex) / 2;
			while (startIndex <= median) {
				int startIndexVal = arr[startIndex];
				arr[startIndex] = arr[endIndex];
				arr[endIndex] = startIndexVal;
				startIndex++;
				endIndex--;
			}
		}
		for (int k = 0; k < arr.length; k++) {
			System.out.println("Reverse value " + arr[k]);
		}
		System.out.println("=================");
		return arr;
	}

	/**
	 * Time complexity = O(n), where n is size of array. Space complexity = O(n * 2)
	 * where n is size of array
	 * 
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
	
	public void optimizedRotate(int[] arr, int rotateSteps) {

		int arrSize = arr.length - 1;
		int medianIndex = (arrSize - rotateSteps);
		int[] reversedArr = reverse(arr, 0, medianIndex );
		int[] reverseArr2 = reverse(reversedArr, medianIndex + 1, arrSize);
		int[] finalRotatedArr = reverse(reverseArr2, 0, arrSize);
		// Print new array
		for (int k = 0; k < finalRotatedArr.length; k++) {
			System.out.println("Rotate value " + finalRotatedArr[k]);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };
		RotateArray ra = new RotateArray();
//		ra.simpleRotate(arr, 7);
		ra.optimizedRotate(arr, 4);
//		ra.reverse(arr, 4, 7);
	}

}
