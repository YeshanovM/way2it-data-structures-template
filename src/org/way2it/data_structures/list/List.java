package org.way2it.data_structures.list;

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
        valuesInc();
        values[length]=value;
        length++;
    }

    // Should add new value at the specified index, moving other values to the right,
    // increment length and extend array by x2 if needed
    public void addAtIndex(String value, int index) {
        // TODO implement me
        valuesInc();

        String[] temp = values;
        values = new String[temp.length];
        int k = 0;
        for (int i = 0; i<temp.length;i++){
            if (i == index){
                values[i]=value;
                i++;
            }
            values[i]=temp[k];
            k++;
        }

        length++;
    }

    private void valuesInc() {
        if (length == values.length) {
            String[] temp = values;
            int newLength = length * 2;
            values = new String[newLength];
            System.arraycopy(temp, 0, values, 0, temp.length);
        }
    }

    // Should return a value at specified index, or null if index is out of list bounds
    public String get(int index) {
        // TODO implement me
        if(index < values.length){
            return values[index];
        }
        else return null;
    }

    // Should return the index of the first occurrence of specified value in list
    // If the value does not exist - return -1
    public int indexOf(String value) {
        // TODO implement me
        int k=-1;
        for(int i = 0; i < values.length;i++){
            if (Objects.equals(values[i], value)){
                k=i;
            }
        }
        return k;
    }

    // Should remove the value at specified index, decrementing the length of this list and moving next values to the left
    public void remove(int index) {
        // TODO implement me
        String[] temp = values;
        values = new String[temp.length-1];
        int k = 0;
        for (int i = 0; i < values.length;i++){
            if (i == index){
                k++;
            }
            values[i]=temp[k];
            k++;
        }

        length--;
    }

    public int getLength() {
        return length;
    }
}