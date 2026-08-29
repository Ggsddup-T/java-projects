/**
 * Merge Sort — a divide-and-conquer sorting algorithm.
 * The array is split in half recursively until each piece has one element,
 * then adjacent sorted halves are merged back together.
 */
public class MergeSort {

    /**
     * Merges two sorted subarrays arr[l..m] and arr[m+1..r] into one sorted range.
     */
    void merge(int arr[], int l, int m, int r) {
        // Sizes of the left and right subarrays
        int n1 = m - l + 1;
        int n2 = r - m;

        // Temporary arrays to hold the two halves
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data into temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];

        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays back into arr[l..r]
        int i = 0, j = 0; // indices for L and R
        int k = l;        // index for the merged array

        // Compare elements from both halves and place the smaller one first
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from L (R is already exhausted)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements from R (L is already exhausted)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Recursively sorts arr[l..r] by splitting, sorting each half, then merging.
     */
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Avoid overflow: same as (l + r) / 2 but safer for large indices
            int m = l + (r - l) / 2;

            // Sort left and right halves, then merge them
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 30, 40, 10, 50, 20 };

        System.out.println("Elements of the array: ");
        printArray(arr);

        MergeSort obj = new MergeSort();
        obj.sort(arr, 0, arr.length - 1);

        System.out.println("Elements of the sorted array: ");
        printArray(arr);
    }
}
