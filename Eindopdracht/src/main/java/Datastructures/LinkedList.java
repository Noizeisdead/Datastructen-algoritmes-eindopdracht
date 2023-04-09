package Datastructures;

import util.Node;

public class LinkedList {

    Node head; // head of list

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
        public int getData()
        {
            return data;
        }

        public void setData(int d)
        {
            data = d;
        }

        public Node getNext()
        {
            return next;
        }
    }
    public LinkedList() {
        this.head = null;
    }

    public String toString(){
        String retStr = "Contents:\n";

        Node current = head;
        while(current != null){
            retStr += current.getData() + "\n";
            current = current.getNext();

        }

        return retStr;
    }
    // Method to insert a new node
    public void insert(int data) {
        // Create a new node with given data
        Node new_node = new Node(data);


        // If the Linked List is empty,
        // then make the new node as head
        if (this.head == null) {
            this.head = new_node;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    public void bubbleSort() {
        Node current = null, index = null;
        int temp;
        //Check whether list is empty
        if (head == null) {
            return;
        } else {
            //Current will point to head
            for (current = head; current.next != null; current = current.next) {
                //Index will point to node next to current
                for (index = current.next; index != null; index = index.next) {
                    //If current's data is greater than index's data, swap the data of current and index
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                }
            }
        }
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}