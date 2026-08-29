import java.util.*; // Import utility classes used in this file.
import java.util.Stack; // Import Stack for operator storage.
public class inFixToPostFix{ // Define the class containing conversion logic.
    static int Prec(char ch){ // Return precedence for an operator.
        switch(ch){ // Choose precedence based on operator.
          case '+': // Addition has low precedence.
          case '-': // Subtraction has low precedence.
              return 1; // Return precedence level 1.
          case '*': // Multiplication has higher precedence.
          case '/': // Division has higher precedence.
              return 2; // Return precedence level 2.
          case '^': // Exponent has highest precedence.
              return 3; // Return precedence level 3.
        } // End switch.
        return -1; // Return -1 for non-operators.
    } // End Prec.
    static String infixToPostfix(String exp){ // Convert infix string to postfix.
        //Write your code here... // Original prompt comment preserved.
      
      String result = new String(""); // Build the postfix expression.

      Stack<Character> stack = new Stack<>(); // Stack for operators and parentheses.
      for(int i = 0; i<exp.length(); ++i){ // Iterate through each character.
        char c = exp.charAt(i); // Get current character.
        if(Character.isLetterOrDigit(c)) // If operand, append to result.
          result += c; // Add operand to output.
        else if(c == '(') // If left parenthesis, push to stack.
          stack.push(c); // Store '(' on stack.
        else if(c == ')'){ // If right parenthesis, pop until '('.
          while(!stack.isEmpty() && stack.peek() != '(') // Pop operators to output.
            result += stack.pop(); // Append popped operator.
          stack.pop(); // Remove the '('.
        }
        else{ // Current character is an operator.
          while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))            { // Pop higher/equal precedence operators.
            result += stack.pop(); // Append popped operator to output.
          }
          stack.push(c); // Push current operator.
        }
      }
      while(!stack.isEmpty()){ // Pop any remaining operators.
        if(stack.peek() == '(') // If leftover '(' exists, expression is invalid.
          return "Invalid Expression"; // Return error message.
        result += stack.pop(); // Append remaining operators.
      }
      return result; // Return final postfix expression.
    }
  
    public static void main(String[] args){ // Program entry point.
        String exp = "a+b*(c^d-e)^(f+g*h)-i"; // Sample infix expression.
        System.out.println("Infix Expression: " + exp); // Print input expression.
        System.out.println("Postfix Expression: " + infixToPostfix(exp)); // Print converted postfix.
    }
}