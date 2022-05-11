package org.way2it.data_structures.linked_list;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add("Audi");

        System.out.println("Verifications after adding Audi to the list: ");
        verifyLength(1, linkedList.getLength());
        verifyContains("Audi", true, linkedList.contains("Audi"));
        System.out.println();

        linkedList.add("Toyota");
        linkedList.add("Volkswagen");
        linkedList.add("BMW");

        System.out.println("Verifications after adding Toyota, Volkswagen and BMW to the list: ");
        verifyLength(4, linkedList.getLength());
        verifyContains("Audi", true, linkedList.contains("Audi"));
        verifyContains("Toyota", true, linkedList.contains("Toyota"));
        verifyContains("Volkswagen", true, linkedList.contains("Volkswagen"));
        verifyContains("BMW", true, linkedList.contains("BMW"));
        System.out.println();

        boolean addedMercedes = linkedList.addAfter("Mercedes", "Toyota");

        System.out.println("Verifications after adding Mercedes after Toyota: ");
        verifyAdded(true, addedMercedes);
        verifyLength(5, linkedList.getLength());
        verifyContains("Audi", true, linkedList.contains("Audi"));
        verifyContains("Toyota", true, linkedList.contains("Toyota"));
        verifyContains("Mercedes", true, linkedList.contains("Mercedes"));
        verifyContains("Volkswagen", true, linkedList.contains("Volkswagen"));
        verifyContains("BMW", true, linkedList.contains("BMW"));
        System.out.println();

        boolean addedMazda = linkedList.addAfter("Mazda", "Honda");

        System.out.println("Verifications after a try to add Mazda after Honda: ");
        verifyAdded(false, addedMazda);
        verifyLength(5, linkedList.getLength());
        verifyContains("Audi", true, linkedList.contains("Audi"));
        verifyContains("Toyota", true, linkedList.contains("Toyota"));
        verifyContains("Mercedes", true, linkedList.contains("Mercedes"));
        verifyContains("Volkswagen", true, linkedList.contains("Volkswagen"));
        verifyContains("BMW", true, linkedList.contains("BMW"));
        verifyContains("Mazda", false, linkedList.contains("Mazda"));
        verifyContains("Honda", false, linkedList.contains("Honda"));
        System.out.println();

        boolean removedMazda = linkedList.remove("Mazda");

        System.out.println("Verifications after a try to remove Mazda: ");
        verifyRemoved(false, removedMazda);
        verifyLength(5, linkedList.getLength());
        verifyContains("Audi", true, linkedList.contains("Audi"));
        verifyContains("Toyota", true, linkedList.contains("Toyota"));
        verifyContains("Mercedes", true, linkedList.contains("Mercedes"));
        verifyContains("Volkswagen", true, linkedList.contains("Volkswagen"));
        verifyContains("BMW", true, linkedList.contains("BMW"));
        verifyContains("Mazda", false, linkedList.contains("Mazda"));
        System.out.println();

        boolean removedVolkswagen = linkedList.remove("Volkswagen");

        System.out.println("Verifications after removing value (Volkswagen) from the middle of the list: ");
        verifyRemoved(true, removedVolkswagen);
        verifyLength(4, linkedList.getLength());
        verifyContains("Audi", true, linkedList.contains("Audi"));
        verifyContains("Toyota", true, linkedList.contains("Toyota"));
        verifyContains("Mercedes", true, linkedList.contains("Mercedes"));
        verifyContains("Volkswagen", false, linkedList.contains("Volkswagen"));
        verifyContains("BMW", true, linkedList.contains("BMW"));
        System.out.println();

        boolean removedAudi = linkedList.remove("Audi");

        System.out.println("Verifications after removing value (Audi) from the head of the list: ");
        verifyRemoved(true, removedAudi);
        verifyLength(3, linkedList.getLength());
        verifyContains("Audi", false, linkedList.contains("Audi"));
        verifyContains("Toyota", true, linkedList.contains("Toyota"));
        verifyContains("Mercedes", true, linkedList.contains("Mercedes"));
        verifyContains("BMW", true, linkedList.contains("BMW"));
        System.out.println();

        boolean removedBmw = linkedList.remove("BMW");

        System.out.println("Verifications after removing value (BMW) from the end of the list: ");
        verifyRemoved(true, removedBmw);
        verifyLength(2, linkedList.getLength());
        verifyContains("Toyota", true, linkedList.contains("Toyota"));
        verifyContains("Mercedes", true, linkedList.contains("Mercedes"));
        verifyContains("BMW", false, linkedList.contains("BMW"));
        System.out.println();
    }

    private static void verifyLength(int expected, int actual) {
        System.out.print("\t");
        if (expected != actual) {
            System.out.printf("Error! Length of list should be equal to %s, your value is %s\n", expected, actual);
        } else {
            System.out.println("OK");
        }
    }

    private static void verifyContains(String value, boolean expected, boolean actual) {
        System.out.print("\t");
        if (expected != actual) {
            String expectedString = expected ? "" : " not";
            String actualString = actual ? "" : " not";
            System.out.printf("Error! Expected value %s is%s present in the list, but actually it is%s\n", value, expectedString, actualString);
        } else {
            System.out.println("OK");
        }
    }

    private static void verifyAdded(boolean expected, boolean actual) {
        System.out.print("\t");
        if (expected != actual) {
            System.out.printf("Error! Expected addAfter() returns %s, actual result: %s\n", expected, actual);
        } else {
            System.out.println("OK");
        }
    }

    private static void verifyRemoved(boolean expected, boolean actual) {
        System.out.print("\t");
        if (expected != actual) {
            System.out.printf("Error! Expected remove() returns %s, actual result: %s\n", expected, actual);
        } else {
            System.out.println("OK");
        }
    }
}
