package com.github.sats17.lambda.interfaces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.sats17.lambda.models.Order;

@FunctionalInterface
public interface OrderValidator {
	public ArrayList<Order> validate(ArrayList<Order> orders);
}
