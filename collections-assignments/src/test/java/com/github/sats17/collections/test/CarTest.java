package com.github.sats17.collections.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.collections.model.Car;
import com.github.sats17.collections.util.TestClassHelper;

public class CarTest {

	Car car1, car2, car3, car4, car5;

	
	/**
	 * 
	 */
	@Before
	public void setUp() {
		car1 = new Car("toyota", "4L3", 1998, 30000);
		car2 = new Car("toyota", "4L3", 1989, 40000);
		car3 = new Car("Scorpio", "SE091", 2004, 90000);
		car4 = new Car("INDIGO", "W234091", 2004, 90000);
		car5 = new Car("sumo", "SE09aS1", 2004, 90000);
	}

	/**
	 * Test method for check two objects are equal or not
	 * according to given condition.
	 */
	@Test
	public void testTwoObjectEquals() {
		assertTrue(car1.equals(car2));
	}
	
	
	
	/**
	 * Test method for check hashcode of two objects are equal
	 * or not according to their calculation.
	 */
	@Test
	public void testTwoObjectHashCodeAreEqual() {
		assertEquals(car1.hashCode(), car2.hashCode());
	}
	
	/**
	 * Test method for check is set adding duplicate
	 * object or not.
	 */
	@Test
	public void testDuplicateCarObjectAddedInSetOrNot() {
		Set<Car> data = new HashSet<Car>();
		data.add(car1);
		data.add(car2);
		data.add(car3);
		assertEquals(2, data.size());
	}
	
	/**
	 * Test method for check is list adding duplicate
	 * object or not.
	 */
	@Test
	public void testDuplicateCarObjectAddedInListOrNot() {
		List<Car> data = new ArrayList<Car>();
		data.add(car1);
		data.add(car2);
		data.add(car3);
		assertEquals(3, data.size());
	}
	
	@Test
	public void testInsertionOrderOfObjectInList() {
		assertTrue(TestClassHelper.checkList(car1, car2, car3, car4));
	}
	
	@Test
	public void testInsertionOrderOfObjectInSet() {
	
		assertFalse(TestClassHelper.checkSet(car1,car3,car4,car5));
	}
	
	@Test
	public void testSortingOrderOfCarByMakeCriteria() {
		Set<Car> tree= new TreeSet<Car>();
		tree.add(car1);
		tree.add(car2);
		tree.add(car3);
		tree.add(car4);
		tree.add(car5);
		String[] sortedNames = {"INDIGO","Scorpio","sumo","toyota"};
		Iterator it = tree.iterator();
		int i = 0;
		while(it.hasNext()) {
			Car s = (Car) it.next();
			String name = s.getMake();
			assertEquals(sortedNames[i], name);
			i++;
		}
	}
	
	@After
	public void clear() {
		car1 = null;
		car2 = null;
		car3 = null;
		car4 = null;
		car5 = null;
	}

}
