package org.way2it.data_structures.list;

import java.util.ArrayList;
import java.util.Arrays;

public class List {

    // Represent values in this list
    private String[] values = new String[4];

    // Represent the number of values that were added to this list
    private int length = 0;

    public List() {
    }

    // Should add new value to the end of the list, increment length and extend array by x2 if needed
    public void add(String value) {
        // TODO implement me
        if (length < values.length) {
            values[length] = value;
            length++;
        } else {
            values = Arrays.copyOf(values, values.length * 2);
            values[length] = value;
            length++;
        }
    }

    // Should add new value at the specified index, moving other values to the right,
    // increment length and extend array by x2 if needed
    public void addAtIndex(String value, int index) {
        // TODO implement me
        if (length < values.length - 1) {
            for (int i = values.length - 1; i > index; i--) {
                values[i] = values[i - 1];
            }
            values[index] = value;
            length++;
        } else {
            values = Arrays.copyOf(values, values.length * 2);
            for (int i = values.length - 1; i > index; i--) {
                values[i] = values[i - 1];
            }
            values[index] = value;
            length++;
        }
    }

    // Should return a value at specified index, or null if index is out of list bounds
    public String get(int index) {
        // TODO implement me
        if (index <= length) return values[index];
        else return null;
    }

    // Should return the index of the first occurrence of specified value in list
    // If the value does not exist - return -1
    public int indexOf(String value) {
        // TODO implement me
        int indexOf = -1;
        for (int i = 0; i <= length; i++) {
            if (values[i] == value) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }

    // Should remove the value at specified index, decrementing the length of this list and moving next values to the left
    public void remove(int index) {
        // TODO implement me
        for (int i = index; i < length; i++) {
            values[i] = values[i + 1];
        }
        values = Arrays.copyOf(values, values.length - 1);
        length--;
    }

    public int getLength() {
        return length;
    }
}
