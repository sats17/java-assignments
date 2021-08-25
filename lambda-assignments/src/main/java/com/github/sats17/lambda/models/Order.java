package com.github.sats17.lambda.models;

import java.util.function.Function;

import com.github.sats17.lambda.enums.OrderStatus;
import com.github.sats17.lambda.interfaces.ArithmaticOperations;

public class Order {

	private long price;
	private OrderStatus status;
	
	public Order() {
	}

	/**
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}
	
	/**
	 * Example for lambda interface where user can modified price accordingly
	 * @param ab
	 * @return
	 */
	public Order modifyPrice(Function<Long, Long> ab) {
		this.price = ab.apply(this.price);
		return this;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}

	/**
	 * @return the status
	 */
	public OrderStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Order(long price, OrderStatus status) {
		super();
		this.price = price;
		this.status = status;
	}
	
	

}
