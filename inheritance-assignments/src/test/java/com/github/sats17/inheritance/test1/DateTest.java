package com.github.sats17.inheritance.test1;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.inheritance.part1.DateImpl;
import com.github.sats17.inheritance.util.DateParser;

public class DateTest {
	DateImpl date;
	Date parsedDate;
	
	@Before
	public void setUp() {
		Date parsedDate = DateParser.parseDate("2015-09-08");
		date = new DateImpl();
	}
	
	/*
	 * Test Case for default constructor.
	 */
	@Test
	public void testGetDate() {
		date.setDate(parsedDate);
		assertEquals(parsedDate, date.getDate());
		destroyObject();
	}
	
	
	/*
	 * Test case for parameter constructor.
	 */
	@Test
	public void testConstructor() {
		
		DateImpl newObj = new DateImpl(parsedDate);
		assertEquals(parsedDate, newObj.getDate());
		newObj = null;
	}
	
	@After
	public void destroyObject(){
		date = null;
		parsedDate = null;
	}

}
