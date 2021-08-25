package com.github.sats17.lambda.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.github.sats17.lambda.enums.OrderStatus;
import com.github.sats17.lambda.interfaces.OrderValidator;
import com.github.sats17.lambda.models.Order;

public class OrderImpl {

	public static OrderValidator validate = orders -> {
		ArrayList<Order> returnValidData = orders.stream().map(order -> order.modifyPrice(price -> price * 2))
				.filter(order -> order.getPrice() > 10000 && order.getStatus().equals(OrderStatus.ACCEPTED))
				.collect(Collectors.toCollection(ArrayList::new));

		return returnValidData;
	};

	public static void main(String[] args) {
		Function<Integer, Integer> ab = (a) -> a;
		System.out.println(ab.apply(2));

		Order order = new Order();
		order.setPrice(1000);
		System.out.println("Get price " + order.getPrice());
		System.out.println(order.modifyPrice(s -> s * 2));
		System.out.println("Get price after" + order.getPrice());

	}

}
