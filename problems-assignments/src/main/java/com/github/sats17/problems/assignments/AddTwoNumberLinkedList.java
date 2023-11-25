package com.github.sats17.problems.assignments;

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
		int l1Int = reverseInt(traverseNodeAndGetVal(l1));
		int l2Int = reverseInt(traverseNodeAndGetVal(l2));
		int finalVal = l1Int + l2Int;
		System.out.println("Final vla " + finalVal);
		return generateNodeByRecursion(finalVal, false);
	}

	public static ListNode generateNodeByRecursion(int value, boolean isCallingFromRecursion) {
		if (value == 0 && !isCallingFromRecursion) {
			AddTwoNumberLinkedList list = new AddTwoNumberLinkedList();
			return list.new ListNode(0);
		} else if (value == 0 && isCallingFromRecursion) {
			return null;
		} else {
			System.out.println("Value " + value);
			int nodeVal = value % 10;
			int slicedVal = value / 10;
			System.out.println("Node val " + nodeVal);
			System.out.println("Sliced value " + slicedVal);

			AddTwoNumberLinkedList list = new AddTwoNumberLinkedList();
			ListNode recursedNode = generateNodeByRecursion(slicedVal, true);
			ListNode listNode = list.new ListNode(nodeVal, recursedNode);
			return listNode;
		}
	}

	public static int traverseNodeAndGetVal(ListNode node) {
		int num = 0;
		while (node != null) {
			num = num * 10 + node.val;
			node = node.next;
		}

		return num;
	}

	public static ListNode generateNode1() {
		AddTwoNumberLinkedList list = new AddTwoNumberLinkedList();
		ListNode listNode4 = list.new ListNode(0);
//		ListNode listNode2 = new AddTwoNumberLinkedList().new ListNode(4, listNode4);
//		ListNode listNode1 = new AddTwoNumberLinkedList().new ListNode(2, listNode2);

		return listNode4;
	}

	public static ListNode generateNode2() {
		AddTwoNumberLinkedList list = new AddTwoNumberLinkedList();
		ListNode listNode5 = list.new ListNode(0);
//		ListNode listNode3 = new AddTwoNumberLinkedList().new ListNode(6, listNode5);
//		ListNode listNode9 = new AddTwoNumberLinkedList().new ListNode(5, listNode3);
		return listNode5;
	}

	public static int reverseInt(int val) {
		int ans = 0;
		while (val > 0) {
			ans = ans * 10 + val % 10;
			val = val / 10;
		}
		return ans;
	}

	public static void main(String[] args) {
		AddTwoNumberLinkedList list = new AddTwoNumberLinkedList();
		System.out.println(list.addTwoNumbers(generateNode1(), generateNode2()));
		System.out.println(8 % 10);
	}

}
