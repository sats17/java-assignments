package com.github.sats17.basicassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.github.sats17.streams.model.Fruit;

/*
 * In this assignment we checked how comparator functional interface used with Collections.sort.
  To check comparator custom example refer -> https://github.com/sats17/java-assignments/blob/main/problems-assignments/src/main/java/com/github/sats17/problems/assignments/MergeSort.java
 */
public class CompareAssignment {

	public static void main(String[] args) {
		List<Fruit> data = new ArrayList<Fruit>();
		
		Fruit f0 = new Fruit("Chiku", 10000, 2, "Yellow"); 
		data.add(f0);
		Fruit f1 = new Fruit("Banana", 800, 20000, "Yellow");
		Fruit f2 = new Fruit("Apple", 160, 200, "Red");
		Fruit f3 = new Fruit("Pineapple", 170, 250, "Yellow");
		data.add(f1);
		data.add(f2);
		data.add(f3);
		
		Comparator<Fruit> compareString = (s1, s2) -> {
			System.out.println("Before Current comparision this two "+s1+"\n"+s2);
			System.out.println("\nAnd data is "+data);
			System.out.println("\n");
			if(s1.getCalories() == s2.getCalories()) {
				return 0;
			}
			if(s1.getCalories() > s2.getCalories()) {
				return 1;
			}
			return -1;
		};
		
		System.out.println("Before sorting ");
		System.out.println(data);
		System.out.println("\n");
		// Collections.sort uses this compareString comparator F.I, compare method for comparing two objects. 
		// It internally uses merge sort for objects and quicksort for primitive data.
		// When we don't pass any comparator in Collections.sort it try to use Comparable.(To use Comparable the class must implement it)
		// Or else it will throw error.
		Collections.sort(data, compareString); 
		System.out.println("After sorting ");
		System.out.println(data);
		// Below code will throw error, because Fruit class does not implemented Comparable
		// Collections.sort((ArrayList) data);
	}
	
}
