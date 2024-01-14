package com.github.sats17.problems.assignments;

// * Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class LinkedListProblems {
	
	/**
	 * Time complexity O(n) where n is size of linked list.
	 * Space complexity O(1) where no extra space is required.
	 * 
	 * Idea is to use travel at end of list, but use pointer value by comparing given n. if pointer exceeds the value of n,
	 * then start fetching again start traveling from head using this pointer. Which eventually going to end at position where
	 * (linkedListSize - n). So we can remove that node and fix the linked list
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode firstHead = head;
		ListNode ogHead = head;
		int pointer1 = 1;
		while(head.next != null) {
			head = head.next;
			if(pointer1 > n) {
				ogHead = ogHead.next;
			}
			pointer1++;
		}
		ListNode newNode = ogHead.next.next;
		ogHead.next = newNode;
		
		// Print new list
		while(firstHead != null) {
			System.out.println("head value "+firstHead.val);
			firstHead = firstHead.next;
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		LinkedListProblems llp = new LinkedListProblems();
		llp.removeNthFromEnd(node1, 5);
		
	}
}
