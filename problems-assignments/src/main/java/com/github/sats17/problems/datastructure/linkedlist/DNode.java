package com.github.sats17.problems.datastructure.linkedlist;

public class DNode<E> {

	private int temp;
	
	
	private E value;
	private DNode<E> next;
	private DNode<E> prev;

	public DNode(E value, DNode<E> next) {
		super();
		this.value = value;
		this.next = next;
	}
	
	public DNode(E value, DNode<E> next, DNode<E> prev) {
		super();
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

	public DNode() {
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public DNode<E> getNext() {
		return next;
	}

	public void setNext(DNode<E> next) {
		this.next = next;
	}

	public DNode<E> getPrev() {
		return prev;
	}

	public void setPrev(DNode<E> prev) {
		this.prev = prev;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

}
