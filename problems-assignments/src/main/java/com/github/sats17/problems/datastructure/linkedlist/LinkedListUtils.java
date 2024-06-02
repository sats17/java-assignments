package com.github.sats17.problems.datastructure.linkedlist;

import java.util.Comparator;

public class LinkedListUtils {

	public static <E> LinkedList<E> mergeList(LinkedList<E> list1, LinkedList<E> list2, Comparator<E> comparator) {
		LinkedList<E> list3 = new LinkedList<E>();
		Node<E> node1 = list1.getHead();
		Node<E> node2 = list2.getHead();
		while (node1 != null && node2 != null) {
			if (comparator.compare(node1.getValue(), node2.getValue()) == 0) {
				list3.add(node1.getValue());
				node1 = node1.getNext();
				node2 = node2.getNext();
			} else if (comparator.compare(node1.getValue(), node2.getValue()) == -1) {
				list3.add(node1.getValue());
				node1 = node1.getNext();
			} else {
				list3.add(node2.getValue());
				node2 = node2.getNext();
			}
		}

		while (node1 != null) {
			list3.add(node1.getValue());
			node1 = node1.getNext();
		}
		while (node2 != null) {
			list3.add(node2.getValue());
			node2 = node2.getNext();
		}
		return list3;

	}

	public static <E> LinkedList<E> sortList(LinkedList<E> list, Comparator<E> comparator) {
		if (list.getHead().getNext() == null) {
			return list;
		} else {
			Node<E> middle = getMiddleNode(list);
			LinkedList<E> list1 = new LinkedList<E>();
			list1.setHead(list.getHead());
			list1.setTail(middle);
			LinkedList<E> list2 = new LinkedList<E>();
			list2.setHead(middle.getNext());
			list2.setTail(null);
			middle.setNext(null);
			LinkedList<E> list1Op = sortList(list1, comparator);
			LinkedList<E> list2Op = sortList(list2, comparator);
			return mergeList(list1Op, list2Op, comparator);
			
		}
	}

	// first linked list head = head and tail = middle node
	// second linked list head = middle.next and tail = tail

	// mergeSort(arr1)
	// condition for size >= 1
	// else condition
	// arr1 = mergeSort(arr1 part 1)
	// arr2 = mergeSort(arr1 part 2)
	// return sort(arr1, arr2)

	private static <E> Node<E> getMiddleNode(LinkedList<E> list) {
		if (list.getHead() == null) {
			throw new IllegalArgumentException("List is empty");
		}
		if (list.getHead().getNext() == null || list.getHead().getNext().getNext() == null) {
			return list.getHead();
		}
		Node<E> slowNode = list.getHead();
		Node<E> fastNode = list.getHead();

		while (fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}
		System.out.println("Middle node: " + slowNode.getValue());
		return slowNode;

	}

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		for (int i = 12; i > 0; i = i - 1) {
			list1.add(i);
		}
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		for (int i = 1; i < 12; i = i + 2) {
			list2.add(i);
		}
		list1.print();
		System.out.println("--------------");
//		list2.print();
//		System.out.println("--------------------------------");

//		LinkedList<Integer> mergedSortedList = LinkedListUtils.mergeList(list1, list2, (a, b) -> a.compareTo(b));
//		mergedSortedList.print();
		LinkedList<Integer> mergedSortedList = sortList(list1,(a, b) -> a.compareTo(b) );
		mergedSortedList.print();
	}

}
