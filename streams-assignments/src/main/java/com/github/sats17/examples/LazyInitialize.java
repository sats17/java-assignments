package com.github.sats17.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example how streams lazy initialize works
 * 
 * @author Sats17
 *
 */
public class LazyInitialize {

	public void LazyInitializeExample() {
		List<String> list = new ArrayList<>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");
		// data will be flow inside stream one by one. hence once filter get prints then forEach will get print for same data
		Stream<String> ab = list.stream()
								.filter(name -> {
									System.out.println("filter: "+name); // this will print once terminal operation executes 
									return true;
								});
		System.out.println("This will print first");  // This will print first because there is no terminal operation declare in ab stream
		ab.forEach(s -> System.out.println("forEach: " + s)); // This will initialize stream
	}
	
}