package org.way2it.data_structures.linked_list;

public class LinkedList<T> {

    // Represents the first node of this list
    // Should be initialized when first value is added
    private Node<T> head;
    // Represents the last node of this list
    private Node<T> tail;

    // Represents the number of values that were added to this list
    private int length = 0;

    public LinkedList() {
    }
    
    // Return true if List is empty and false if not
    public boolean isEmpty() {
        return head == null;
    }

    // Should add new value to the end of the list and increment length
    public void addToStart(T value) {
        // TODO implement me
        Node<T> newVal = new Node<>();
        newVal.value = value;
        if (isEmpty()) {
            head = newVal;
            tail = newVal;
        } else {
            newVal.next = head;
            head = newVal;

        }
        length++;
    }
    
    //This method insert new value to the end of Linked List and increment length
    public void addToEnd(T value) {
        Node<T> newVal = new Node<>();
        newVal.value = value;
        if (isEmpty()) {
            head = newVal;
            tail = newVal;
        } else {
            tail.next = newVal;
            tail = newVal;
        }
        length++;
    }

    // Should add new value next to specified afterValue, increment length and return true
    // If afterValue is not present in list - do nothing and return false.
    public boolean addAfter(T value, T afterValue) {
        // TODO implement me
        Node<T> current = head;
        Node<T> next;
        Node<T> newVal = new Node<>();
        newVal.value = value;
        if(isEmpty()) {
            return false;
        }
        else {
            while (current != null) {
                if(Objects.equals(current.value, afterValue)) {
                    next = current.next;
                    current.next = newVal;
                    newVal.next = next;
                    length++;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    
    //This method allow to insert new value at the selected index
    public void addByIndex(T value, int index) {
        if (isEmpty() | index == 0) {
            addToStart(value);
        }
        else if (index >= length) {
            addToEnd(value);
        }
        else {
            Node<T> current = head;
            Node<T> next;
            Node<T> indexVal = new Node<>();
            indexVal.value = value;
            int count = 0;
            while (current != null) {
                if(count == index - 1) {
                    next = current.next;
                    current.next = indexVal;
                    indexVal.next = next;
                    length++;
                    return;
                }
                else {
                    current = current.next;
                    count++;
                }
            }
        }
    }

    // Should return true if value exists in this list, false - otherwise
    public boolean contains(T value) {
        // TODO implement me
        if(isEmpty()){
            return false;
        }
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // This method can return the value of List by index
    public T get(int index) {
        if (isEmpty() | index >= length) {
            return null;
        }
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if(count == index) {
                return current.value;
            } else {
                current = current.next;
                count++;
            }
        }
        return null;
    }
    
    //This method return index of value in List
    public int getIndex(T value) {
        if (isEmpty()) {
            return -1;
        }
        Node<T> current = head;
        int count = 0;
        while (current != null) {
            if(current.value.equals(value)) {
                return count;
            }else {
                current = current.next;
                count++;
            }
        }
        return -1;
    }

    // Should remove first occurrence of the specified value from this list and decrement the length
    // If value existed and was removed - return true, false - otherwise
    public boolean remove(T value) {
        // TODO implement me
        if (isEmpty()) {
            return false;
        }
        if (head.value.equals(value)) {
            head = head.next;
            length--;
            return true;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.value.equals(value)) {
                current.next = current.next.next;
                length--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    //This method remove value in List by its index
    public void removeByIndex(int index) {
        remove(get(index));
    }

    public int getLength() {
        return length;
    }
    
    //This method print all List
    public void print() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < length; i++) {
            System.out.print(get(i) + ", ");
        }
    }

    private static class Node<T> {
        T value;
        Node<T> next;
    }
}
