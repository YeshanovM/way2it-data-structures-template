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
        int temp = 0;
        //int del;
        Node current = this.root;
        Node find = this.root;
        if (current.value == value) {
            while (find.right != null) {
                if (find.right == null) {
                    find = null;
                } else {
                    find = find.right;
                }
                temp = find.value;
            }
            root.value = temp;
            size--;
            return true;
        } else {
            while (current != null) {
                if (value < current.value) {
                    if (current.left == null) {
                        return false;
                    }
                    if (current.left.value == value) {


                        current.left.value = 0;
                        //root = current;
                        size--;
                        return true;
                    } else {
                        current = current.left;
                    }
                } else if (value > current.value) {
                    if (current.right == null) {
                        return false;
                    }
                    if (current.right.value == value) {
                        if (current.right.right == null && current.right.left == null) {
                            current.right = null;
                        } else {
                            while (find.right != null) {
                                if (find.right == null) {
                                    find = null;
                                } else {
                                    find = find.right;
                                }
                                temp = find.value;
                               if(find.right == null && find.left==null){
                                   find=null;
                                   size--;
                                   return true;
                               }
                            }
                            current.right.value = temp;

                        }
                        size--;
                        return true;

                    } else {
                        current = current.right;
                    }
                }
            }
            return false;
        }
    }

    // Should return true if this tree contains specified value, false - otherwise
    public boolean contains(int value) {
        // TODO implement me
        Node current = this.root;
        Node findNode = new Node();
        findNode.value = value;
        if (current.value == findNode.value) {
            return true;
        } else {
            while (current != null) {
                if (value < current.value) {
                    if (current.left == null) {
                        return false;
                    }
                    if (current.left.value == findNode.value) {
                        return true;
                    } else {
                        current = current.left;
                    }
                } else if (value > current.value) {
                    if (current.right == null) {
                        return false;
                    }
                    if (current.right.value == findNode.value) {
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
