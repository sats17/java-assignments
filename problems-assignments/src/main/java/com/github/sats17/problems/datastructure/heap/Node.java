package com.github.sats17.problems.datastructure.heap;

public class Node<E> {

	E key;
	Node<E> left;
	Node<E> right;

	public Node(E item) {
		key = item;
		left = right = null;
	}

}
