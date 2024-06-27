package com.github.sats17.problems.datastructure.linkedlist;

import java.util.Comparator;
import java.util.HashSet;

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

	// Merge sort for node.
	public static <E> Node<E> mergeList(Node<E> node1, Node<E> node2, Comparator<E> comparator) {
		Node<E> headNode = new Node<E>();
		Node<E> node3 = headNode;
		while (node1 != null && node2 != null) {
			if (comparator.compare(node1.getValue(), node2.getValue()) == 0) {
				if (node3.getValue() == null) {
					node3.setValue(node1.getValue());
					node3.setNext(null);
				} else {
					Node<E> newNode = new Node<E>(node1.getValue(), null);
					node3.setNext(newNode);
					node3 = newNode;
				}
				node1 = node1.getNext();
				node2 = node2.getNext();
			} else if (comparator.compare(node1.getValue(), node2.getValue()) == -1) {
				if (node3.getValue() == null) {
					node3.setValue(node1.getValue());
					node3.setNext(null);
				} else {
					Node<E> newNode = new Node<E>(node1.getValue(), null);
					node3.setNext(newNode);
					node3 = newNode;
				}
				node1 = node1.getNext();
			} else {
				if (node3.getValue() == null) {
					node3.setValue(node2.getValue());
					node3.setNext(null);
				} else {
					Node<E> newNode = new Node<E>(node2.getValue(), null);
					node3.setNext(newNode);
					node3 = newNode;
				}
				node2 = node2.getNext();
			}
		}

		while (node1 != null) {
			if (node3.getValue() == null) {
				node3.setValue(node1.getValue());
				node3.setNext(null);
			} else {
				Node<E> newNode = new Node<E>(node1.getValue(), null);
				node3.setNext(newNode);
				node3 = newNode;
			}
			node1 = node1.getNext();
		}
		while (node2 != null) {
			if (node3.getValue() == null) {
				node3.setValue(node2.getValue());
				node3.setNext(null);
			} else {
				Node<E> newNode = new Node<E>(node2.getValue(), null);
				node3.setNext(newNode);
				node3 = newNode;
			}
			node2 = node2.getNext();
		}
		return headNode;

	}

	public static <E> Node<E> sortList(Node<E> node, Comparator<E> comparator) {
		if (node.getNext() == null) {
			return node;
		} else {
			Node<E> middle = getMiddleNode(node);

			Node<E> secondPartNode = middle.getNext();
			middle.setNext(null);
			Node<E> list1Op = sortList(node, comparator);
			Node<E> list2Op = sortList(secondPartNode, comparator);
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

	private static <E> Node<E> getMiddleNode(Node<E> node) {

		if (node.getNext() == null || node.getNext().getNext() == null) {
			return node;
		}
		Node<E> slowNode = node;
		Node<E> fastNode = node;

		while (fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}
		System.out.println("Middle node: " + slowNode.getValue());
		return slowNode;

	}

	// Input -> 1, 2, 3, 4, 5
	// Output -> 2, 1, 4, 3, 5
	public static <E> LinkedList<E> swapAdjacentElement(LinkedList<E> list) {

		Node<E> fNode = list.getHead();
		Node<E> sNode = list.getHead().getNext();
		Node<E> itrNode = fNode;
		while (itrNode != null && itrNode.getNext() != null) {
			fNode.setNext(sNode.getNext());
			sNode.setNext(fNode);
			itrNode = fNode.getNext();
			fNode = itrNode;
			sNode = itrNode.getNext();
		}
		return list;
	}

	public static <E> Node<E> reverseList(Node<E> node) {

		Node<E> itrNode = node;
		Node<E> prevNode = null;
		Node<E> frontNode = null;

		while (itrNode != null) {
			frontNode = itrNode.getNext();
			itrNode.setNext(prevNode);
			prevNode = itrNode;
			itrNode = frontNode;
		}

		return prevNode;
	}

	public static <E> void print(Node<E> node) {
		Node<E> currentNode = node;
		while (currentNode != null) {
			System.out.println(currentNode.getValue());
			currentNode = currentNode.getNext();
		}
	}

	public static <E> boolean isCyclic(Node<E> node) {
		Node<E> slow = node;
		Node<E> fast = node;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static <E> boolean isPalindrome(Node<E> node) {
		Node<E> middleNode = getMiddleNode(node);
		Node<E> secondHalfNode = middleNode.getNext();
		while (node != null && secondHalfNode != null) {
			if (node.getValue() == secondHalfNode.getValue()) {
				node = node.getNext();
				secondHalfNode = secondHalfNode.getNext();
			} else {
				return false;
			}
		}
		return true;
	}

	public static <E> Node<E> removeNNodeFromBackOfList(Node<E> node, int n) {
		boolean isSlowActivated = false;
		int counter = 1;
		Node<E> slowNode = node;
		Node<E> earlyNode = node;
		Node<E> prevNode = null;
		while (earlyNode != null) {
			if (isSlowActivated) {
				prevNode = slowNode;
				slowNode = slowNode.getNext();
			}
			if (counter >= n) {
				isSlowActivated = true;
			}
			earlyNode = earlyNode.getNext();
			counter++;
		}

		Node<E> tempNode = slowNode.getNext();
		prevNode.setNext(tempNode);
		slowNode = null;
		print(node);
		return node;
	}

	public static <E> Node<E> sortTemp(Node<E> node, Comparator<E> comparator) {
		if (node.getNext() == null) {
			return node;
		} else {
			Node<E> middleNode = findMiddleNode(node);
			Node<E> secondHalfNode = middleNode.getNext();
			middleNode.setNext(null);
			Node<E> firstSortedNodes = sortTemp(node, comparator);
			Node<E> secondSortedNodes = sortTemp(secondHalfNode, comparator);
			return sortTwoSortedNodes(firstSortedNodes, secondSortedNodes, comparator);
		}
	}

	public static <E> Node<E> sortTwoSortedNodes(Node<E> node1, Node<E> node2, Comparator<E> comparator) {
		Node<E> newNodeHead = new Node<E>();
		Node<E> itrNode = newNodeHead;
		while(node1 != null && node2 != null ) {
			if(comparator.compare(node1.getValue(), node2.getValue()) == 1) {
				itrNode = createOrSetNextNode(node1, itrNode);
				node1 = node1.getNext();
			} else if(comparator.compare(node1.getValue(), node2.getValue()) == -1) {
				itrNode = createOrSetNextNode(node2, itrNode);
				node2 = node2.getNext();
			} else {
				itrNode = createOrSetNextNode(node2, itrNode);
				node1 = node1.getNext();
				node2 = node2.getNext();
			}
		}
		
		while(node1 != null) {
			itrNode = createOrSetNextNode(node1, itrNode);
			node1 = node1.getNext();
		}
		
		while(node2 != null) {
			itrNode = createOrSetNextNode(node2, itrNode);
			node2 = node2.getNext();
		}
		
		return newNodeHead;
	}

	private static <E> Node<E> createOrSetNextNode(Node<E> node1, Node<E> itrNode) {
		if(itrNode.getValue() != null) {
			itrNode.setNext(new Node<E>(node1.getValue(), null));
			itrNode = itrNode.getNext();
		} else {
			itrNode.setValue(node1.getValue());
			itrNode.setNext(null);
		}
		return itrNode;
	}

	public static <E> Node<E> findMiddleNode(Node<E> node) {
		Node<E> slowNode = node;
		Node<E> fastNode = node;
		while (fastNode.getNext() != null && fastNode.getNext().getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}
		return slowNode;
	}
	
	//------------------------ Double linked list -------------------------------------
	public static <E> void print(DNode<E> node) {
		DNode<E> head = node;
		System.out.println(node.getValue());
		DNode<E> itrNode = node.getNext();
		while (itrNode != head) {
			System.out.println(itrNode.getValue());
			itrNode = itrNode.getNext();
		}
	}
	
	public static <E> DNode<E> findMiddleNode(DNode<E> head) {
		DNode<E> slowNode = head;
		DNode<E> fastNode = head;
		
		while(fastNode.getNext() != head && fastNode.getNext().getNext() != head) {
			System.out.println(fastNode == head);
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}
		System.out.println("Middle node in d linkedlist "+slowNode.getValue());
		return slowNode;
		// 1, 2, 2, 4 -> 1, 2, 2, 4
		// 1, 2, 3
	}
	
	public static <E> DNode<E> reverse(DNode<E> head) {
		DNode<E> itrNode = head;
		
		while(itrNode.getNext() != head) {
			DNode<E> tempNode = itrNode.getNext();
			itrNode.setNext(itrNode.getPrev());
			itrNode.setPrev(tempNode);
			itrNode = tempNode;
		}
		return itrNode;
		// 1, 2, 2, 4 -> 1, 2, 2, 4
		// 1, 2, 3
	}

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		for (int i = 12; i > 0; i = i - 1) {
			list1.add(i);
		}
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		for (int i = 0; i < 2; i++) {
			list2.add(i);
		}
		list1.print();
		System.out.println("--------------");
//		list2.print();
//		System.out.println("--------------------------------");

//		LinkedList<Integer> mergedSortedList = LinkedListUtils.mergeList(list1, list2, (a, b) -> a.compareTo(b));
//		mergedSortedList.print();
//		LinkedList<Integer> mergedSortedList = sortList(list1,(a, b) -> a.compareTo(b) );
//		mergedSortedList.print();

//		LinkedList<Integer> swappedAdjacentList = swapAdjacentElement(list1);
//		swappedAdjacentList.print();

//		Node<Integer> list1Head = list2.getHead();
//		Node<Integer> list2Head = list2.getHead();

//		Node<Integer> mergedSortedList = LinkedListUtils.sortList(list1Head, (a, b) -> a.compareTo(b));
//		Node<Integer> reversedNode = reverseList(list1Head);
//		print(reversedNode);

		// Create a temp Nodes
//		Node<Integer> four = new Node<Integer>(4, null);
//		Node<Integer> three = new Node<Integer>(4, null);
//		Node<Integer> two = new Node<Integer>(2, three);
//		Node<Integer> one = new Node<Integer>(1, two);
////		four.setNext(three);
//
//		System.out.println("Is Palindrome "+isPalindrome(one));

		// in odd case fast == null
		// in even case fast.next == null

//		Node<Integer> ans = sortTemp(list1.getHead(), (a, b) -> b.compareTo(a));
//		print(ans);
//		Node<Integer> temp = findMiddleNode(list2.getHead());
//		System.out.println(temp.getValue());
		
		
		//////////////////////// Double linked list with node
		DNode<Integer> head = new DNode<>(1, null, null);
		DNode<Integer> second = new DNode<>(2, null, head);
		DNode<Integer> third = new DNode<>(3, null, second);
		DNode<Integer> four = new DNode<>(4, head, third);
		second.setNext(third);
		third.setNext(four);
		head.setNext(second);
		head.setPrev(four);

		print(head);
		System.out.println("======================");
		DNode<Integer> newHead = reverse(head);
		print(newHead);
	}

}
