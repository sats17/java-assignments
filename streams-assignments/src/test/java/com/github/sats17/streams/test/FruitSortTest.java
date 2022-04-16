package com.github.sats17.streams.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.streams.examples.FruitSort;
import com.github.sats17.streams.model.Fruit;

public class FruitSortTest {

	Fruit f1,f2,f3;
	ArrayList<Fruit> data;
	
	@Before
	public void setUp() {
		data = new ArrayList<Fruit>();
		f1 = new Fruit("Banana", 80, 20000, "Yellow");
		f2 = new Fruit("Apple", 160, 200, "Red");
		f3 = new Fruit("Pineapple", 70, 250, "Yellow");
		data.add(f1);
		data.add(f2);
		data.add(f3);
	}
	
	@Test
	public void methodTestWithValidInput() {
		Object[] arr = new Object[]	{f1,f3};
		assertArrayEquals(arr, FruitSort.sortByCalories.apply(data).toArray());
		
		
	}
	
}
