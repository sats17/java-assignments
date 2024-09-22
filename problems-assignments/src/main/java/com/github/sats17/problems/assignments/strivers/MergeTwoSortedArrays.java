package com.github.sats17.problems.assignments.strivers;

//https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
public class MergeTwoSortedArrays {

	public static void sort(int[] a, int[] b) {

		int aPointer = a.length - 1;
		int bPointer = b.length - 1;

		while (aPointer > 0 && bPointer >= 0) {
			if (a[aPointer] > b[bPointer]) {
				int aTempValue = a[aPointer];
				int bTempValue = b[bPointer];
				int aTempPointer = aPointer; 
				// Shift elements to left till bPointer value is less than aPointer.
				while ((aTempPointer - 1) >= 0 && a[aTempPointer - 1] >= b[bPointer]) {
					a[aTempPointer] = a[aTempPointer - 1];
					aTempPointer--;
				}
				a[aTempPointer] = bTempValue;
				b[bPointer] = aTempValue;
				bPointer--;
			} else {
				bPointer--;
			}
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("=============================");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

	}

	public static void main(String[] args) {
		int[] arr1 = { 10, 11, 12 };
		int[] arr2 = { 2, 3, 9 };
		arr1[4] = 10;
//		sort(arr1, arr2);
	}

}
