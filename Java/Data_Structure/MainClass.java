/**
 * Max Heap — a complete binary tree stored in an array.
 * Parent is always greater than (or equal to) its children.
 * Largest element is always at the root (index 0).
 *
 * Array layout for a node at index i:
 *   parent      = (i - 1) / 2
 *   left child  = 2 * i + 1
 *   right child = 2 * i + 2
 *
 * Example tree for [84, 19, 22, 5, 6, 17]:
 *           84
 *         /    \
 *       19      22
 *      /  \    /
 *     5    6  17
 */
class MaxHeap {
    private int[] Heap;  // array that stores all heap values
    private int size;    // how many values are currently in the heap
    private int maxsize; // maximum number of values the heap can hold

    // Constructor: create an empty heap that can hold up to maxsize elements
    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;           // save the capacity
        this.size = 0;                   // heap starts empty (0 elements)
        Heap = new int[this.maxsize];    // allocate the array with that capacity
    }

    // Given a node index, return its parent's index
    // Example: parent of index 3 is (3-1)/2 = 1
    private int parent(int pos) {
        return (pos - 1) / 2; // integer division drops the fraction
    }

    // Given a node index, return its left child's index
    // Example: left child of index 1 is 2*1+1 = 3
    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    // Given a node index, return its right child's index
    // Example: right child of index 1 is 2*1+2 = 4
    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    // Check if the node at pos has no children (it is a leaf)
    // Leaves are in the second half of the used part of the array
    private boolean isLeaf(int pos) {
        // pos is past the last parent index, and still within the heap
        if (pos > (size / 2) && pos <= size) {
            return true;  // no children — it is a leaf
        }
        return false;     // has at least one child — not a leaf
    }

    // Exchange the values at two positions in the array
    private void swap(int fpos, int spos) {
        int tmp;              // temporary variable to hold one value during the swap
        tmp = Heap[fpos];     // save the first value
        Heap[fpos] = Heap[spos]; // put the second value into the first position
        Heap[spos] = tmp;     // put the saved first value into the second position
    }

    // Fix the max-heap property starting at pos (push a small value down)
    // Used when a parent is smaller than one of its children
    private void maxHeapify(int pos) {
        // If this node is a leaf, nothing to fix — stop
        if (isLeaf(pos))
            return;

        // If parent is smaller than left child OR smaller than right child
        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
            // Left child is larger than right child — swap with left
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));       // move larger left child up
                maxHeapify(leftChild(pos));      // continue fixing down the left path
            }
            // Right child is larger (or equal) — swap with right
            else {
                swap(pos, rightChild(pos));      // move larger right child up
                maxHeapify(rightChild(pos));     // continue fixing down the right path
            }
        }
        // If parent is already larger than both children, do nothing
    }

    // Add a new element to the heap and restore the max-heap property
    // Steps: place at end → bubble up while larger than parent → increase size
    //
    // Example: insert 84 into heap [17, 5]
    //   Heap[size] = 84        → [17, 5, 84]
    //   84 > parent 17         → swap → [84, 5, 17]
    //   size becomes 3
    public void insert(int element) {
        Heap[size] = element; // put the new value at the next free slot (end of heap)
        int current = size;   // start bubbling from this new position

        // Keep going while the current value is larger than its parent
        // (root's parent is itself at index 0, so the loop stops at the root)
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current)); // swap current with its parent
            current = parent(current);      // move up to the parent's index
        }

        size++; // heap now has one more element
    }

    // Print each parent and its children (if they exist)
    // Only visits parent nodes: indices 0, 1, 2, ... up to size/2 - 1
    public void print() {
        // Loop over every parent node
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent node: " + Heap[i]); // print the parent value

            // Print left child only if that index is still inside the heap
            if (leftChild(i) < size)
                System.out.print(", Left child node: " + Heap[leftChild(i)]);

            // Print right child only if that index is still inside the heap
            if (rightChild(i) < size)
                System.out.print(", Right child node: " + Heap[rightChild(i)]);

            System.out.println(); // move to the next line after each parent
        }
    }
}

// Demo program: build a max heap and print its parent/child structure
public class MainClass {
    // Program entry point
    public static void main(String[] arg) {
        MaxHeap maxHeap = new MaxHeap(15); // create a heap that can hold up to 15 values

        maxHeap.insert(5);  // heap: [5]
        maxHeap.insert(17); // heap: [17, 5]          (17 bubbles above 5)
        maxHeap.insert(84); // heap: [84, 5, 17]      (84 bubbles to root)
        maxHeap.insert(19); // heap: [84, 19, 17, 5]
        maxHeap.insert(6);  // heap: [84, 19, 17, 5, 6]
        maxHeap.insert(22); // heap: [84, 19, 22, 5, 6, 17]

        System.out.println("Nodes of the max heap:"); // label for the output
        maxHeap.print(); // print each parent with its left and right children
    }
}
