package com.github.sats17.problems.assignments;

import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 =
 * 807. Example 2:
 * 
 * Input: l1 = [0], l2 = [0] Output: [0] Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 * 
 * @author Sats17
 *
 */
public class AddTwoNumberLinkedList {

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

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		long l1Int = traverseNodeAndGetVal(l1);
		long l1IntReverse = reverseInt(l1Int);
		long l2Int = traverseNodeAndGetVal(l2);
		long l2IntReverse = reverseInt(l2Int);
		System.out.println("L1 int "+l1Int);
		System.out.println("L2 int "+l2Int);
		System.out.println("L1 int reverse "+l1IntReverse);
		System.out.println("L2 int reverse "+l2IntReverse);
		long finalVal = l1Int + l2Int;
		System.out.println("Final vla " + finalVal);
		return generateNodeByRecursion(finalVal, false);
	}

	public static ListNode generateNodeByRecursion(long value, boolean isCallingFromRecursion) {
		if (value == 0 && !isCallingFromRecursion) {
			AddTwoNumberLinkedList list = new AddTwoNumberLinkedList();
			return list.new ListNode(0);
		} else if (value == 0 && isCallingFromRecursion) {
			return null;
		} else {
			System.out.println("Value " + value);
			long nodeVal = value % 10;
			long slicedVal = value / 10;
			System.out.println("Node val " + nodeVal);
			System.out.println("Sliced value " + slicedVal);

			AddTwoNumberLinkedList list = new AddTwoNumberLinkedList();
			ListNode recursedNode = generateNodeByRecursion(slicedVal, true);
			ListNode listNode = list.new ListNode((int)nodeVal, recursedNode);
			return listNode;
		}
	}

	public static long traverseNodeAndGetVal(ListNode node) {
		String num = "";
		while (node != null) {
			System.out.println(node.val);
			num = node.val + num;
			node = node.next;
		}
		System.out.println(num);
		return (int) Long.parseLong(num);
	}

	// Not using
	public static long reverseInt(long val) {
		long ans = 0;
		while (val > 0) {
			ans = ans * 10 + val % 10;
			val = val / 10;
		}
		return ans;
	}

	// Util class
	public static ListNode convertListToNodeList(List<Integer> list) {
		AddTwoNumberLinkedList linkedListClass = new AddTwoNumberLinkedList();
		if (list == null || list.isEmpty()) {
			return null;
		}

		ListNode dummyHead = linkedListClass.new ListNode();
		ListNode current = dummyHead;

		for (Integer value : list) {
			current.next = linkedListClass.new ListNode(value);
			current = current.next;
		}

		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = convertListToNodeList(List.of(9));
		ListNode l2 = convertListToNodeList(List.of(1,9,9,9,9,9,9,9,9,9));
		System.out.println(l1.toString());
		AddTwoNumberLinkedList list = new AddTwoNumberLinkedList();
		System.out.println(list.addTwoNumbers(l1, l2));
		System.out.println(reverseInt(012));
	}

}
