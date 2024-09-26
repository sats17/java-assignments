package com.github.sats17.problems.assignments.strivers;

public class FindSquareRoot {
	
	public static double find(int value) {
		double low = 0;
		double high = value;
		double ans = 0;
		
		while(low <= high) {
			double mid =(double) (low + high) / 2;
			double midSquare = mid * mid;
			if(midSquare == value) {
				return mid;
			} else if(midSquare < value) {
				low = mid + 1;
				ans = mid;
			} else {
				high = mid - 1;
			}
		}
		
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(find(81));
	}

}
