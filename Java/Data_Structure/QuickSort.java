/**
 * Quick Sort — a divide-and-conquer sorting algorithm.
 * A pivot is chosen, elements are partitioned around it, then each side is sorted recursively.
 */
public class QuickSort {

    /** Swaps two elements in the array. */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Partitions arr[low..high] around a pivot (last element).
     * Returns the final index of the pivot so left side <= pivot and right side > pivot.
     */
    static int partition(int[] arr, int low, int high) {
        // Choose the last element as the pivot
        int pivot = arr[high];

        // i tracks the boundary of elements smaller than the pivot
        int i = (low - 1);

        // Scan from low to high - 1 (exclude the pivot itself)
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // move smaller element into the left region
            }
        }

        // Place pivot in its correct sorted position
        swap(arr, i + 1, high);

        return (i + 1); // pivot index
    }

    /**
     * Recursively sorts arr[low..high] by partitioning, then sorting left and right parts.
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition and get pivot index
            int pi = partition(arr, low, high);

            // Sort elements before and after the pivot (pivot is already in place)
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        // Base case: low >= high — 0 or 1 element, already sorted
    }

    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 30, 40, 10, 50, 20 };
        int n = arr.length;

        System.out.println("Elements of the array: ");
        printArray(arr, n);

        quickSort(arr, 0, n - 1);

        System.out.println("Elements of the sorted array: ");
        printArray(arr, n);
    }
}
