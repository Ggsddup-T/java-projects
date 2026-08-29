// Lab 5A – Command Lines and Exception Handling
// In Java, the method main has as a parameter an array of String objects. These objects are known as Command Line Arguments and is an alternative way of providing input to a program.

// In this exercise, the getInt method is used to interpret and return the numerical value of an integer of an argument provided by the main method. If the argument is not an integer, it returns zero. If the argument is a double, it prints a message that it is a double otherwise it prints that it is something else.

// Depending upon the actual command line argument(s), output might appear as follows:

// Argument is a double - 7.1
// Argument is a something else - Mary
// sum = 38

// One way of solving this is to use Exception handling.
// Here is a sample program that demonstrates this:


public class Lab5A {
    public static void main(String[] args) {
        int sum = 0;
        for (String s : args) {
            sum += getInt(s);
        }

System.out.println("sum = " + sum);
}

/**
 * Process the string argument. If an int, return it.
 * If a double, output "Argument is double - " followed by the parameter to System.out
 * If none of these, output "Argument is something else - " followed by the parameter
 * For example, is s="5.1" System.out is Argument is double - 5.1
 * If s="Tom", System.out is Argument is something else - Tom
 * If not an int, return 0;
 */
public static int getInt(String s) {
    try {
        return Integer.parseInt(s);
    } catch (NumberFormatException e) {
        System.out.println("Argument is a double - " + s);
    } catch (Exception e) {
        System.out.println("Argument is a something else - " + s);
    }
    return 0;
}
}