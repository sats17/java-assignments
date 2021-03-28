package com.github.sats17.lambda.models;

import com.github.sats17.lambda.enums.OrderStatus;

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
