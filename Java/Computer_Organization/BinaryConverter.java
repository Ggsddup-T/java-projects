import java.util.Scanner; // import Scanner for input

public class BinaryConverter { // class declaration

    public static void main(String[] args) { // program entry point

        try (Scanner scanner = new Scanner(System.in)) { // create input reader
            int number; // store user input

            // Input: prompt and validate input
            while (true) { // keep asking until input is non-negative
                System.out.print("Enter a POSITIVE integer: "); // prompt user
                number = scanner.nextInt(); // read integer
                if (number < 0) { // check for negative
                    continue; // retry on negative
                }
                else { // input is valid
                    break; // exit loop
                }
            }
        
        // Store bits: prepare array for bits
        int[] bits = new int[32]; // allocate array for binary digits
        int index = 0; // current bit position

        // Divide by 2 method; compute binary digits
        while (index < 8) { // limit to 8 bits
            bits[index] = number % 2; // store remainder bit
            number = number / 2; // divide by 2
            index++; // move to next bit
        }

        // Print in reverse (correct order); output most significant bit to least significant bit
        int count = 0; // count bits printed

        for (int i = index - 1; i >= 0; i--) { // loop from most significant bit to least significant bit

            System.out.print(bits[i]); // print current bit

            count++; // increment printed count

            // Space between bits; keep readability
            if (i > 0) { // if not last bit
                System.out.print(" "); // print single space
            }

            // Extra space every 4 bits; group in nibbles
            if (count % 4 == 0 && i != 0) { // every four bits
                System.out.print(" "); // extra space after each group
            }
        }

            System.out.println(); // end line after output
        }
    }
}