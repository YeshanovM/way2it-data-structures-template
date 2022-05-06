package List;

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
        if (length == values.length) {
            String[] temp = values;
            this.values = new String[values.length+1];
            System.arraycopy(temp,0,values, 0, temp.length);
        }
        values[length] = value;
        length++;
    }

    // Should add new value at the specified index, moving other values to the right,
    // increment length and extend array by x2 if needed
    public void addAtIndex(String value, int index) {
        // TODO implement me
        if (length == values.length) {
            String[] temp = values;
            this.values = new String[values.length+1];
            System.arraycopy(temp,0,values, 0, temp.length);
        }
        for (int i = values.length-2; i >= index; i--) {
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
        int index = 0;
        for (String x : values) {
            if (Objects.equals(value, x)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    // Should remove the value at specified index, decrementing the length of this list and moving next values to the left
    public void remove(int index) {
        // TODO implement me
        for (int i = index; i < values.length-1; i++) {
            values[i] = values[i+1];
        }
        String[] temp = values;
        this.values = new String[values.length-1];
        System.arraycopy(temp,0,values, 0, values.length);
        length--;
    }

    public int getLength() {
        return length;
    }
}
