import java.util.Scanner; // Import Scanner for reading input

public class Fibonacci { // Class definition
    public static int computeFibonacci(int N) { // Recursive Fibonacci method
       
       if (N == 0) { // Base case for 0
          return 0; // F_0 = 0
       }
       else if (N == 1) { // Base case for 1
          return 1; // F_1 = 1
       }
       else { // Recursive case for N > 1
          return computeFibonacci(N-2) + computeFibonacci(N-1); // F_N = F_(N-2) + F_(N-1)
       }
    }
 
   public static void main(String[] args) { // Program entry point
      int N;      // F_N, starts at 0
      try (Scanner scnr = new Scanner(System.in)) { // Create Scanner and auto-close
         N = scnr.nextInt(); // Read N from input
         System.out.println("F_" + N + " is " + computeFibonacci(N)); // Output Fibonacci value
      }
   }
 }
 