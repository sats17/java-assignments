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

	public void setHead(Node<E> head) {
		this.head = head;
	}

	public void setTail(Node<E> tail) {
		this.tail = tail;
	}

	public void add(E value) {
		if (this.head == null) {
			this.head = new Node<E>(value, null);
			this.tail = this.head;
			this.length++;
		} else {
			Node<E> currentNode = this.head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(new Node<E>(value, null));
			this.tail = currentNode;
			this.length++;
		}
	}

	public Integer length() {
		return this.length;
	}

	public void print() {
		Node<E> currentNode = this.head;
		while (currentNode.getNext() != null) {
			System.out.println(currentNode.getValue());
			currentNode = currentNode.getNext();
		}
		System.out.println(currentNode.getValue());
	}

	public static void main(String[] args) {

	}

}
