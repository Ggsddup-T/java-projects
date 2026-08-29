/**
 * Heap Sort — sorts an array using a max heap.
 *
 * Two main phases:
 *   1. Build a max heap from the array (largest value at index 0).
 *   2. Repeatedly swap the root (max) with the last unsorted element,
 *      then fix the heap for the remaining unsorted part.
 *
 * Array as a binary tree (for index i):
 *   left child  = 2 * i + 1
 *   right child = 2 * i + 2
 *   parent      = (i - 1) / 2
 *
 * Example input:  [12, 11, 13, 5, 6, 7]
 * Final output:   [5, 6, 7, 11, 12, 13]
 */
public class HeapSort {

    /**
     * Sorts arr in ascending order using heap sort.
     *
     * Phase 1 — Build max heap:
     *   Start from the last parent (n/2 - 1) and heapify each parent upward to the root.
     *
     * Phase 2 — Extract max one by one:
     *   Swap root with the last element, shrink the heap, heapify the new root.
     *   After each step, the end of the array holds the next largest value.
     */
    public void sort(int arr[]) {
        int n = arr.length; // number of elements in the array

        // ----- Phase 1: Build a max heap -----
        // Last parent index is n/2 - 1 (leaves need no heapify)
        // Example for n = 6: last parent index = 6/2 - 1 = 2
        // We heapify indices 2, then 1, then 0
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i); // make subtree rooted at i a max heap

        // After Phase 1, example array becomes a max heap, e.g.:
        // [13, 11, 12, 5, 6, 7]  (13 is the largest, at the root)

        // ----- Phase 2: One by one move max to the end -----
        // i is the last index of the current unsorted (heap) region
        for (int i = n - 1; i > 0; i--) {
            // Swap root (largest) with the element at index i
            int temp = arr[0]; // save the maximum (root)
            arr[0] = arr[i];   // move last heap element to the root
            arr[i] = temp;     // place maximum at the end (sorted position)

            // Heap size is now i (indices 0..i-1). Fix the root.
            // Example first pass (i = 5):
            //   before swap: [13, 11, 12, 5, 6, 7]
            //   after swap:  [7, 11, 12, 5, 6, 13]  ← 13 is sorted
            //   after heapify(arr, 5, 0): [12, 11, 7, 5, 6, 13]
            heapify(arr, i, 0);
        }
        // When the loop ends, arr is fully sorted ascending
    }

    /**
     * Ensures the subtree rooted at index i is a max heap.
     *
     * Parameters:
     *   arr — the full array
     *   n   — current heap size (only indices 0..n-1 are part of the heap)
     *   i   — root index of the subtree to fix
     *
     * Steps:
     *   1. Assume i holds the largest value among i, left child, right child.
     *   2. If left child is larger, update largest.
     *   3. If right child is larger, update largest.
     *   4. If largest is not i, swap and recurse on the affected child.
     *
     * Example: heapify([7, 11, 12, 5, 6], n=5, i=0)
     *   i=0 value 7, left=11, right=12
     *   largest becomes 2 (value 12)
     *   swap arr[0] and arr[2] → [12, 11, 7, 5, 6]
     *   recurse heapify on index 2 (value 7 has no children in range) → done
     */
    void heapify(int arr[], int n, int i) {
        int largest = i;     // assume current node i is the largest so far
        int l = 2 * i + 1;   // left child index of i
        int r = 2 * i + 2;   // right child index of i

        // If left child exists (l < n) and is greater than current largest, update
        // Example: i=0, l=1, arr[1]=11, arr[0]=7 → largest becomes 1
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child exists (r < n) and is greater than current largest, update
        // Example: i=0, r=2, arr[2]=12, arr[largest]=11 → largest becomes 2
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If a child was larger, swap and continue fixing down that path
        if (largest != i) {
            int swap = arr[i];       // save parent value
            arr[i] = arr[largest];   // move larger child up into parent position
            arr[largest] = swap;     // move parent down into child's position

            // The value we moved down might still be smaller than its new children
            heapify(arr, n, largest); // fix the subtree where the value landed
        }
        // If largest == i, the subtree is already a max heap — nothing to do
    }

    // Print all elements of the array on one line, separated by spaces
    static void printArray(int arr[]) {
        int n = arr.length; // length of the array
        for (int i = 0; i < n; ++i) // visit every index from 0 to n-1
            System.out.print(arr[i] + " "); // print value and a space
        System.out.println(); // move to the next line after printing all values
    }

    // Program entry point — demonstrates heap sort on a sample array
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 }; // unsorted input
        int n = arr.length;                  // n = 6 (not used further, kept for clarity)

        HeapSort obj = new HeapSort(); // create a HeapSort object to call sort()

        System.out.println("Elements of the array: ");
        printArray(arr); // print: 12 11 13 5 6 7

        obj.sort(arr); // sort the array in place using heap sort

        System.out.println("Elements of the array after sorting: ");
        printArray(arr); // print: 5 6 7 11 12 13
    }
}
