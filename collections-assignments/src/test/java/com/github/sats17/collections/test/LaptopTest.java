package com.github.sats17.collections.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.collections.model.Laptop;
import com.github.sats17.collections.util.TestClassHelper;

public class LaptopTest {

	Laptop Laptop1, Laptop2 , Laptop3,Laptop4,Laptop5;

	
	
	/**
	 * 
	 */
	@Before
	public void setUp() {
		Laptop1 = new Laptop("Lenovo", "L480", "Win10", "I5");
		Laptop2 = new Laptop("Lenovo", "L480", "Win8", "I7");
		Laptop3 = new Laptop("Asus", "A480", "Ubuntu", "16A");
		Laptop4 = new Laptop("Accer", "ABS", "CentOs", "asfasf");
		Laptop5 = new Laptop("Lioafs", "&Saf", "Cunasf", "asfasf");
				
	}

	/**
	 * 
	 */
	@Test
	public void testTwoObjectEquals() {
		assertTrue(Laptop1.equals(Laptop2));
	}
	
	@Test
	public void testTwoObjectHashCodeAreEqual() {
		assertEquals(Laptop1.hashCode(), Laptop2.hashCode());
	}
	
	@Test
	public void testDuplicateLaptopObjectAddedInSetOrNot() {
		Set<Laptop> data = new HashSet<Laptop>();
		data.add(Laptop1);
		data.add(Laptop2);
		data.add(Laptop3);
		assertEquals(2, data.size());
	}
	
	@Test
	public void testDuplicateLaptopObjectAddedInListOrNot() {
		List<Laptop> data = new ArrayList<Laptop>();
		data.add(Laptop1);
		data.add(Laptop2);
		data.add(Laptop3);
		assertEquals(3, data.size());
	}
	
	@Test
	public void testInsertionOrderOfObjectInList() {
		assertTrue(TestClassHelper.checkList(Laptop1, Laptop3, Laptop4, Laptop5));
	}
	
	@Test
	public void testInsertionOrderOfObjectInSet() {
		assertFalse(TestClassHelper.checkSet(Laptop1,Laptop3,Laptop4,Laptop5));
	}
	
	@After
	public void clear() {
		Laptop1 = null;
		Laptop2 = null;
		Laptop3 = null;
		Laptop4 = null;
		Laptop5 = null;
	}
	
}
