package com.github.sats17.problems.assignments;

public class SlidingWindow {

    public static int predictStockProfit(int[] prices) {
        int maxProfit = 0;
    	int estimatedBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
        	if(prices[i] < estimatedBuy) {
        		estimatedBuy = prices[i];
        	} else if(prices[i] - estimatedBuy > maxProfit ) {
        			maxProfit = prices[i] - estimatedBuy;
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
