package org.way2it.data_structures.binary_tree;

public class BinaryTreeTest {

    public static void main(String[] args) {
        checkSimpleOperations();
        checkAlgorithmPerformance();
        checkRemoving();
    }

    private static void checkSimpleOperations() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(5);

        System.out.println("Verifications after adding 5 to this tree:");
        verifySize(binaryTree, 1);
        verifyContains(binaryTree, 5, true);
        System.out.println();

        binaryTree.add(3);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(6);
        binaryTree.add(7);
        binaryTree.add(12);

        System.out.println("Verifications after adding 3, 1, 4, 8, 6, 7, 12 to this tree:");
        verifySize(binaryTree, 8);
        verifyContains(binaryTree, 1, true);
        verifyContains(binaryTree, 3, true);
        verifyContains(binaryTree, 4, true);
        verifyContains(binaryTree, 5, true);
        verifyContains(binaryTree, 6, true);
        verifyContains(binaryTree, 7, true);
        verifyContains(binaryTree, 8, true);
        verifyContains(binaryTree, 12, true);
        System.out.println();
    }

    private static void checkAlgorithmPerformance() {
        System.out.println("Checking performance...");

        BinaryTree binaryTree = new BinaryTree();
        int min = 0;
        int max = 10_000;
        addRange(binaryTree, min, max);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            binaryTree.contains(i);
        }
        long elapsedMillis = System.currentTimeMillis() - startTime;
        double elapsedSeconds = elapsedMillis / 1000.;

        if (elapsedSeconds > 1.5) {
            System.out.println("Warning! Your algorithm is too slow, expected elapsing time less than 1.5s" +
                    ", your time is " + elapsedSeconds + "s." +
                    " Check if binary tree is built correctly.\n");
        } else {
            System.out.println("OK! Your algorithm performs good, elapsed time: " + elapsedSeconds + "s.\n");
        }
    }

    private static void checkRemoving() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(6);
        binaryTree.add(7);
        binaryTree.add(12);

        System.out.println("Added 5, 3, 1, 4, 8, 6, 7, 12 to the tree. Now it should look like:");
        System.out.println("       5");
        System.out.println("     /   \\");
        System.out.println("    /     \\");
        System.out.println("   3       8");
        System.out.println("  / \\     / \\");
        System.out.println(" 1   4   6  12");
        System.out.println("          \\");
        System.out.println("           7");
        System.out.println();

        boolean removed25 = binaryTree.remove(25);

        System.out.println("Verifications after removing not existing value 25:");
        verifySize(binaryTree, 8);
        verifyRemoved(25, false, removed25);
        verifyContains(binaryTree, 1, true);
        verifyContains(binaryTree, 3, true);
        verifyContains(binaryTree, 4, true);
        verifyContains(binaryTree, 5, true);
        verifyContains(binaryTree, 6, true);
        verifyContains(binaryTree, 7, true);
        verifyContains(binaryTree, 8, true);
        verifyContains(binaryTree, 12, true);
        System.out.println();

        boolean removed7 = binaryTree.remove(7);

        System.out.println("Verifications after removing value 7:");
        verifySize(binaryTree, 7);
        verifyRemoved(7, true, removed7);
        verifyContains(binaryTree, 1, true);
        verifyContains(binaryTree, 3, true);
        verifyContains(binaryTree, 4, true);
        verifyContains(binaryTree, 5, true);
        verifyContains(binaryTree, 6, true);
        verifyContains(binaryTree, 7, false);
        verifyContains(binaryTree, 8, true);
        verifyContains(binaryTree, 12, true);
        System.out.println();

        boolean removed8 = binaryTree.remove(8);

        System.out.println("Verifications after removing value 8:");
        verifySize(binaryTree, 6);
        verifyRemoved(8, true, removed8);
        verifyContains(binaryTree, 1, true);
        verifyContains(binaryTree, 3, true);
        verifyContains(binaryTree, 4, true);
        verifyContains(binaryTree, 5, true);
        verifyContains(binaryTree, 6, true);
        verifyContains(binaryTree, 7, false);
        verifyContains(binaryTree, 8, false);
        verifyContains(binaryTree, 12, true);
        System.out.println();

        boolean removed5 = binaryTree.remove(5);

        System.out.println("Verifications after removing value 5:");
        verifySize(binaryTree, 5);
        verifyRemoved(5, true, removed5);
        verifyContains(binaryTree, 1, true);
        verifyContains(binaryTree, 3, true);
        verifyContains(binaryTree, 4, true);
        verifyContains(binaryTree, 5, false);
        verifyContains(binaryTree, 6, true);
        verifyContains(binaryTree, 7, false);
        verifyContains(binaryTree, 8, false);
        verifyContains(binaryTree, 12, true);
        System.out.println();
    }

    private static void addRange(BinaryTree binaryTree, int min, int max) {
        if (min == max) {
            binaryTree.add(min);
            return;
        }

        if (min == max - 1) {
            binaryTree.add(min);
            binaryTree.add(max);
            return;
        }

        int middle = (max + min) / 2;
        binaryTree.add(middle);

        addRange(binaryTree, min, middle - 1);
        addRange(binaryTree, middle + 1, max);
    }

    private static void verifySize(BinaryTree binaryTree, int expectedSize) {
        int actualSize = binaryTree.getSize();
        System.out.print("\t");
        if (expectedSize != actualSize) {
            System.out.printf("Error! Size of tree should be %s, your value is %s\n", expectedSize, actualSize);
        } else {
            System.out.println("OK");
        }
    }

    private static void verifyContains(BinaryTree binaryTree, int value, boolean expected) {
        boolean actual = binaryTree.contains(value);
        System.out.print("\t");
        if (expected != actual) {
            String expectedString = expected ? "" : " not";
            String actualString = actual ? "" : " not";
            System.out.printf("Error! Expected value %s is%s present in the tree, but actually it is%s\n", value, expectedString, actualString);
        } else {
            System.out.println("OK");
        }
    }

    private static void verifyRemoved(int value, boolean expected, boolean actual) {
        System.out.print("\t");
        if (expected != actual) {
            String expectedString = expected ? "" : " not";
            String actualString = actual ? "" : " not";
            System.out.printf("Error! Expected value %s%s removed from the tree, but actually it was%s\n", value, expectedString, actualString);
        } else {
            System.out.println("OK");
        }
    }
}
