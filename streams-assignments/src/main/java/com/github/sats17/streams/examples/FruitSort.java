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
	
	private static final int inflationAmount = 2;
	
	
	/*
	 * Fiters fruit having calories less than 100, then sort fruits in ascending order by comparing calories and price(If calories is same)
	 */
	public static Function<List<Fruit>, List<Fruit>> sortByCalories = (List<Fruit> fruits) -> {
		
		return fruits.stream()
				.filter(fruit -> {
					System.out.println("From first filter");
					return true;
				}).
				map(f -> {
					System.out.println("From map");
					f.setCalories(f.getCalories() * inflationAmount);
					System.out.println(f);
					return f;
				})
				.filter(fruit -> {
					System.out.println("From second filter");
					return true;
				})
			  .sorted((f1,f2) -> { 
				  System.out.println("From sorted");
				  System.out.println(f1);
				  System.out.println(f2);
				  int result = Integer.compare(f2.getCalories(), f1.getCalories());
				  System.out.println("Sort result "+result);
//				  if(result == 0)
//					  return Integer.compare(f2.getPrice(),f1.getPrice());
				return result;
			  }).
			  filter(fruit -> {
					System.out.println("From third filter");
					return true;
				}).
			  filter(fruit -> {
					System.out.println("From Fourth filter");
					return true;
				})
			  .collect(Collectors.toCollection(ArrayList::new));
	};
	
	private static Function<List<Fruit>, List<Fruit>> sortByName = (List<Fruit> fruit) -> {
		return fruit.stream()
				.sorted((f1, f2) -> {
					return f1.getName().compareTo(f2.getName());
				}).collect(Collectors.toList());
	};

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Fruit> data = new ArrayList<Fruit>();
		
		Fruit f0 = new Fruit("Chiku", 10000, 2, "grey"); 
		data.add(f0);
		Fruit f1 = new Fruit("Banana", 800, 20000, "Yellow");
		Fruit f2 = new Fruit("Apple", 160, 200, "Red");
		Fruit f3 = new Fruit("Pineapple", 170, 250, "yellow");
		data.add(f1);
		data.add(f2);
		data.add(f3);
		
		
		
		data.forEach(fruit -> System.out.println(fruit));
		System.out.println("Data feeding done");
		System.out.println("\n");
		List<Fruit> result = FruitSort.sortByCalories.apply(data);
		System.out.println("\n");
		result.forEach(fruit -> System.out.println(fruit));
		
		// To check sort by name uncomment below code
//		System.out.println("Sort by name started");
//		FruitSort.sortByName.apply(data).forEach(fruit -> System.out.println(fruit));
		
		// Below one will thorw error because Fruit do not have comparable implemented
		//data.stream().sorted().forEach(fruit -> System.out.println(fruit));
		
		
		// Compare by color comparator written as a variable. To check uncomment below code
//		System.out.println("Sort by color started");
//		Comparator<Fruit> compareByColour = (fruit1, fruit2) -> {
//			return fruit1.getColor().compareToIgnoreCase(fruit2.getColor());
//		};
//		data.stream().sorted(compareByColour).forEach(fruit -> System.out.println(fruit));
	}

}
