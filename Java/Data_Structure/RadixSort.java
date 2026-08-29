/**
 * Radix Sort — a non-comparative sorting algorithm for non-negative integers.
 * Sorts digit by digit (ones, tens, hundreds, ...) using stable counting sort per digit.
 */
public class RadixSort {

    /** Returns the largest value in the array (used to know how many digit passes are needed). */
    static int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    /**
     * Stable counting sort on the digit at place value exp (1 = ones, 10 = tens, ...).
     * Sorts arr by the digit (arr[i] / exp) % 10.
     */
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // sorted result for this digit pass
        int i;
        int count[] = new int[10]; // frequency of digits 0-9 (base 10)

        // Count occurrences of the current digit
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Convert counts to positions (cumulative sum)
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build output in reverse for stability (equal digits keep original order)
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy sorted output back into arr
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    /**
     * Sorts the array by running counting sort on each digit place, from least to most significant.
     */
    static void radixSort(int arr[], int n) {
        int m = getMax(arr, n);

        // exp = 1, 10, 100, ... until all digits of the max element are processed
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 30, 40, 10, 50, 20 };
        int n = arr.length;

        System.out.println("Elements of the array: ");
        printArray(arr, n);

        radixSort(arr, n);

        System.out.println("Elements of the sorted array: ");
        printArray(arr, n);
    }
}
