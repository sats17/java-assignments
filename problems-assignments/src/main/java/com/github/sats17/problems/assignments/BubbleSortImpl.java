package com.github.sats17.problems.assignments;

public class BubbleSortImpl {
	

	
	public static int[] sort(int[] values) {
		
		int counter = 0;
		while(counter < values.length - 1) {
			if(values[counter] > values[counter + 1]) {
				values[counter] = values[counter] + values[counter + 1]; 
				values[counter + 1] = values[counter] - values[counter + 1]; 
				values[counter] = values[counter] - values[counter + 1]; 
			}
			counter++;
		}
		return values;
		
		
	}

}
 