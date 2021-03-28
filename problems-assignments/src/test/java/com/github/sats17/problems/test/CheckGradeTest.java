package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.CheckGradeImpl;
import com.github.sats17.problems.exceptions.WrongInputException;
import com.github.sats17.problems.util.Grade;

public class CheckGradeTest {
	
	@Test
	public void testGradeForPassed() throws WrongInputException {
		int[] marks = new int[] {61,82,87};
		assertEquals(Grade.Passed.ordinal(), CheckGradeImpl.check(marks));
	}
	
	@Test
	public void testGradeForPromoted() throws WrongInputException {
		int[] marks = new int[] {59,82,87};
		assertEquals(Grade.Promoted.ordinal(), CheckGradeImpl.check(marks));
	}
	
	@Test
	public void testGradeForFailed() throws WrongInputException {
		int[] marks = new int[] {61,59,23};
		assertEquals(Grade.Failed.ordinal(), CheckGradeImpl.check(marks));
	}
	
	@Test(expected = WrongInputException.class)
	public void testGradeForWrongInputMarks() throws WrongInputException {
		int[] marks = new int[] {-24,59,102};
		CheckGradeImpl.check(marks);
	}
	
}
