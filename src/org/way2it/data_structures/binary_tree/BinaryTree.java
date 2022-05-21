package org.way2it.data_structures.binary_tree;

public class BinaryTree {

    // Represents the first node of this tree
    // Should be initialized when first value is added
    private Node root;

    private int size = 0;

    public BinaryTree() {
    }

    // Should add new value to the tree according to binary tree rules:
    // Values that are less than or equal to the value in the current node, should be placed in the left subtree
    // Values that are greater than the value in the current node - should be placed in the right subtree
    public void add(int value) {
        Node newNode = new Node(); // создание нового узла
        newNode.value = value; // вставка данных
        if (root == null) { // если корневой узел не существует
            root = newNode;// то новый элемент и есть корневой узел
            size++;
        }
        else { // корневой узел занят
            Node currentNode = root; // начинаем с корневого узла
            Node parentNode;
            while (true) // мы имеем внутренний выход из цикла
            {
                parentNode = currentNode;
                if(value == currentNode.value) {   // если такой элемент в дереве уже есть, не сохраняем его
                    return;    // просто выходим из метода
                }
                else  if (value < currentNode.value) {   // движение влево?
                    currentNode = currentNode.left;
                    if (currentNode == null){ // если был достигнут конец цепочки,
                        parentNode.left = newNode; //  то вставить слева и выйти из методы
                        size++;
                        return;

                    }
                }
                else { // Или направо?
                    currentNode = currentNode.right;
                    if (currentNode == null) { // если был достигнут конец цепочки,
                        parentNode.right = newNode;  //то вставить справа
                        size++;
                        return; // и выйти
                    }
                }

            }

        }

    }

    // Should remove specified value from tree and return true
    // If value does not exist in this tree - return false
    public boolean remove(int value) {
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;
        while (currentNode.value != value) { // начинаем поиск узла
            parentNode = currentNode;
            if (value < currentNode.value) { // Определяем, нужно ли движение влево?
                isLeftChild = true;
                currentNode = currentNode.left;
            }
            else { // или движение вправо?
                isLeftChild = false;
                currentNode = currentNode.right;
            }
            if (currentNode == null)
                return false; // yзел не найден
        }

        if (currentNode.left == null && currentNode.right == null) { // узел просто удаляется, если не имеет потомков
            if (currentNode == root) // если узел - корень, то дерево очищается
            {root = null;
                size=0;}
            else if (isLeftChild)
                parentNode.left = null; // если нет - узел отсоединяется, от родителя
            else
                parentNode.right = null;
        }
        else if (currentNode.right == null) { // узел заменяется левым поддеревом, если правого потомка нет
            if (currentNode == root)
                root = currentNode.left;
            else if (isLeftChild)
                parentNode.left = (currentNode.left);
            else
                parentNode.right = (currentNode.left);
        }
        else if (currentNode.left == null) { // узел заменяется правым поддеревом, если левого потомка нет
            if (currentNode == root)
                root= currentNode.right;
            else if (isLeftChild)
                parentNode.left = (currentNode.right);
            else
                parentNode.right = (currentNode.right);
        }
        else { // если есть два потомка, узел заменяется преемником
            Node heir = receiveHeir(currentNode);// поиск преемника для удаляемого узла
            if (currentNode == root)
                root = heir;
            else if (isLeftChild)
                parentNode.left = (heir);
            else
                parentNode.right = heir;
        }
        size--;
        return true; // элемент успешно удалён
    }

    // Should return true if this tree contains specified value, false - otherwise
    public boolean contains(int value) {
        Node currentNode = root; // начинаем поиск с корневого узла
        while (currentNode.value != value)
        { // поиск покуда не будет найден элемент или не будут перебраны все
            if (value < currentNode.value) { // движение влево?
                currentNode = currentNode.left;
            } else { //движение вправо
                currentNode = currentNode.right;
            }
            if (currentNode == null) { // если потомка нет,
                return false; // возвращаем null
            }
        }
        if (currentNode != null) {
            return true;
        } // возвращаем найденный элемент
        return false;
    }
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.right; // Переход к правому потомку
        while (currentNode != null) // Пока остаются левые потомки
        {
            parentNode = heirNode;// потомка задаём как текущий узел
            heirNode = currentNode;
            currentNode = currentNode.left; // переход к левому потомку
        }
        // Если преемник не является
        if (heirNode != node.right) // правым потомком,
        { // создать связи между узлами
            parentNode.left = (heirNode.right);
            heirNode.right = (node.right);
        }
        return heirNode;// возвращаем приемника
    }


    public int getSize() {
        return size;
    }

    private static class Node {
        int value;
        Node left;
        Node right;
    }
}
