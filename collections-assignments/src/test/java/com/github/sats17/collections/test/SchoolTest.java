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

import com.github.sats17.collections.model.School;
import com.github.sats17.collections.util.TestClassHelper;

public class SchoolTest {

	School School1, School2 , School3,School4,School5;

	
	
	/**
	 * 
	 */
	@Before
	public void setUp() {
		School1 = new School("SPV", "Kamothe", "Raigad", 1);
		School2 = new School("SPV", "Kamothe", "Raigad", 3);
		School3 = new School("Pillai", "Panvel", "Raigad", 5);
		School4 = new School("Bootcamp", "PUBG", "Sanhok", 2);
		School5 = new School("Pochinki", "PUBG", "Erangel", 9);
				
	}

	/**
	 * 
	 */
	@Test
	public void testTwoObjectEquals() {
		assertTrue(School1.equals(School2));
	}
	
	@Test
	public void testTwoObjectHashCodeAreEqual() {
		assertEquals(School1.hashCode(), School2.hashCode());
	}
	
	@Test
	public void testDuplicateSchoolObjectAddedInSetOrNot() {
		Set<School> data = new HashSet<School>();
		data.add(School1);
		data.add(School2);
		data.add(School3);
		assertEquals(2, data.size());
	}
	
	@Test
	public void testDuplicateSchoolObjectAddedInListOrNot() {
		List<School> data = new ArrayList<School>();
		data.add(School1);
		data.add(School2);
		data.add(School3);
		assertEquals(3, data.size());
	}
	
	@Test
	public void testInsertionOrderOfObjectInList() {
		assertTrue(TestClassHelper.checkList(School1, School3, School4, School5));
	}
	
	@Test
	public void testInsertionOrderOfObjectInSet() {
		assertFalse(TestClassHelper.checkSet(School1,School3,School4,School5));
	}
	
	@After
	public void clear() {
		School1 = null;
		School2 = null;
		School3 = null;
		School4 = null;
		School5 = null;
	}
	
}
