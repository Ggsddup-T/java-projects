import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      int NUM_VALS = 0;
      int lowBound;
      int upperBound;
      int i;

      NUM_VALS = scnr.nextInt();
       int[] intArray = new int[NUM_VALS];

      for (i = 0; i < NUM_VALS; ++i) {
         intArray[i] = scnr.nextInt();
      }

      lowBound = scnr.nextInt();
      upperBound = scnr.nextInt();

      for (int numVal: intArray) {
         if (numVal >= lowBound && numVal <= upperBound) {
            System.out.print(numVal + ",");
         }
      }
      System.out.println("");
   }
}
