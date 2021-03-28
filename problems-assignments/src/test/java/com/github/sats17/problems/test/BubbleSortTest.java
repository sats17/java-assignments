package com.github.sats17.problems.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.BubbleSortImpl;

public class BubbleSortTest {
	
	@Test
	public void testSortingWithValidInput() {
		int[] values = new int[] {5,1,2,4,7,6,9};
		int[] expected = new int[] {1,2,4,5,6,7,9};
		assertArrayEquals(expected, BubbleSortImpl.sort(values));
	}
	
}
