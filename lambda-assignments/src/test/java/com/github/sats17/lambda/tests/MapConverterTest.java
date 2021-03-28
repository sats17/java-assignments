package com.github.sats17.lambda.tests;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.lambda.main.MapConverter;

public class MapConverterTest {

	HashMap<String,String> st;
	
	@Before
	public void setUp() {
		st = new HashMap<String, String>();
		st.put("sats", "kum");
		st.put("pra", "gol");
	}
	
	@Test
	public void testWithValidInput() {
		
		String s = "satskum";
		MapConverter.convert(st);
		
	}

}
