package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.SearchingOnUnsortedArray;

public class SearchingOnUnsortedArrayTest {
	
	/*
	 * Test with given input present in array.
	 */
	@Test
	public void testWithGivenPresentInput() {
		int[] values = new int[] {5,12,11,10,9,8,7,6,4,3,2,123,19};
		assertEquals(true,SearchingOnUnsortedArray.search(values,19));
	}
	
	/*
	 * Test with given input not present in array.
	 */
	@Test
	public void testWithGivenNotPresentInput() {
		int[] values = new int[] {5,12,11,10,9,8,7,6,4,3,2,123,19};
		assertEquals(false,SearchingOnUnsortedArray.search(values,199));
	}
	
}
