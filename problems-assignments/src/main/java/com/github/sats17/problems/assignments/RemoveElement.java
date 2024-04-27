package com.github.sats17.problems.assignments;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
    	int len = 0;
        for (int value : nums) {
        	if(value != 2) {
        		len++;
        	}
        }
        return len;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 2, 4, 5, 2, 2, 4, 5, 10, 2};
    	int val = 2;
    	int ans = removeElement(nums, val);
    	System.out.println(ans);
	}
	
}
