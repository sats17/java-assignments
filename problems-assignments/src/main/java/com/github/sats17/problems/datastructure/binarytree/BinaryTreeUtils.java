package com.github.sats17.problems.datastructure.binarytree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	/**
	 * This is bruteforce approach with complextiy O(2N) where n is number of nodes
	 * @param <E>
	 * @param node
	 */
	public static <E> void checkIfTreeIsBalancedOrNot(Node<E> node) {
		Integer leftHeight = findHeight(node.left);
		Integer rightHeight = findHeight(node.right);
		if(leftHeight != rightHeight) {
			System.out.println("Tree is not balanced");
		} else {
			System.out.println("Tree is balanced");
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

	private static Node<Integer> createTempTree() {
		Node<Integer> root = new Node<>(50);
		Node<Integer> node1 = new Node<>(30);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(40);
		Node<Integer> node4 = new Node<>(70);
		Node<Integer> node5 = new Node<>(60);
		Node<Integer> node6 = new Node<>(80);
		Node<Integer> node7 = new Node<>(90);

		// Link nodes to form the tree
		root.left = node1;
		root.right = node4;
		node1.left = node2;
		node1.right = node3;
		node4.left = node5;
		node4.right = node6;
		node6.left = node7;
		return root;

	}
	
	public static List<Integer> treeToArray(Node<Integer> root) {
//		data.add(root.key);
		List<Integer> data = new ArrayList<>();
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node<Integer> currentNode = queue.poll();
			
			data.add(currentNode.key);
			
			if(currentNode.key == -1) {
				continue;
			}
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			} else {
				currentNode.left = new Node<Integer>(-1);
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			} else {
				currentNode.right = new Node<Integer>(-1);
				queue.add(currentNode.right);
			}
				
		}
		
		System.out.println(data);
		
		
		return null;
	}

	public static void main(String[] args) {
	
		//Node<Integer> tree = createTempTree();
//		checkIfTreeIsBalancedOrNot(tree);
		
		Node<Integer>  tree = new Node(1);
        tree.left = new Node<Integer>(2);
        tree.right = new Node(3);
        tree.right.right = new Node(7);
        
        treeToArray(tree);
        
	}

}
