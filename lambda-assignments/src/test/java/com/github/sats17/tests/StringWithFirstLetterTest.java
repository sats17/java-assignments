package com.github.sats17.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.main.OddLenghtRemoval;
import com.github.sats17.main.StringWithFirstLetter;

public class StringWithFirstLetterTest {

	ArrayList<String> data;

	@Before
	public void setUp() {
		data = new ArrayList<String>();
		data.add("Satish");
		data.add("Odd");
		data.add("even");
		data.add("perfect");
	}

	@Test
	public void testWithValidInput() {
		String s = "SOep";
		assertTrue(s.equals(StringWithFirstLetter.stringFilter(data).toString()));
	}

}
