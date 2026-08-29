import java.util.Scanner;

public class PrimeChecker {
    // Returns 0 if value is not prime, 1 if value is prime
       public static int isPrime(int testVal, int divVal) {
          
          // Base case 1: 0 and 1 are not prime, testVal is not prime
          if ((testVal == 0) || (testVal == 1)) {
             return 0;
          }
          
          // Base case 2: testVal only divisible by 1, testVal is prime
          else if (divVal == 1) {
             return 1;
          }
          
          // Recursive Case
             // Check if testVal can be evenly divided by divVal
             // Hint: use the % operator
             // If not, recursive call to isPrime with testVal and (divVal - 1)
          else {
             if ((testVal % divVal) != 0) {
             return isPrime(testVal, (divVal - 1));
             }
             else {
                return 0;
             }
          }
       }
    
       public static void main(String[] args) {
          int primeCheckVal;     // Value checked for prime
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a number to check if it is prime: ");
        primeCheckVal = scnr.nextInt(); 
          // Check primes for values 1 to primeCheckVal
          System.out.println("Checking primes for values 1 to " + primeCheckVal + ":");
          for (int i = 1; i < primeCheckVal; ++i) {
             if (isPrime(i, (i - 1)) == 1) {
                System.out.println(i + " ");
             }
          }
       }
    }