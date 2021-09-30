package com.github.sats17.streams.examples;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.github.sats17.streams.model.Transaction;

public class TransactionOperations {

	// below variable is function and class implementation of functional interface nothing but syntatical sugar of 
	// below sortByYear2 variable implementation
	public static Function<ArrayList<Transaction>, ArrayList<Transaction>> sortByYear = (transactions) -> {

		return transactions.stream()
						   .filter(transaction -> transaction.getYear() == 2011)
						   .sorted((t1, t2) -> {
							   return Integer.compare(t2.getValue(), t1.getValue());
						   }).collect(Collectors.toCollection(ArrayList::new));

	};
	
	public static test sortByYear2 = new test();

}

class test implements Function<ArrayList<Transaction>, ArrayList<Transaction>> {

	@Override
	public ArrayList<Transaction> apply(ArrayList<Transaction> t) {
		return t.stream()
				   .filter(transaction -> transaction.getYear() == 2011)
				   .sorted((t1, t2) -> {
					   return Integer.compare(t2.getValue(), t1.getValue());
				   }).collect(Collectors.toCollection(ArrayList::new));
	}
	
}
