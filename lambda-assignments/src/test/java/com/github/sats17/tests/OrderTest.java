package com.github.sats17.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.github.sats17.enums.OrderStatus;
import com.github.sats17.main.OrderImpl;
import com.github.sats17.models.Order;

public class OrderTest {
	Order order1,order2,order3,order4,order5;
	ArrayList<Order> data;
	@Before
	public void setUp() {
		order1 = new Order(100000, OrderStatus.ACCEPTED);
		order2 = new Order(6600, OrderStatus.ACCEPTED);
		order3 = new Order(1099900, OrderStatus.REJECTED);
		order4 = new Order(100000, OrderStatus.ACCEPTED);
		order5 = new Order(500000, OrderStatus.ACCEPTED);
		
		data = new ArrayList<Order>();
		data.add(order1);
		data.add(order2);
		data.add(order3);
		data.add(order4);
		data.add(order5);
	}
	
	@Test
	public void testWithValidInput() {
		Order[] expected = {order1,order4,order5};
		assertArrayEquals(expected, OrderImpl.validate.validate(data).toArray());
	}

}
