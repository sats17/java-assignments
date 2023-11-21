package com.github.sats17.problems.assignments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array nums that consists of non-negative integers. Let us
 * define rev(x) as the reverse of the non-negative integer x. For example,
 * rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it
 * satisfies all of the following conditions:
 * 
 * 0 <= i < j < nums.length.
 * 
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 
 * OR
 * 
 * nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
 * 
 * Return the number of nice pairs of indices. Since that number can be too
 * large, return it modulo 109 + 7.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [42,11,1,97] Output: 2 Explanation: The two pairs are: - (0,3)
 * : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121. - (1,2) : 11 +
 * rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12. Example 2:
 * 
 * Input: nums = [13,10,35,24,76] Output: 4
 * 
 * @author Sats17
 *
 */
public class NicePairs {

	public static int countNicePairsBruteforce(int[] nums) {
		int total = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[i] + reverseInt(nums[j]) == reverseInt(nums[i]) + nums[j]) {
					System.out.println(nums[i] - reverseInt(nums[i]));
					System.out.println("Nice numbers = "+i+", "+j);
					total = total + 1;
				}
			}
		}
		return total;
	}
	
	public static int countNicePairsWithFormula(int[] nums) {
		int total = 0;
		Map<Integer, Integer> ans = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i] - reverseInt(nums[i]));
			System.out.println(nums[i]);
			int key = nums[i] - reverseInt(nums[i]);
			ans.put(key, ans.getOrDefault(key, 0) + 1);
		}
		System.out.println(ans);
		for (Integer value : ans.values()) {
			System.out.println(value);
		    if(value > 1) total = total + value;
		}
		return total;
	}
	
	public static int reverseInt(int val) {
		int ans = 0;
		while (val > 0) {
			ans = ans *10 + val % 10;
			val = val / 10;
		}
		return ans;
	}

	// Fix below question, where 9 is coming as 2 times, instead of 1
	public static void main(String[] args) {
		int[] arr = {13,10,35,24,76};
		System.out.println(countNicePairsBruteforce(arr));
		System.out.println("-----------------------------");
		System.out.println(countNicePairsWithFormula(arr));
	}

}
