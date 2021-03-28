package com.github.sats17.problems.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.FindArmStrongNumberInRangeImpl;

public class FindArmStrongNumberInRangeTest {
	/*
	 * Test method with given input.
	 */
	@Test
	public void testWithValidInput() {
		int[] result = new int[] {153, 370, 371, 407};
		assertArrayEquals(result, FindArmStrongNumberInRangeImpl.find(100,999));
	}
}
