package com.github.sats17.streams.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.streams.examples.TradeOperations;
import com.github.sats17.streams.examples.TransactionOperations;
import com.github.sats17.streams.model.Trader;
import com.github.sats17.streams.model.Transaction;

public class TradeOperationsTest {
	
	Trader t1,t2,t3,t4;
	ArrayList<Trader> trades;
	
	@Before
	public void setUp() {
		t1 = new Trader("sats", "mumbai");
		t2 = new Trader("sham", "pune");
		t3 = new Trader("kund", "satara");
		t4 = new Trader("akash", "pune");
		trades =
				new ArrayList<Trader>(Arrays.asList(t1,t2,t3,t4));
	}
	
	@Test
	public void testFindTradersUniqueCityWithValidInput() {
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("mumbai","pune","satara"));
		assertEquals(expected,TradeOperations.findTradersUniqueCity.apply(trades));
	}
	
	@Test
	public void testFindAndSort() {
		ArrayList<Trader> expected = new ArrayList<Trader>(Arrays.asList(t4,t2));
		assertEquals(expected,TradeOperations.findAndSort.apply(trades));
	}
	
	
	@Test
	public void testAndSort() {
		ArrayList<Trader> expected = new ArrayList<Trader>(Arrays.asList(t4,t3,t1,t2));
		assertEquals(expected,TradeOperations.sortByName.apply(trades));
	}
	
	@Test
	public void testForCityMatch() {
		assertEquals(true,TradeOperations.isCityPresent.apply(trades, "pune"));
	}
	
	@Test
	public void testForCityNotMatch() {
		assertEquals(false,TradeOperations.isCityPresent.apply(trades, "indore"));
	}
}
