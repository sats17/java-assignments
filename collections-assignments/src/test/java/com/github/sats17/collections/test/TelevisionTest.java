package com.github.sats17.collections.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;	
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.collections.model.Car;
import com.github.sats17.collections.model.Television;
import com.github.sats17.collections.util.TelevisionType;
import com.github.sats17.collections.util.TestClassHelper;

public class TelevisionTest {

	Television Television1, Television2 , Television3,Television4,Television5;

	
	
	/**
	 * 
	 */
	@Before
	public void setUp() {
		Television1 = new Television("Onida", TelevisionType.LCD, true, 50000);
		Television2 = new Television("Onida", TelevisionType.LCD, false, 50000);
		Television3 = new Television("Samsung", TelevisionType.LED, false, 55000);
		Television4 = new Television("asjansf", TelevisionType.PLASMA, true, 234243);
		Television5 = new Television("aasfa", TelevisionType.LCD, false, 50000);
				
	}

	/**
	 * 
	 */
	@Test
	public void testTwoObjectEquals() {
		assertTrue(Television1.equals(Television2));
	}
	
	@Test
	public void testTwoObjectHashCodeAreEqual() {
		assertEquals(Television1.hashCode(), Television2.hashCode());
	}
	
	@Test
	public void testDuplicateTelevisionObjectAddedInSetOrNot() {
		Set<Television> data = new HashSet<Television>();
		data.add(Television1);
		data.add(Television2);
		data.add(Television3);
		assertEquals(2, data.size());
	}
	
	@Test
	public void testDuplicateTelevisionObjectAddedInListOrNot() {
		List<Television> data = new ArrayList<Television>();
		data.add(Television1);
		data.add(Television2);
		data.add(Television3);
		assertEquals(3, data.size());
	}
	
	@Test
	public void testInsertionOrderOfObjectInList() {
		assertTrue(TestClassHelper.checkList(Television1, Television3, Television4, Television5));
	}
	
	@Test
	public void testInsertionOrderOfObjectInSet() {
		assertFalse(TestClassHelper.checkSet(Television1,Television3,Television4,Television5));
	}
	

	
	@After
	public void clear() {
		Television1 = null;
		Television2 = null;
		Television3 = null;
		Television4 = null;
		Television5 = null;
	}
	
}
