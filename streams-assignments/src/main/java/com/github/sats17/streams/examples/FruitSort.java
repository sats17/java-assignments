package com.github.sats17.streams.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.github.sats17.streams.model.Fruit;

public class FruitSort {
	
	
	/*
	 * Fiters fruit having calories less than 100, then sort fruits in ascending order by comparing calories and price(If calories is same)
	 */
	public static Function<List<Fruit>, List<Fruit>> sort = (List<Fruit> fruits) -> {
		
		return fruits.stream()
			  .filter(fruit -> fruit.getCalories() < 100 )
			  .sorted((f1,f2) -> {
				  int result = Integer.compare(f2.getCalories(), f1.getCalories());
				  if(result == 0)
					  return Integer.compare(f2.getPrice(),f1.getPrice());
				return result;
			  })
			  .collect(Collectors.toCollection(ArrayList::new));
	};

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Fruit> data = new ArrayList<Fruit>();
		ArrayList<String> test = new ArrayList<>();
		test.add("test");
		test.add("abes");
		Fruit f0 = new Fruit("Chiku", 10000, 2, "Yellow"); 
		data.add(f0);
		Fruit f1 = new Fruit("Banana", 800, 20000, "Yellow");
		Fruit f2 = new Fruit("Apple", 160, 200, "Red");
		Fruit f3 = new Fruit("Pineapple", 170, 250, "Yellow");
		data.add(f1);
		data.add(f2);
		data.add(f3);
//		for(Object f: FruitSort.sort.apply(data).toArray()) {
//			System.out.println(f);
//		}
		Comparator<Fruit> compareString = (s1, s2) -> {
			System.out.println("Before this Comparing");
			System.out.println("data is "+data);
			System.out.println("below values");
			System.out.println(s1);
			System.out.println(s2);
			System.out.println("\n");
			if(s1.getCalories() == s2.getCalories()) {
				return 0;
			}
			if(s1.getCalories() > s2.getCalories()) {
				return 1;
			}
			return -1;
		};
		System.out.println(data);
		Collections.sort(data, compareString);
		System.out.println("After sort");
		System.out.println(data);
//		test.forEach(f -> {
//			System.out.println(f);
//		});
//		System.out.println(Integer.compare(1, 7));
	}

}
