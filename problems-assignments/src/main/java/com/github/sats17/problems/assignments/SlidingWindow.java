package com.github.sats17.problems.assignments;

public class SlidingWindow {

    public static int predictStockProfit(int[] nums) {
    	int maxProfit = 0;
    	int estimatedBuy = nums[0];
        for (int i = 0; i < nums.length; i++) {
        	if(nums[i] < estimatedBuy) {
        		estimatedBuy = nums[i];
        	} else {
        		int currentProfit = nums[i] - estimatedBuy;
        		if(maxProfit < currentProfit) {
        			maxProfit = currentProfit;
        		}
        	}
        	
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 2};
    	int ans = predictStockProfit(nums);
    	System.out.println(ans);
	}
	
}
