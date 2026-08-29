import java.util.Stack; // Import Stack to store characters for reversal.
public class PalindromeTest{ // Define the class for palindrome checking.
    public static void main(String[] args){ // Program entry point.
        String inputString = "madam"; // Input string to test.
        //Write your code here... // Original prompt comment preserved.
      
      String reverseString = ""; // Will hold the reversed string.
      String output = ""; // Message to print at the end.
      Stack<String> stack = new Stack<String>(); // Stack to reverse characters.
      for(int i = 0; i < inputString.length(); i++){ // Push each character onto stack.
        stack.push(inputString.charAt(i)+""); // Convert char to String and push.
      }
      while(!stack.isEmpty()){ // Pop all characters to build reverse string.
         reverseString = reverseString+stack.pop(); // Append popped character.
      }
      if(inputString.equals(reverseString)) // Compare original to reversed.
         output = "The string " + inputString + " is a palindrome."; // Build palindrome message.
      else // Otherwise, not a palindrome.
     output = "The string " + inputString + " is not a palindrome."; // Build non-palindrome message.
      
        System.out.println(output); // Print the final message.
    } // End main.
} // End class.