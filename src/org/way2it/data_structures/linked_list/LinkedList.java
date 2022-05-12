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
        Node headNext = new Node();
        Node current = this.head;
        headNext.value = value;
        if (current == null) {
            head = headNext;
        } else {
            while (current != null) {
                if (current.next == null) {
                    current.next = headNext;
                    break;
                } else {
                    current = current.next;
                }
            }
        }
        length++;
    }

    // Should add new value next to specified afterValue, increment length and return true
    // If afterValue is not present in list - do nothing and return false.
    public boolean addAfter(String value, String afterValue) {
        // TODO implement me
        Node headNext = new Node();
        Node current = this.head;
        headNext.value = value;
        while (current != null) {
            if (current.value.equals(afterValue) ) {
                headNext.next = current.next;
                current.next = headNext;
                length++;
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    // Should return true if value exists in this list, false - otherwise
    public boolean contains(String value) {
        // TODO implement me
        Node current = this.head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    // Should remove first occurrence of the specified value from this list and decrement the length
    // If value existed and was removed - return true, false - otherwise
    public boolean remove(String value) {
        // TODO implement me
        Node current = this.head;
        Node nodeBefor = new Node();
        while (current != null) {
            if (current.value.equals(value)) {
                if (nodeBefor.value == null) {
                    this.head = current.next;
                    length--;
                    return true;
                }
                nodeBefor.next = current.next;
                length--;
                return true;
            } else {
                nodeBefor = current;
                current = current.next;
            }
        }
        return false;
    }

    public int getLength() {
        return length;
    }

    private static class Node {
        String value;
        Node next;
    }
}
