package Datastructures;

import util.Node;

public class BinaryTree {
    // first node
    private Node root;

    public BinaryTree() {
        root = null;
    }
    // Class representing tree nodes

    public void insert(int i) {
        root = insert(root, i);
    }

    //Inserting node - recursive method
    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        // Move to the left if passed value is
        // less than the current node
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        }
        // Move to the right if passed value is
        // greater than the current node
        else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }

    // Search node in binary search tree
    public Object search(int searchedValue) // O(N)
    {
        Node current = root;
        while (current.getValue() != searchedValue) // N * O(1)
        {
            if (searchedValue < current.getValue()) {
                // Move to the left if searched value is less
                current = current.getLeft();
            } else {
                // Move to the right if searched value is >=
                current = current.getRight();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }


    // For traversing in order
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            node.displayData();
            inOrder(node.getRight());
        }
    }

    // Preorder traversal
    public void preOrder(Node node) {
        if (node != null) {
            node.displayData();
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    // Postorder traversal
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            node.displayData();
        }
    }

    public Node getRoot() {
        return this.root;
    }
}