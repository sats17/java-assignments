package com.github.sats17.problems.assignments;

import java.util.Arrays;

public class RotateArray {

	public void simpleRotate(int[] arr, int rotateSteps) {
		int arrSize = arr.length;
		System.out.println(arrSize);
		int rotateStartIndex = arrSize - rotateSteps;
		System.out.println(rotateStartIndex);
		int i = 0;
		int rotateStartIndexLoop = rotateStartIndex;
		int[] myIntArray = new int[arrSize];
		while(i < rotateSteps) {
			myIntArray[i] = arr[rotateStartIndexLoop];
			i++;
			rotateStartIndexLoop++;
		}
		System.out.println("Rotate index loop "+rotateStartIndexLoop);
		int j = 0;
		while (j < rotateStartIndex) {
			System.out.println(arr[j]);
			myIntArray[i] = arr[j];
			i++;
			j++;
		}
		for(int k= 0; k < myIntArray.length; k++) {
			System.out.println("Rotate value "+ myIntArray[k]);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] {2, 3, 4,5,6,7,8,9};
		RotateArray ra = new RotateArray();
		ra.simpleRotate(arr, 7);
	}

}
