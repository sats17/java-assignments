package com.github.sats17.problems.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.sats17.problems.assignments.FindMatchingStringOccurences;
import com.github.sats17.problems.exceptions.WrongInputException;

public class FindMatchingStringOccurencesTest {

	/*
	 * Test with all correct inputs and outputs.
	 */
	@Test
	public void testMatchingStringWithGivenArray() throws WrongInputException {
		String values[] = new String[] { "Dave", "Ann", "George", "Sam", "Ted", "Gag", "Saj", "Agati", "Mary", "Sam",
				"Ayan", "Dev", "Kity", "Meery", "Smith", "Johnson", "Bill", "Williams", "Jones", "Brown", "Davis",
				"Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson" };

		assertEquals(2, FindMatchingStringOccurences.getOccurences(values, "Sam"));

	}

	/*
	 * Test for given string is not matching in array.
	 */
	@Test
	public void testStringNotMatchingWithGivenArray() throws WrongInputException {
		String values[] = new String[] { "Dave", "Ann", "George", "Sam", "Ted", "Gag", "Saj", "Agati", "Mary", "Sam",
				"Ayan", "Dev", "Kity", "Meery", "Smith", "Johnson", "Bill", "Williams", "Jones", "Brown", "Davis",
				"Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson" };

		assertEquals(0, FindMatchingStringOccurences.getOccurences(values, "Sats17"));

	}

	/*
	 * Test for given empty array.
	 */
	@Test(expected = WrongInputException.class)
	public void testMatchingStringWithEmptyArray() throws WrongInputException {
		String values[] = new String[] {};

		FindMatchingStringOccurences.getOccurences(values, "Sats17");

	}

	/*
	 * Test for given empty string.
	 */
	@Test(expected = WrongInputException.class)
	public void testMatchingStringWithEmptyString() throws WrongInputException {
		String values[] = new String[] { "Sam", "Ayan", "Dev", "Kity", "Meery", "Smith", "Johnson", "Bill", "Williams",
				"Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson" };

		FindMatchingStringOccurences.getOccurences(values, "");

	}

}
