import java.util.Stack; // Import Stack for operand storage.
public class PostfixEvaluation{ // Define the class that evaluates postfix expressions.
    static int evaluatePostfix(String exp){ // Evaluate a postfix expression string.
        //Write your code here... // Original prompt comment preserved.
    
      Stack<Integer> stack = new Stack<>(); // Stack holds intermediate numeric values.

      for(int i = 0; i < exp.length(); i++){ // Loop through each character in the input.
        char c = exp.charAt(i); // Read the current character.
        if(Character.isDigit(c)) // If the character is a digit...
          stack.push(c - '0'); // Convert char to int and push onto stack.
        else{ // Otherwise the character is an operator.
          int val1 = stack.pop(); // Pop the right operand.
          int val2 = stack.pop(); // Pop the left operand.
          switch(c){ // Choose the operator to apply.
            case '+': // Addition case.
                stack.push(val2 + val1); // Push sum of operands.
                break; // Stop this switch case.
            case '-': // Subtraction case.
                stack.push(val2 - val1); // Push difference (left minus right).
                break; // Stop this switch case.
            case '/': // Division case.
                stack.push(val2 / val1); // Push quotient (left divided by right).
                break; // Stop this switch case.
            case '*': // Multiplication case.
                stack.push(val2 * val1); // Push product of operands.
                break; // Stop this switch case.
           } // End switch.
        } // End operator handling.
      } // End loop through characters.
      return stack.pop(); // Final result is the last value on the stack.
      
    } // End evaluatePostfix.
  
    public static void main(String[] args){ // Program entry point.
        String exp = "231*+9-"; // Sample postfix expression to evaluate.
        System.out.println("Evaluated result: " + evaluatePostfix(exp)); // Print the evaluated result.
    } // End main.
} // End class.