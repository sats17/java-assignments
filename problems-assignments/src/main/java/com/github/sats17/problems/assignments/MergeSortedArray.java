package com.github.sats17.problems.assignments;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int nums1Index = 0;
		int nums2Index = 0;
		int nums1ArrSize = nums1.length - 1;
		int nums2ArrSize = nums2.length - 1;
		while( nums1Index <= nums1ArrSize && nums2Index <= nums2ArrSize) {
			if(nums1[nums1Index] == 0) {
				swap(nums1, nums1Index, nums2, nums2Index);
				nums2Index++;
			} else if(nums1[nums1Index] <= nums2[nums2Index]) {
				nums1Index++;
			} else if (nums1[nums1Index] > nums2[nums2Index]) {
				swap(nums1, nums1Index, nums2, nums2Index);
				nums1Index++;
			}
		}
		
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
		
	}
	
	/**
	 * We know both arrays are sorted, so from ending of array we will compare the values. Also we used two pointers with help of 
	 * value m.
	 * 
	 * https://leetcode.com/problems/merge-sorted-array
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void mergefixed(int[] nums1, int m, int[] nums2, int n) {

		int nums1FirstPointer = m - 1;
		int nums1SecondPointer = nums1.length - 1;
		int nums2Pointer = nums2.length - 1;
		
		while(nums2Pointer >= 0) {
			if(nums1FirstPointer == -1) {
				nums1[nums1SecondPointer] = nums2[nums2Pointer];
				nums1SecondPointer--;
				nums2Pointer--;
			} else if(nums1[nums1FirstPointer] <= nums2[nums2Pointer]) {
				nums1[nums1SecondPointer] = nums2[nums2Pointer];
				nums2Pointer--;
				nums1SecondPointer--;
			} else {
				nums1[nums1SecondPointer] = nums1[nums1FirstPointer];
				nums1[nums1FirstPointer] = 0;
				nums1FirstPointer--;
				nums1SecondPointer--;
			}
		}
		
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
		
	}
	
	public void swap(int[] nums1, int num1Index, int[] nums2, int num2Index) {
		int temp = nums1[num1Index];
		nums1[num1Index] = nums2[num2Index];
		nums2[num2Index] = temp;
	}

	public static void main(String[] args) {
		MergeSortedArray merger = new MergeSortedArray();

		// Sample data
		int[] nums1 = { 4,5,6, 0, 0, 0 }; // Assuming nums1 has enough space to accommodate merged array
		int m = 3;
		int[] nums2 = { 1,2,3};
		int n = 3;

		merger.mergefixed(nums1, m, nums2, n);
	}

}
