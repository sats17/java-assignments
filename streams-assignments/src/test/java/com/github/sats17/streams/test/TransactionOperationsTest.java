package com.github.sats17.streams.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.streams.examples.TransactionOperations;
import com.github.sats17.streams.model.Trader;
import com.github.sats17.streams.model.Transaction;

public class TransactionOperationsTest {
	ArrayList<Transaction> transactions;
	Transaction t1,t2,t3;
	@Before
	public void setUp() {
		t1 = new Transaction(2011, 5000, new Trader("sats", "mumbai"));
		t2 = new Transaction(2012, 4000, new Trader("sham", "pune"));
		t3 = new Transaction(2011, 51000, new Trader("kund", "satara"));
		transactions =
				new ArrayList<Transaction>(Arrays.asList(t1,t2,t3));
	}
	
	@Test
	public void testsortByYearWithValidInput() {
		ArrayList<Transaction> expected = new ArrayList<Transaction>(Arrays.asList(t3,t1));
		assertEquals(expected,TransactionOperations.sortByYear.apply(transactions));
	}
	
	
	
}
