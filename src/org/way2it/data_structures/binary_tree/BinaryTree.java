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
        Node current = this.root;
        Node nextNode = new Node();
        nextNode.value = value;
        if (current == null) {
            root = nextNode;
        } else {
            while (current != null) {
                if (value < current.value) {
                    if (current.left == null) {
                        current.left = nextNode;
                        break;
                    } else {
                        current = current.left;
                    }
                } else if (value > current.value) {
                    if (current.right == null) {
                        current.right = nextNode;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
        size++;
    }


    // Should remove specified value from tree and return true
    // If value does not exist in this tree - return false
    public boolean remove(int value) {
        // TODO implement me
        Node current = this.root;
        Node find = new Node();
        while (current != null && current.value != value) {
            find = current;
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            return false;
        }
        if (current.left == null && current.right == null) {
            if (current != root) {
                if (find.left == current) {
                    find.left = null;
                    size--;
                } else {
                    find.right = null;
                    size--;
                }
            } else {
                root = null;
            }
        } else if (current.left != null && current.right != null) {
            Node min = findMinNodeLeft(current.right);
            int minValue = min.value;
            remove(minValue);
            current.value = minValue;
        } else {
            Node last = (current.left != null) ? current.left : current.right;
            if (current != root) {
                if (current == find.left) {
                    find.left = last;
                } else {
                    find.right = last;
                }
            } else {
                root = last;
            }
            size--;
        }
        return true;
    }

    public static Node findMinNodeLeft(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Should return true if this tree contains specified value, false - otherwise
    public boolean contains(int value) {
        // TODO implement me
        Node current = this.root;
        int findValue = value;
        if (current.value == findValue) {
            return true;
        } else {
            while (current != null) {
                if (value < current.value) {
                    if (current.left == null) {
                        return false;
                    } else if (current.left.value == findValue) {
                        return true;
                    } else {
                        current = current.left;
                    }
                } else if (value > current.value) {
                    if (current.right == null) {
                        return false;
                    } else if (current.right.value == findValue) {
                        return true;
                    } else {
                        current = current.right;
                    }
                }
            }
            return false;
        }
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
