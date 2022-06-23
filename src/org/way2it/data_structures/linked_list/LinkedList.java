package org.way2it.data_structures.linked_list;
public class LinkedList {

    // Represents the first node of this list
    // Should be initialized when first value is added
    private Node head;

    // Represents the number of values that were added to this list
    private int length = 0;

    public LinkedList() {
    }

    // Should add new value to the end of the list and increment length
    public void add(String value) {
        // TODO implement me
        Node addNode = new Node();
        addNode.value = value;
        if (head == null) {
            head = addNode;
        } else {
            Node thisNode = head;
            while (thisNode.next != null) {
                thisNode = thisNode.next;
            }
            thisNode.next = addNode;
        }
        length++;
    }


    // Should add new value next to specified afterValue, increment length and return true
    // If afterValue is not present in list - do nothing and return false.
    public boolean addAfter(String value, String afterValue) {
        // TODO implement me
        boolean addAfter = false;
        Node addNode = new Node();
        addNode.value = value;
        Node thisNode = head;
        while (thisNode.next != null) {
            if (thisNode.value.equals(afterValue)) {
                addNode.next = addNode;
                thisNode.next = addNode;
                addAfter = true;
                length++;
            } else thisNode = thisNode.next;
        }
        return addAfter;
    }

    // Should return true if value exists in this list, false - otherwise
    public boolean contains(String value) {
        // TODO implement me
        boolean contains = false;
        if (head == null) contains = false;
        else {
            Node thisNode = head;
            if (thisNode.next == null) {
                contains = thisNode.value == value;
            } else {
                while (thisNode.next != null) {
                    if (thisNode.value.equals(value)) {
                        contains = true;
                        break;
                    }
                    thisNode = thisNode.next;
                }
            }
        }
        return contains;
    }

    // Should remove first occurrence of the specified value from this list and decrement the length
    // If value existed and was removed - return true, false - otherwise
    public boolean remove(String value) {
        // TODO implement me
        boolean remove = false;
        if (head == null) remove = false;
        else {
            Node thisNode = head;
            if (thisNode.next == null) {
                if (thisNode.value.equals(value)) {
                    thisNode = null;
                    length--;
                    remove = true;
                }
            } else {
                while (thisNode.next != null) {
                    if (thisNode.value.equals(value)) {
                        thisNode = thisNode.next;
                        length--;
                        remove = true;
                        break;
                    } else thisNode = thisNode.next;
                }
            }
        }
        return remove;
    }

    public int getLength() {
        return length;
    }

    private static class Node {
        String value;
        Node next;
    }
}
