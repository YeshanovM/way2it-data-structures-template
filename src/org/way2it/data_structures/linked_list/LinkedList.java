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
        Node newNode = new Node();
        if(head==null){
            head=new Node();
            head.value=value;
            head.next=null;
        }else{
            Node p=head;
            Node node=new Node();
            node.value = value;
            node.next=null;
            while(p.next!=null){
                p=p.next;
            }
            p.next=node;
            node.next=null;
        }

        length++;

    }
    // Should add new value next to specified afterValue, increment length and return true
    // If afterValue is not present in list - do nothing and return false.
    public boolean addAfter(String value, String afterValue) {
        if(!contains(value)&&contains(afterValue)){
            Node node = new Node();
            node.next = getNode(afterValue).next;
            getNode(afterValue).next = node;
            node.value=value;
            length++;
            return true;
        }
        else {return false;}

    }

    // Should return true if value exists in this list, false - otherwise
    public boolean contains(String value) {

        Node p;
        for(p=head;p!=null;p=p.next){
            if(p.value.equals(value)){
                return true;
            }
        }
        return false;
    }

    // Should remove first occurrence of the specified value from this list and decrement the length
    // If value existed and was removed - return true, false - otherwise
    public boolean remove(String value) {
        Node p = head, p1 = null;
        boolean have = false;
        if (head == null) {
            return false;
        }
        while (p != null) {
            if (p.value.equals(value)) {
                if (p1 == null) {
                    head = head.next;
                } else {
                    p1.next = p.next;
                }
                have = true;
                length--;
            }
            p1 = p;
            p = p.next;
        }

        return have;

    }
    public Node  getNode(String str) {
        int i=-1;
        if(head==null){
            return null;
        }
        Node p=head;
        while(p!=null){
            if(p.value==str){
                return p;
            }
            p=p.next;
        }
        return null;
    }



    public int getLength() {
        return length;
    }

    private static class Node {
        String value;
        Node next;
    }
}
