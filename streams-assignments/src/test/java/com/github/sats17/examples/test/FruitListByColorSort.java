package com.github.sats17.examples.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.examples.FruitListByColor;
import com.github.sats17.examples.FruitSort;
import com.github.sats17.model.Fruit;

public class FruitListByColorSort {

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
		Object[] arr = new Object[]	{f2};
		System.out.println(FruitListByColor.mapByColor.apply( data));
//		assertArrayEquals(arr, FruitListByColor.mapByColor.apply("Red", data).toArray());
	}
	
	@Test
	public void methodTestWithValidInputWithSorted() {
		Object[] arr = new Object[]	{f1,f3};
		assertArrayEquals(arr, FruitListByColor.mapByColorAndSort.apply("Yellow", data).toArray());
	}
	
}
