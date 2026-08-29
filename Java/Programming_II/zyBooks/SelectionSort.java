import java.util.Scanner;

public class SelectionSort {
   // Read and return an array of integers
   // The first integer read is number of integers that follow
   private static int[] readNums() {
      Scanner scnr = new Scanner(System.in);
      int size = scnr.nextInt();                // Read array size
      int[] numbers = new int[size];            // Create array
      for (int i = 0; i < size; ++i) {          // Read the numbers
         numbers[i] = scnr.nextInt();
      }
      return numbers;
   }

   // Print the numbers in the array, separated by spaces
   // (No space or newline before the first number or after the last)
   private static void printNums(int[] nums) {
      for (int i = 0; i < nums.length; ++i) {
         System.out.print(nums[i]);
         if (i < nums.length - 1) {
            System.out.print(" ");
         }
      }
      System.out.println();
   }

   // Exchange nums[j] and nums[k]
   private static void swap(int[] nums, int j, int k) {
      int temp = nums[j];
      nums[j] = nums[k];
      nums[k] = temp;
   }

   // Sort numbers
   // TODO: Count comparisons and swaps. Output the array at the end of each iteration
   public static int numComparisons = 0;
   public static int numSwaps = 0;

   public static void insertionSort(int[] numbers) {
      int i;
      int j;
      for (i = 1; i < numbers.length; ++i) {
         j = i;
         // Insert numbers[i] into sorted part,
         // stopping once numbers[i] is in correct position

         while (j > 0) {
            ++numComparisons;
            if (numbers[j] < numbers[j - 1]) {
               // Swap numbers[j] and nums[j - 1]
               swap(numbers, j, j - 1);
               ++numSwaps;
               --j;
            } else {
               break;
            }
         }
         printNums(numbers);
      }
   }

   public static void main(String[] args) {
      // Step 1: Read numbers into an array
      int[] numbers = readNums();
      // Step 2: Output the numbers array
      printNums(numbers);
      System.out.println();

      // Step 3: Sort the numbers array
      insertionSort(numbers);
      System.out.println();

      // step 4
      // TODO: Output the number of comparisons and swaps performed
      System.out.println("comparisons: " + numComparisons);
      System.out.println("swaps: " + numSwaps);
   }
}
