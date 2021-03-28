package com.github.sats17.streams.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.github.sats17.streams.model.Fruit;

public class FruitListByColor {

	
	
	public static Function< ArrayList<Fruit>, HashMap<String, ArrayList<String>>> mapByColor = (Fruits) -> {

		HashMap<String, ArrayList<String>> parts = new HashMap<String, ArrayList<String>>();

		Fruits.stream()
			  .forEach(fruit -> {
				  if (parts.containsKey(fruit.getColor())) {
					  ArrayList<String> obj = parts.get(fruit.getColor());
					  obj.add(fruit.getName());
					  parts.put(fruit.getColor(), obj);
				  } else {
					  ArrayList<String> obj = new ArrayList<String>();
					  obj.add(fruit.getName());
					  parts.put(fruit.getColor(), obj);
				  }
			  });
		return parts;
	};

	public static BiFunction<String, ArrayList<Fruit>, ArrayList<Fruit>> mapByColorAndSort = (Color, Fruits) -> {
		return Fruits.stream().filter(fruit -> fruit.getColor().equals(Color)).sorted((f1, f2) -> {
			int result = Integer.compare(f2.getPrice(), f1.getPrice());
			if (result == 0)
				return Integer.compare(f2.hashCode(), f1.hashCode());
			return result;
		}).collect(Collectors.toCollection(ArrayList::new));
	};
}
