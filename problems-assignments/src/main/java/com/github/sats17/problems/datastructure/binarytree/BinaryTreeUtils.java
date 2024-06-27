package com.github.sats17.problems.datastructure.binarytree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeUtils {

	// left, visit, right
	public static <E> Integer findHeight(Node<E> node) {
		if (node == null) {
			return 0;
		} else {
			Integer leftDepth = findHeight(node.left);
			Integer rightDepth = findHeight(node.right);
			return 1 + max(leftDepth, rightDepth);
		}

	}

	private static int max(Integer leftDepth, Integer rightDepth) {
		if (leftDepth < rightDepth) {
			return rightDepth;
		} else if (leftDepth > rightDepth) {
			return leftDepth;
		}
		return leftDepth;
	}

	private static <E> Node<E> insertValueInTree(Node<E> node, E value, Comparator<E> comparator) {

		// node key is greater than value
		if (comparator.compare(node.key, value) == 1) {
			if (node.right == null) {
				node.right = new Node<E>(value);
				return node;
			} else {
				insertValueInTree(node.right, value, comparator);
				return node;
			}
		} else {
			if (node.left == null) {
				node.left = new Node<E>(value);
				return node;
			} else {
				insertValueInTree(node.left, value, comparator);
				return node;
			}
		}

	}

	public static <E> void printTree(Node<E> root) {
		printTreeHelper(root, 0);
	}

	// Helper method to print the tree
	private static <E> void printTreeHelper(Node<E> node, int depth) {
		if (node == null) {
			return;
		}

		// Print right subtree
		printTreeHelper(node.right, depth + 1);

		// Print current node with indentation based on depth
		for (int i = 0; i < depth; i++) {
			System.out.print("    "); // Indentation
		}
		System.out.println(node.key);

		// Print left subtree
		printTreeHelper(node.left, depth + 1);
	}

	static HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	public static Integer fibb(Integer value) {
		if (data.containsKey(value)) {
			return data.get(value);
		}
		if (value < 1) {
			return 1;
		} else {
			Integer res1 = fibb(value - 1);
			Integer res2 = fibb(value - 2);
			data.put(value, res1 + res2);
			System.out.println("Print " + value);
			return res1 + res2;
		}
	}

	public static List<Integer> fibbFlow(Integer value) {
		List<Integer> result = new ArrayList<Integer>();
		Integer counter = 2;
		result.add(0);
		result.add(1);
		result.add(1);
		while (counter < value) {
			result.add(fibb(counter));
			counter++;
		}
		System.out.println(result.toString());
		return result;
	}

	public static Boolean isPrime(Integer value) {
		if (value <= 1)
			return false;
		for (int i = 2; i < value; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		Node<Integer> root = createTempTree();
//
//		System.out.println(findHeight(root));
//		Node<Integer> root = new Node<>(50);
//		for(int i = 1; i <= 5; i++) {
//			
//			Integer val = i * 200;
//			System.out.println("Inserting node " + val);
//			insertValueInTree(root, val, (a, b) -> b.compareTo(a));
//		}
//		
//		printTree(root);

//		fibbFlow(8);

		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		/**
		 * 123 456 789
		 * 
		 * 741 852
		 * 
		 * 
		 * 789 456 123
		 * 
		 */

//		for(int i = 0; i <3; i++) {
//			for(int j = 0; j<3; j++) {
//				System.out.print(matrix[j][i]);
//			}
//			System.out.println("\n");
//		}

//		for(int i = 2; i>=0; i--) {
//			for(int j = 0; j<3; j++) {
//				System.out.print(matrix[i][j]);
//			}
//			System.out.println("\n");
//		}

		System.out.println(isPrime(1));

		Integer value = 90;

		Integer counter = 0;

		List<Integer> primeNumbers = new ArrayList<Integer>();
		while (counter <= value) {
			if (isPrime(counter)) {
				primeNumbers.add(counter);
			}
			counter++;
		}

		System.out.println(primeNumbers);

//		int secondHalfPointer = ;

		for (int firstPointer = 0; firstPointer < primeNumbers.size(); firstPointer++) {
			for (int secondHalfPointer = primeNumbers.size() / 2; secondHalfPointer < primeNumbers
					.size(); secondHalfPointer++) {
				if(primeNumbers.get(firstPointer) + primeNumbers.get(secondHalfPointer) == value) {
					System.out.println("First value "+ primeNumbers.get(firstPointer));
					System.out.println("Second value "+ primeNumbers.get(secondHalfPointer));
					
				}
			}
		}

	}

	private static Node<Integer> createTempTree() {
		Node<Integer> root = new Node<>(50);
		Node<Integer> node1 = new Node<>(30);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(40);
		Node<Integer> node4 = new Node<>(70);
		Node<Integer> node5 = new Node<>(60);
		Node<Integer> node6 = new Node<>(80);

		// Link nodes to form the tree
		root.left = node1;
		root.right = node4;
		node1.left = node2;
		node1.right = node3;
		node4.left = node5;
		node4.right = node6;
		return root;

	}

}
