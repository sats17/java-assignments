package com.github.sats17.problems.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.MarksAverageImpl;

public class MarksAvgTest {
	
	/*
	 * Test case for avergae of all subjects.
	 */
	@Test
	public void testAllSubjectMarksWithValidInput() {
		
		int[] expected = new int[]{2,2,2};
		int[][] values = new int[][] {{2,2,2},{2,2,2},{2,2,2}};
		assertArrayEquals(expected, MarksAverageImpl.findTotalAvgOfEachSubject(values));
	}
	
	/*
	 * Test case for avergae of each subject of student.
	 */
	@Test
	public void testAllEachSubjectMarksOfEachStudentWithValidInput() {
		
		int[] expected = new int[]{4,5,3};
		int[][] values = new int[][] {{4,5,5},{2,6,2},{6,4,2}};
		assertArrayEquals(expected, MarksAverageImpl.findTotalAvgOfEachSubject(values));
	}
}
