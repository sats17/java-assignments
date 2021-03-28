package com.github.sats17.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.github.sats17.enums.OrderStatus;
import com.github.sats17.interfaces.OrderValidator;
import com.github.sats17.models.Order;

public class OrderImpl {
	
	public static OrderValidator validate = orders -> {
		ArrayList<Order> returnValidData =  orders.stream()
												  .filter(order -> order.getPrice() > 10000 && order.getStatus().equals(OrderStatus.ACCEPTED))
												  .collect(Collectors.toCollection(ArrayList::new));

		return returnValidData;
	};
	
	
}
