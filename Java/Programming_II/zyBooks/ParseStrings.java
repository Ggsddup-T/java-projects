import java.util.Scanner;

public class ParseStrings {
   public static void main(String[] args) {
      try (Scanner scnr = new Scanner(System.in)) {
         // Variables for input processing
         String firstWord;
         String secondWord;
         String inLine;

         while (true) {
            System.out.println("Enter input string:");
            inLine = scnr.nextLine();

            if (inLine.equals("q")) {
               break;
            }

            if (!inLine.contains(",")) {
               System.out.println("Error: No comma in string.");
               System.out.println();
               continue;
            }

            String[] fields = inLine.split(",", 2);
            firstWord = fields[0].trim();
            secondWord = (fields.length > 1) ? fields[1].trim() : "";

            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);
            System.out.println();
         }
      }
   }
}
