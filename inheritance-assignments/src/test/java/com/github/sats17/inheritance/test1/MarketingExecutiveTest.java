package com.github.sats17.inheritance.test1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.inheritance.part1.Employee;
import com.github.sats17.inheritance.part1.MarketingExecutive;

public class MarketingExecutiveTest {
	
	Employee MarketingExecutive;
	
	@Before
	public void setUp() {
		MarketingExecutive = new MarketingExecutive("sats19", 10000, 10);
	}
	
	
	
	/**
	 * Test method for gross salary calculator
	 */
	@Test
	public void testGrossSalaryCalculation() {
		assertEquals(17050.0, MarketingExecutive.grossSalCalculator(),0.02);
	}
	
	/**
	 * Test method for net salary calculator
	 */
	@Test
	public void testNetSalaryCalculation() {
		assertEquals(15650.0, MarketingExecutive.netSalCalculator(),0.02);
	}
	
	@After
	public void clear() {
		MarketingExecutive = null;
	}

}
