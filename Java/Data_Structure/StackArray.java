import java.util.*; // Import utilities (not strictly needed here, kept as-is).
public class StackArray { // Define a stack backed by an array.
    //Write your code here... // Original prompt comment preserved.

    protected int capacity; // Maximum number of elements allowed.
    public static final int CAPACITY = 16; // Default capacity if none provided.
    protected int[] stackArray; // Array that stores the stack elements.
    protected int top = -1; // Index of current top element (-1 means empty).

    public StackArray() { // Default constructor uses default capacity.
        this(CAPACITY); // Delegate to the capacity constructor.
    }

    public StackArray(int cap) { // Constructor that accepts custom capacity.
        capacity = cap; // Save the provided capacity.
        stackArray = new int[capacity]; // Allocate array with that capacity.
    }

    public int size() { // Return the number of elements in the stack.
        return top + 1; // Size is top index plus one.
    }

    public boolean isEmpty() { // Check if the stack has no elements.
        return top < 0; // Empty when top is -1.
    }

    public void push(int data) throws Exception { // Push a value onto the stack.
        if (size() == capacity) { // If stack is full, prevent overflow.
            throw new Exception("Stack is full."); // Signal overflow condition.
        }
        stackArray[++top] = data; // Increment top then store the new element.
    }

    public int top() throws Exception { // Return the top element without removing it.
        if (isEmpty()) { // If stack is empty, there is no top element.
            throw new Exception("Stack is empty."); // Signal underflow condition.
        }
        return stackArray[top]; // Return the element at the top index.
    }

    public int pop() throws Exception { // Remove and return the top element.
        int data; // Temporary variable for the popped value.
        if (isEmpty()) { // If stack is empty, cannot pop.
            throw new Exception("Stack is empty."); // Signal underflow condition.
        }
        data = stackArray[top]; // Store the top value for return.
        stackArray[top--] = Integer.MIN_VALUE; // Clear and decrement top.
        return data; // Return the popped value.
    }

    public static void main(String[] args) throws Exception { // Program entry point.
        StackArray myStack = new StackArray(5); // Create a stack of capacity 5.
        myStack.push(5); // Push 5 onto the stack.
        myStack.push(3); // Push 3 onto the stack.
        myStack.push(8); // Push 8 onto the stack.
        myStack.push(9); // Push 9 onto the stack.
        myStack.push(10); // Push 10 onto the stack.
        System.out.println("The topmost element of the stack is " + myStack.top()); // Print current top.
    }
}