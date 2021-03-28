package com.github.sats17.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.main.OddLenghtRemoval;

public class OddLengthRemovalTest {

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
		String[] expected = {"Satish","even"};
		assertArrayEquals(expected, OddLenghtRemoval.remove(data).toArray());
	}

}
