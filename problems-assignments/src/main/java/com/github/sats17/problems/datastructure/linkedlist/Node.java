package com.github.sats17.problems.datastructure.linkedlist;

public class Node<E> {

	private E value;
	private Node<E> next;

	public Node(E value, Node<E> next) {
		super();
		this.value = value;
		this.next = next;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

}
