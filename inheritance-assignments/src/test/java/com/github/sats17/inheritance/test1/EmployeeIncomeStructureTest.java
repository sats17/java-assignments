package com.github.sats17.inheritance.test1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.inheritance.part1.Employee;

/**
 * @author sats17
 *
 */
public class EmployeeIncomeStructureTest {
	
	Employee emp;
	
	/**
	 * SetUp method for object creation.
	 */
	@Before
	public void setUp() {
		emp = new Employee("sats", 10000);
		emp.grossSalCalculator();
		emp.netSalCalculator();
	}
	
	/**
	 * Test method for test employee display method.
	 */
	@Test
	public void testEmployeeData() {
		String expected = "Employee ID :-1"+"\n"+ 
				"Employee Name :-sats"+"\n"+ 
				"Employee Basic Salary :-10000.0"+"\n"+ 
				"Employee Medical :-500.0"+"\n"+ 
				"Employee PF :-1200.0"+"\n"+ 
				"Employee PT :-200.0"+"\n"+ 
				"Employee Gross Salary :-15500.0"+"\n"+ 
				"Employee Net Salary :-14100.0"
				;
		assertEquals(expected, emp.displayEmpDetails());
	}
	
	@Test
	public void testCalculateGrossSalMethod() {
		
		assertEquals(15500.0, emp.getGrossSal(),0.02);
		
	}

}
