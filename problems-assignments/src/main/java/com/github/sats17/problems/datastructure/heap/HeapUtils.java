package com.github.sats17.problems.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapUtils {

    // Print tree methods start
    // Helper method to get the maximum depth of the tree
    static int getMaxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

    // Method to print the binary tree
    static void printTree(Node root) {
        if (root == null) {
            return;
        }

        int maxDepth = getMaxDepth(root);
        List<Node> currentLevel = new ArrayList<>();
        currentLevel.add(root);

        // Print each level of the tree
        for (int level = 0; level < maxDepth; level++) {
            // Print spaces for proper alignment
            printNodeLevel(currentLevel, maxDepth - level);

            // Print branches (`/` and `\`)
            if (level < maxDepth - 1) {
                printBranches(currentLevel, maxDepth - level);
            }

            // Prepare the next level
            currentLevel = getNextLevel(currentLevel);
        }
    }

    // Print the current level nodes with appropriate spacing
    static void printNodeLevel(List<Node> nodes, int spacing) {
        int betweenSpaces = (int) Math.pow(2, spacing + 1) - 1;

        printSpaces(betweenSpaces / 2); // Leading spaces

        for (Node node : nodes) {
            if (node == null) {
                System.out.print(" ");
            } else {
                System.out.print(node.key);
            }
            printSpaces(betweenSpaces); // Spaces between nodes
        }
        System.out.println();
    }

    // Print branches between the levels
    static void printBranches(List<Node> nodes, int spacing) {
        int betweenSpaces = (int) Math.pow(2, spacing) - 1;
        int branchSpaces = betweenSpaces / 2;

        printSpaces(branchSpaces); // Leading spaces for branches

        for (Node node : nodes) {
            if (node == null) {
                printSpaces(betweenSpaces + 1); // Space for the missing branches
                continue;
            }
            if (node.left != null) {
                System.out.print("/");
            } else {
                System.out.print(" ");
            }

            printSpaces(betweenSpaces); // Spaces between the branches

            if (node.right != null) {
                System.out.print("\\");
            } else {
                System.out.print(" ");
            }
            printSpaces(1); // After each branch
        }
        System.out.println();
    }

    // Get the next level of nodes (left and right children)
    static List<Node> getNextLevel(List<Node> nodes) {
        List<Node> nextLevel = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                nextLevel.add(node.left);
                nextLevel.add(node.right);
            } else {
                // Add null placeholders for non-existent children
                nextLevel.add(null);
                nextLevel.add(null);
            }
        }
        return nextLevel;
    }

    // Print a number of spaces
    static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
    // Print tree methods end

    public static Node<Integer> arrToHeap(int[] arr) {

        Node<Integer> root = new Node<>(arr[0]);
        int arrLen = arr.length;
        Node<Integer>[] tempArr = new Node[arrLen];
        tempArr[0] = root;

        for (int i = 1; i < arrLen; i++) {

            // Store root element in temp arr and heap
            int value = arr[i];
            tempArr[i] = new Node<Integer>(value);
            int heapIndex = i + 1;
            int parentIndex = heapIndex / 2;
            Node<Integer> parentNode = tempArr[parentIndex - 1];
            boolean fromLeft = false;
            if (parentNode.left == null) {
                parentNode.left = tempArr[i];
                fromLeft = true;
            } else {
                parentNode.right = tempArr[i];
            }
            // Done with putting item into tempArr and assign them into binary tree

            // Now Heapify needs to done on tempArr.

            int currentIndex = heapIndex - 1;
            int currentParentIndex = parentIndex - 1;

            while (tempArr[currentParentIndex].key < tempArr[currentIndex].key) {
                Node<Integer> currentParentNode = tempArr[currentParentIndex];
                Node<Integer> currentNode = tempArr[currentIndex];
                if (fromLeft) {
                    // Store nodes left right in temp variables
                    Node<Integer> tempParentRightNode = currentParentNode.right;
                    Node<Integer> tempCurrentRightNode = currentNode.right;
                    Node<Integer> tempCurrentLeftNode = currentNode.left;

                    // Update currentNode left right with parents
                    currentNode.right = tempParentRightNode;
                    currentNode.left = currentParentNode;

                    // Update parent node left right with current node left right
                    currentParentNode.left = tempCurrentLeftNode;
                    currentParentNode.right = tempCurrentRightNode;

                    // Shift the array values
                    tempArr[currentParentIndex] = currentNode;
                    tempArr[currentIndex] = currentParentNode;

                    currentIndex = currentParentIndex;
                    currentParentIndex = currentIndex / 2;


                } else {

                    // Store nodes left right in temp variables
                    Node<Integer> tempParentLeftNode = currentParentNode.left;
                    Node<Integer> tempCurrentRightNode = currentNode.right;
                    Node<Integer> tempCurrentLeftNode = currentNode.left;

                    // Update currentNode left right with parents
                    currentNode.left = tempParentLeftNode;
                    currentNode.right = currentParentNode;

                    // Update parent node left right with current node left right
                    currentParentNode.left = tempCurrentLeftNode;
                    currentParentNode.right = tempCurrentRightNode;

                    // Shift the array values
                    tempArr[currentParentIndex] = currentNode;
                    tempArr[currentIndex] = currentParentNode;

                    currentIndex = currentParentIndex;
                    currentParentIndex = currentIndex / 2;

                }
            }

        }


        return tempArr[0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node<Integer> root = arrToHeap(arr);
        printTree(root);

    }

}
