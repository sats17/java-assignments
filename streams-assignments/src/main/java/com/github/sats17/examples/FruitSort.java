package com.github.sats17.examples;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.github.sats17.model.Fruit;

public class FruitSort {
	
	
	public static Function<ArrayList<Fruit>,ArrayList<Fruit>> sort = (ArrayList<Fruit> fruits) -> {
		
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

	
	

}
