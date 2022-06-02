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
        Node addNode = new Node();
        addNode.value = value;
        addNode.left = null;
        addNode.right = null;
        if (root == null) {
            root = addNode;
        } else {
            Node thisNode = root;
            while (thisNode.right != null && thisNode.left != null) {
                if (value > thisNode.value) thisNode = thisNode.right;
                if (value <= thisNode.value) thisNode = thisNode.left;
            }
            if (value > thisNode.value) {
                thisNode.right = addNode;
            } else thisNode.left = addNode;
        }
        size++;
    }

    // Should remove specified value from tree and return true
    // If value does not exist in this tree - return false
    public boolean remove(int value) {
        // TODO implement me
        Node removeNode = root;
        while (removeNode.value != value) {
            if (value > removeNode.value) removeNode = removeNode.right;
            else removeNode = removeNode.left;
        }
        if (removeNode.value != value) return false;
        else {
            if (removeNode.right == null && removeNode.left == null) {
                removeNode = null;
            } else if (removeNode.right == null && removeNode.left != null) {
                removeNode = removeNode.left;
            } else if (removeNode.left == null && removeNode.right != null) {
                removeNode = removeNode.right;
            } else {
                Node replaceNode = removeNode.left;
                while (replaceNode.right != null) replaceNode = replaceNode.right;
                if (replaceNode.left == null) {
                    removeNode.value = replaceNode.value;
                    replaceNode = null;
                } else {
                    removeNode.value = replaceNode.value;
                    replaceNode = replaceNode.left;
                }
            }
            size--;
            return true;
        }
    }

    // Should return true if this tree contains specified value, false - otherwise
    public boolean contains(int value) {
        // TODO implement me
        Node thisNode = root;
        while (thisNode.value != value) {
            if (value > thisNode.value) {
                thisNode = thisNode.right;
            } else {
                thisNode = thisNode.left;
            }
        }
        if (thisNode.value == value) return true;
        else return false;
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
