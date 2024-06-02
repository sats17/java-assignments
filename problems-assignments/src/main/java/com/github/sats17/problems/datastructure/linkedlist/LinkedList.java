package com.github.sats17.problems.datastructure.linkedlist;

public class LinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private Integer length = 0;

	public Node<E> getHead() {
		return head;
	}

	public Node<E> getTail() {
		return tail;
	}
	
	public void add(E value) {
		if (this.head == null) {
			this.head = new Node<E>(value, null);
			this.length++;
		} else {
			Node<E> currentNode = this.head;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(new Node<E>(value, null));
			this.length++;
		}
	}
	
	public Integer length() {
		return this.length;
	}
	
	public void print() {
		Node<E> currentNode = this.head;
		while(currentNode.getNext() != null) {
			System.out.println(currentNode.getValue());
			currentNode = currentNode.getNext();
		}
		System.out.println(currentNode.getValue());
	}
	
	public static void main(String[] args) {
		


	}

}
