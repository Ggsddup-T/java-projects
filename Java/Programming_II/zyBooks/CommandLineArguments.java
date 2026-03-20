import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class CommandLineArguments {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);
      FileInputStream fileByteStream = null; // File input stream
      Scanner inFS = null;                   // Scanner object
      String userWord;
      int wordFreq = 0;
      String currWord;
      
      // Check number of arguments
      if (args.length != 1) {
         System.out.println("Usage: java CountWords inputFileName");
         return;
      }

      // Try to open file
      System.out.println("Opening file " + args[0] + ".");
      fileByteStream = new FileInputStream(args[0]);
      inFS = new Scanner(fileByteStream);

      // Word to be found
      System.out.print("Enter a word: ");
      userWord = scnr.next();

      while (inFS.hasNext()) {
         currWord = inFS.next();
         if(currWord.equals(userWord)) {
            ++wordFreq;
         }
      }

      System.out.println(userWord + " appears in the file " +
                         wordFreq + " times.");

      // Done with file, so try to close it
      fileByteStream.close(); 
   }
}