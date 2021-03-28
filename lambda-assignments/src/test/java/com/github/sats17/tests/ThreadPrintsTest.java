package com.github.sats17.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.main.ThreadPrints;

public class ThreadPrintsTest {

	ArrayList<Integer> data;

	@Before
	public void setUp() {
		data = new ArrayList<Integer>();
		data.add(56);
		data.add(2);
		data.add(62);
		data.add(7456);
	}
	
	@Test
	public void testMethodWithValidInput() throws InterruptedException {
		Object[] expected = {56,2,62,7456};
		assertArrayEquals(expected, ThreadPrints.print(data));
	}

}
