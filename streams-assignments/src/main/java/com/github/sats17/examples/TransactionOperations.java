package com.github.sats17.examples;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.github.sats17.model.Transaction;

public class TransactionOperations {

	public static Function<ArrayList<Transaction>, ArrayList<Transaction>> sortByYear = transactions -> {
		
		return transactions.stream()
					.filter(transaction -> transaction.getYear() == 2011)
					.sorted((t1,t2) -> {
						return Integer.compare(t2.getValue(),t1.getValue());
					})
					.collect(Collectors.toCollection(ArrayList::new));
		
		
	};
	
	
	
}
