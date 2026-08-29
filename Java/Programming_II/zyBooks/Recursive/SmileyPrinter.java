import java.util.Scanner;

public class SmileyPrinter {

   public static void printSmiley(int numSmilies) {
      if (numSmilies == 0) {
         System.out.print("Happy Birthday!");
      }
      else {
         System.out.print("(:");
         printSmiley(numSmilies - 1);
         System.out.print(":)");
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int numSmilies = scnr.nextInt();
      printSmiley(numSmilies);
      System.out.println();
   }
}
