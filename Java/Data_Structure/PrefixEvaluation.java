import java.io.*; // Import IO utilities (not strictly needed here).
import java.util.*; // Import utility classes like Stack.
public class PrefixEvaluation{ // Define the class that evaluates prefix expressions.
    static Boolean isOperand(char c){ // Check if a character is a numeric operand.
        if(c >= 48 && c <= 57) // ASCII range for digits '0'..'9'.
            return true; // Character is a digit.
        else // Character is not a digit.
            return false; // Not an operand.
    }
    static double evaluatePrefix(String exp){ // Evaluate a prefix expression string.
        //Write your code here... // Original prompt comment preserved.
      
      Stack<Double> Stack = new Stack<Double>(); // Stack holds operands during evaluation.

      for(int j = exp.length() - 1; j >= 0; j--){ // Scan expression from right to left.
        
         if(isOperand(exp.charAt(j))) // If current char is an operand...
           
           Stack.push((double)(exp.charAt(j) - 48)); // Convert digit char to number and push.
         
        else{ // Otherwise, the character is an operator.
           
           double o1 = Stack.peek(); // Read first operand from stack.
           Stack.pop(); // Remove first operand.
           double o2 = Stack.peek(); // Read second operand from stack.
           Stack.pop(); // Remove second operand.
           
           switch(exp.charAt(j)){ // Apply operator to operands.
             case '+': // Addition case.
               Stack.push(o1 + o2); // Push sum.
               break; // Stop this case.
             case '-': // Subtraction case.
               Stack.push(o1 - o2); // Push difference.
               break; // Stop this case.
             case '*': // Multiplication case.
               Stack.push(o1 * o2); // Push product.
               break; // Stop this case.
             case '/': // Division case.
               Stack.push(o1 / o2); // Push quotient.
               break; // Stop this case.
           }
         }
      }
      return Stack.peek(); // Final result is on top of the stack.
    }
    public static void main(String[] args){ // Program entry point.
        String exp = "*+69-31"; // Sample prefix expression.
        System.out.println("Prefix expression: " + exp); // Print input expression.
        System.out.println("Evaluated result: " + evaluatePrefix(exp)); // Print evaluated result.
    }
}