// ************************************************************
// LoveCS.java
//
// Use a while loop to print many message declaring your
// passion for Computer Science.
// ************************************************************
import java.util.Scanner;

public class LoveCS {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("How many times do you want to print the message? ");
        int num = scnr.nextInt();
        int count = 1;
        int sum = 0;
        while (count <= num) {
            System.out.println(count + " I love Computer Science!");
            sum += count;
            ++count;
        }
        System.out.println("Printed this message " + num +
        " times. The sum of the numbers from 1 to " + num + " is " + sum);
    }
}