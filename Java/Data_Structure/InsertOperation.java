/**
 * Insert Operation — inserts a value into a sorted array while keeping order.
 * Elements larger than the new value are shifted one position to the right.
 */
public class InsertOperation {

    /**
     * Inserts key into sorted arr[0..n-1], shifting larger elements right.
     * Returns the new size, or n if the array is full.
     */
    static int insert(int arr[], int n, int key, int capacity) {
        if (n >= capacity) {
            return n; // no room to insert
        }

        // Start from the last used index and shift elements right while they are > key
        int i = n - 1;
        while (i >= 0 && arr[i] > key) {
            arr[i + 1] = arr[i]; // move larger element one spot to the right
            i--;
        }

        // if(n >= capacity)

        //     return n;
        // int i;
        // for(i = n - 1; (i >= 0 && arr[i] > key); i--)
        //     arr[i + 1] = arr[i];
        // arr[i + 1] = key;
        // return (n + 1);

        // i + 1 is the correct position for key (after the last element <= key)
        arr[i + 1] = key;
        return n + 1;
    }

    public static void main(String[] args) {
        int arr[] = new int[20]; // fixed capacity; only first n slots are used
        arr[0] = 2;
        arr[1] = 16;
        arr[2] = 42;
        arr[3] = 57;
        arr[4] = 89;
        arr[5] = 97;

        int capacity = arr.length;
        int n = 6;       // number of elements currently in the array
        int key = 76;    // value to insert

        System.out.println("Elements of the array before insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        n = insert(arr, n, key, capacity);

        System.out.println("\nElements of the array after insertion: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
