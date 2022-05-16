package org.way2it.data_structures.binary_tree;

public class BinaryTree {

    // Represents the first node of this tree
    // Should be initialized when first value is added
    private Node root;

    private int size = 0;

    public BinaryTree() {
    }

    // Should add new value to the tree according to binary tree rules:
    // Values that are less than or equal to the value in the current node, should be placed in the left subtree
    // Values that are greater than the value in the current node - should be placed in the right subtree
    public void add(int value) {
        // TODO implement me
    }

    // Should remove specified value from tree and return true
    // If value does not exist in this tree - return false
    public boolean remove(int value) {
        // TODO implement me
        return false;
    }

    // Should return true if this tree contains specified value, false - otherwise
    public boolean contains(int value) {
        // TODO implement me
        return false;
    }

    public int getSize() {
        return size;
    }

    private static class Node {
        int value;
        Node left;
        Node right;
    }
}
