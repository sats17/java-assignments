package com.github.sats17.examples;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.github.sats17.model.Trader;

public class TradeOperations {

	public static Function<ArrayList<Trader>, ArrayList<String>> findTradersUniqueCity = (traders) -> {
	
		return traders.stream()
			   .map(city -> city.getCity())
			   .distinct()
			   .collect(Collectors.toCollection(ArrayList::new));
	
	};
	
	public static Function<ArrayList<Trader>, ArrayList<Trader>> findAndSort = (traders) -> {
		
		return traders.stream()
					  .filter(trader -> trader.getCity().equals("pune"))
					  .sorted((t1,t2) -> {
						  return t1.getName().compareTo(t2.getName());
					  })
					  .collect(Collectors.toCollection(ArrayList::new));
	
	};
	
	public static Function<ArrayList<Trader>, ArrayList<Trader>> sortByName = (traders) -> {
		
		return traders.stream()
					  .sorted((t1,t2) -> {
						  return t1.getName().compareTo(t2.getName());
					  })
					  .collect(Collectors.toCollection(ArrayList::new));
	
	};
	
public static BiFunction<ArrayList<Trader>,String, Boolean> isCityPresent = (traders,word) -> {
		
		return traders.stream()
					  .anyMatch(trader -> trader.getCity().equals(word));
	
	};
	
}
