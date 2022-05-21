package org.way2it.data_structures.list;

public class List {

    // Represent values in this list
    private String[] values = new String[4];

    // Represent the number of values that were added to this list
    private int length = 0;

    public List() {
    }

    // Should add new value to the end of the list, increment length and extend array by x2 if needed
    public void add(String value) {
        String[] tmp = new String[length + 1];
        for (int i = 0; i < length; i++) {
            tmp[i] = values[i];
        }
        tmp[length] = value;
        length++;
        values = tmp;
    }

    // Should add new value at the specified index, moving other values to the right,
    // increment length and extend array by x2 if needed
    public void addAtIndex(String value, int index) {
        String[] tmp = new String[length + 1];
        for (int i = 0; i < index; i++) {
            tmp[i] = values[i];
        }
        tmp[index] = value;
        for (int i = index + 1; i < length + 1; i++) {
            tmp[i] = values[i - 1];
        }
        values = tmp;
        length++;
    }

    // Should return a value at specified index, or null if index is out of list bounds
    public String get(int index) {
        if (index < getLength()) {
            return values[index];
        } else {
            return null;
        }
    }

    // Should return the index of the first occurrence of specified value in list
    // If the value does not exist - return -1
    public int indexOf(String value) {
        for (int i = 0; i < length; i++) {
            if (values[i] == value)
                return i;
        }
        return -1;
    }

    // Should remove the value at specified index, decrementing the length of this list and moving next values to the left
    public void remove(int index) {
        String[] tmp = new String[length - 1];
        for (int i = 0; i < index; i++) {
            tmp[i] = values[i];
        }
        for (int i = index; i < length-1; i++) {
            tmp[i] = values[i + 1];
        }
        values = tmp;
        length--;
    }

    public int getLength() {
        return length;
    }
}
