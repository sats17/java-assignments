package com.github.sats17.collections.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.collections.model.CellPhone;
import com.github.sats17.collections.util.TestClassHelper;

public class CellPhoneTest {
	
	CellPhone CellPhone1, CellPhone2 , CellPhone3,CellPhone4,CellPhone5;

	
	
	/**
	 * 
	 */
	@Before
	public void setUp() {
		CellPhone1 = new CellPhone("OnePlus", "5T", "Fastest Phone", "Android", 33000);
		CellPhone2 = new CellPhone("OnePlus", "5T", "Fastest Phone", "Android", 33000);
		CellPhone3 = new CellPhone("Nokia", "Lumia", "Design", "Windows", 35000);
		CellPhone4 = new CellPhone("Paaas", "Lumia", "Design", "aqwr", 35000);
		CellPhone5 = new CellPhone("asfa", "aasfasf", "afsafsa", "asfasf", 35000);
				
	}

	/**
	 * 
	 */
	@Test
	public void testTwoObjectEquals() {
		assertTrue(CellPhone1.equals(CellPhone2));
	}
	
	@Test
	public void testTwoObjectHashCodeAreEqual() {
		assertEquals(CellPhone1.hashCode(), CellPhone2.hashCode());
	}
	
	@Test
	public void testDuplicateCellPhoneObjectAddedInSetOrNot() {
		Set<CellPhone> data = new HashSet<CellPhone>();
		data.add(CellPhone1);
		data.add(CellPhone2);
		data.add(CellPhone3);
		assertEquals(2, data.size());
	}
	
	@Test
	public void testDuplicateCellPhoneObjectAddedInListOrNot() {
		List<CellPhone> data = new ArrayList<CellPhone>();
		data.add(CellPhone1);
		data.add(CellPhone2);
		data.add(CellPhone3);
		assertEquals(3, data.size());
	}
	
	@Test
	public void testInsertionOrderOfObjectInList() {
		assertTrue(TestClassHelper.checkList(CellPhone1, CellPhone3, CellPhone4, CellPhone5));
	}
	
	@Test
	public void testInsertionOrderOfObjectInSet() {
		assertFalse(TestClassHelper.checkSet(CellPhone1,CellPhone3,CellPhone4,CellPhone5));
	}
	
	@After
	public void clear() {
		CellPhone1 = null;
		CellPhone2 = null;
		CellPhone3 = null;
		CellPhone4 = null;
		CellPhone5 = null;
	}

}
