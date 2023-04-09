package Datastructures;

import java.util.Arrays;

public class Stack {
    private Integer[] array; // Container for Stack elements
    private int top; // Index of top element

    // Constructor for creating stack of given capacity
    public Stack(int capacity) {
        array = new Integer[capacity];
        top = -1;
    }

    // Method for adding a new element to top of stack
    public void push(int obj) throws Exception {
        if (size() == array.length) {
            throw new Exception("Stack is full!");
        }
        top++; // Advance to next cell
        array[top] = obj; // Add new element
    }

    // Method for removing element from top of stack
    public int pop() throws Exception { //O(1)
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        int toReturn = array[top]; // Element to return
        array[top] = null; // Replace it with null
        top--; // Update top to point to new top
        return toReturn;
    }

    // Method for getting top element without removing it
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return array[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }


    public Stack sort() throws Exception {
        Stack tmpStack = new Stack(this.size()); //create temp stack  0(1)
        while (!this.isEmpty()) //while the stack isn't empty N * (O(1) + (N * O(1)) + O(1)) +O(1)
        {
            // pop out the first element
            int tmp = this.pop(); //O(1)

            // while a temporary stack is not empty and
            // top of stack is greater than temp.
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) //N * O(1)
            {
                // pop from a temporary stack and
                // push it to the input stack.
                this.push(tmpStack.pop());
            }

            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

    public String stackToString() {
        return Arrays.toString(array);
    }
}

