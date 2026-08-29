import java.util.Scanner;

public class WordScrambler {
   /* Output every possible permutation of a word.
      Each recursive call moves a letter from
      remainLetters" to scramLetters".
   */
   public static void scrambleLetters(String remainLetters,  // Remaining letters
                                      String scramLetters) { // Scrambled letters
      String tmpString;      // Temp word permutations
      int i;                 // Loop index

      if (remainLetters.length() == 0) { // Base case: All letters used
         System.out.println(scramLetters);
      }
      else {                             // Recursive case: move a letter from
                                         // remaining to scrambled letters 
         for (i = 0; i < remainLetters.length(); ++i) {
            // Move letter to scrambled letters
            tmpString = remainLetters.substring(i, i + 1);
            remainLetters = removeFromIndex(remainLetters, i);
            scramLetters = scramLetters + tmpString;

            scrambleLetters(remainLetters, scramLetters);

            // Put letter back in remaining letters
            remainLetters = insertAtIndex(remainLetters, tmpString, i);
            scramLetters = removeFromIndex(scramLetters, scramLetters.length() - 1);
         }
      }
   }

   // Returns a new String without the character at location remLoc
   public static String removeFromIndex(String origStr, int remLoc) {
      String finalStr;      // Temp string to extract char

      finalStr = origStr.substring(0, remLoc);                     // Copy before location remLoc
      finalStr += origStr.substring(remLoc + 1, origStr.length()); // Copy after location remLoc

      return finalStr;
   }

   // Returns a new String with the character specified by insertStr 
   // inserted at location addLoc
   public static String insertAtIndex(String origStr, String insertStr, int addLoc) {
      String finalStr;      // Temp string to extract char

      finalStr = origStr.substring(0, addLoc);                 // Copy before location addLoc
      finalStr += insertStr;                                   // Copy character to location addLoc
      finalStr += origStr.substring(addLoc, origStr.length()); // Copy after location addLoc

      return finalStr;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String wordScramble;      // User defined word to scramble

      // Prompt user for input
      System.out.print("Enter a word to be scrambled: ");
      wordScramble = scnr.next();
      
      // Call recursive method
      scrambleLetters(wordScramble, "");
   }
}