package Datastructures;
import util.Node;
public class BinaryTree
{
    // first node
    private Node root;
    BinaryTree()
    {
        root = null;
    }
    // Class representing tree nodes

    public void insert(int i)
    {
        root = insert(root, i);
    }
    //Inserting node - recursive method
    public Node insert(Node node, int value)
    {
        if(node == null){
            return new Node(value);
        }
        // Move to the left if passed value is
        // less than the current node
        if(value < node.getValue())
        {
            node.setLeft(insert(node.getLeft(), value));
        }
        // Move to the right if passed value is
        // greater than the current node
        else if(value > node.getValue())
        {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }
    // Search node in binary search tree
    public Node find(int searchedValue)
    {
        Node current = root;
        while(current.getValue() != searchedValue)
        {
            if(searchedValue < current.getValue())
                // Move to the left if searched value is less
                current = current.getLeft();
            else
                // Move to the right if searched value is >=
                current = current.getRight();
            if(current == null)
            {
                return null;
            }
        }
        return current;
    }
    // For traversing in order
    public void inOrder(Node node)
    {
        if(node != null)
        {
            inOrder(node.getLeft());
            node.displayData();
            inOrder(node.getRight());
        }
    }
    // Preorder traversal
    public void preOrder(Node node)
    {
        if(node != null){
            node.displayData();
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    // Postorder traversal
    public void postOrder(Node node)
    {
        if(node != null)
        {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            node.displayData();
        }
    }
    public static void main(String[] args)
    {
        BinaryTree bst = new BinaryTree();
        bst.insert(34);
        bst.insert(56);
        bst.insert(12);
        bst.insert(89);
        bst.insert(67);
        bst.insert(90);
        System.out.println("Inorder traversal of binary tree");
        bst.inOrder(bst.root);
        System.out.println();
        System.out.println("Preorder traversal of binary tree");
        bst.preOrder(bst.root);
        System.out.println();
        System.out.println("Postorder traversal of binary tree");
        bst.postOrder(bst.root);
        System.out.println();
    }
}