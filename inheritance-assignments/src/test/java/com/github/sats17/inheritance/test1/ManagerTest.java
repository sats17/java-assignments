package com.github.sats17.inheritance.test1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.inheritance.part1.Employee;
import com.github.sats17.inheritance.part1.Manager;
import com.github.sats17.inheritance.part1.MarketingExecutive;

/**
 * @author satikumb
 *
 */
public class ManagerTest {
	
	Employee manager;
	
	@Before
	public void setUp() {
		manager = new Manager("sats19", 10000);
	}
	
	/**
	 * Test method for gross salary calculator
	 */
	@Test
	public void testGrossSalaryCalculation() {
		assertEquals(17900.0, manager.grossSalCalculator(),0.02);
	}
	
	/**
	 * Test method for net salary calculator
	 */
	@Test
	public void testNetSalaryCalculation() {
		
		assertEquals(16500.0, manager.netSalCalculator(),0.02);
	}
	
	@After
	public void clear() {
		manager = null;
	}
	
}
