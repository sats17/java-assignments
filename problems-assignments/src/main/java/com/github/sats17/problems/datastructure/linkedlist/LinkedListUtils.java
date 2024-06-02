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
	
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		for(int i = 0; i < 12; i = i + 2) {
			list1.add(i);
		}
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		for(int i = 1; i < 12; i = i + 2) {
			list2.add(i);
		}
		list1.print();
		System.out.println("--------------");
		list2.print();
		System.out.println("--------------------------------");
		
		LinkedList<Integer> mergedSortedList = LinkedListUtils.mergeList(list1, list2, (a, b) -> a.compareTo(b));
		mergedSortedList.print();
	}

}
