import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class CountingInstancesOfWord {
   public static void main(String[] args) throws IOException {
      try (Scanner scnr = new Scanner(System.in)) {
         FileInputStream fileInputStream = null;
         Scanner fileScanner = null;
         String userword;
         int count = 0;
         String currentWord;

      // file name 
         System.out.println("Enter the file name: ");
         String fileName = scnr.nextLine();

      // open the file
         fileInputStream = new FileInputStream(fileName);
         fileScanner = new Scanner(fileInputStream);

      // word to be counted
         System.out.println("Enter the word to count: ");
         userword = scnr.nextLine();

      // count the occurrences of the word in the file
         while (fileScanner.hasNext()) {
            currentWord = fileScanner.next();
            if (currentWord.equals(userword)) {
               count++;
            }
         }


      // print the result
         System.out.println("The word " + userword + " appears " + count + " times in the file.");
    
      // close the file
         fileScanner.close();
         fileInputStream.close();
      }
   }
}