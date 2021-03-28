package com.github.sats17.collections.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.sats17.collections.model.Student;
import com.github.sats17.collections.util.TestClassHelper;

/**
 * @author sats17
 *
 */
public class StudentTest {


	Student Student1, Student2 , Student3,Student4,Student5;

	
	
	/**
	 * Sets all objects.
	 */
	@Before
	public void setUp() {
		Student1 = new Student("Sats","Mango");
		Student2 = new Student("Sats","Apple");
		Student3 = new Student("Pillai","Pineapple");
		Student4 = new Student("Bootcamp","Banana");
		Student5 = new Student("Pochinki","Strawberry");
				
	}

	/**
	 * Checks that two object are equal or not.
	 */
	@Test
	public void testTwoObjectEquals() {
		assertTrue(Student1.equals(Student2));
	}
	
	@Test
	public void testTwoObjectHashCodeAreEqual() {
		assertEquals(Student1.hashCode(), Student2.hashCode());
	}
	
	@Test
	public void testDuplicateStudentObjectAddedInSetOrNot() {
		Set<Student> data = new HashSet<Student>();
		data.add(Student1);
		data.add(Student2);
		data.add(Student3);
		assertEquals(2, data.size());
	}
	
	@Test
	public void testDuplicateStudentObjectAddedInListOrNot() {
		List<Student> data = new ArrayList<Student>();
		data.add(Student1);
		data.add(Student2);
		data.add(Student3);
		assertEquals(3, data.size());
	}
	
	/**
	 * Test method for insertion order in list.
	 */
	@Test
	public void testInsertionOrderOfObjectInList() {
		assertTrue(TestClassHelper.checkList(Student1, Student3, Student4, Student5));
	}
	
	/**
	 * Test method for insertion order in set.
	 */
	@Test
	public void testInsertionOrderOfObjectInSet() {
		assertFalse(TestClassHelper.checkSet(Student1,Student3,Student4,Student5));
	}
	
	@Test
	public void testSortingrderForTreeSet() {
		Set<Student> tree= new TreeSet<Student>();
		tree.add(Student1);
		tree.add(Student2);
		tree.add(Student3);
		tree.add(Student4);
		tree.add(Student5);
		String[] sortedNames = {"Bootcamp","Pillai","Pochinki","Sats"};
		Iterator it = tree.iterator();
		int i = 0;
		while(it.hasNext()) {
			Student s = (Student) it.next();
			String name = s.getName();
			assertEquals(sortedNames[i], name);
			i++;
		}
	}
	
	/**
	 * Test method for checking overriding object
	 */
	@Test
	public void testDuplicateElementKeyValueAddedInHashMapOrNot() {
		Map<String,String> map = new HashMap<String,String>();
		map.put(Student1.getName(),Student1.getFavFood());
		map.put(Student2.getName(),Student2.getFavFood());
		assertEquals("Apple",map.get("Sats"));
	}
	
	@After
	public void clear() {
		Student1 = null;
		Student2 = null;
		Student3 = null;
		Student4 = null;
		Student5 = null;
	}
	
}
