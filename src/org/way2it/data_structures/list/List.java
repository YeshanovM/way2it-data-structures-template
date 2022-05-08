package list;

import java.util.Objects;

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
        if (length == values.length) this.values = grow();
        values[length] = value;
        length++;
    }
    
    public String[] grow() {
        return values = Arrays.copyOf(values, values.length * 2);
    }

    // Should add new value at the specified index, moving other values to the right,
    // increment length and extend array by x2 if needed
    public void addAtIndex(String value, int index) {
        // TODO implement me
        if (length == values.length) this.values = grow();
        for (int i = length - 1; i >= index; i--) {
            values[i+1] = values[i];
        }
        values[index] = value;
        length++;
    }

    // Should return a value at specified index, or null if index is out of list bounds
    public String get(int index) {
        // TODO implement me
        return values[index];
    }

    // Should return the index of the first occurrence of specified value in list
    // If the value does not exist - return -1
    public int indexOf(String value) {
        // TODO implement me
        for (int index = 0; index < length; index++) {
            if (Objects.equals(value, values[index])) {
                return index;
            }
        }
        return -1;
    }

    // Should remove the value at specified index, decrementing the length of this list and moving next values to the left
    public void remove(int index) {
        // TODO implement me
        if (index < length) {
            for (int i = index; i < length; i++) {
                values[i] = values[i+1];
            }
            length--;
        }
    }

    public int getLength() {
        return length;
    }
}
