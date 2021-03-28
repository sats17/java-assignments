package com.github.sats17.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.github.sats17.main.DirectoryReturn;

public class DirectoryReturnTest {

	@Test
	public void testWithValidInput() throws IOException {
		System.out.println(DirectoryReturn.getSubDirectory("."));
	}

}
