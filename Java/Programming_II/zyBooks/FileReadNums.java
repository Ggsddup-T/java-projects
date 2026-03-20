import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadNums {
   public static void main (String[] args) throws IOException {
      int fileNum1;                       // Data value from file
      int fileNum2;                       // Data value from file

      // Try to open file
      System.out.println("Opening file numFile.txt.");
      try (FileInputStream fileByteStream = new FileInputStream("numFile.txt");
           Scanner inFS = new Scanner(fileByteStream);
           PrintWriter out = new PrintWriter(System.out, true)) {
      
      // File is open and valid if we got this far 
      // (otherwise exception thrown)
      // numFile.txt should contain two integers, else problems
         out.println("Reading two integers.");
         fileNum1 = inFS.nextInt();
         fileNum2 = inFS.nextInt();

      // Output values read from file
         out.printf("num1: %d%n", fileNum1);
         out.printf("num2: %d%n", fileNum2);
         out.printf("num1 + num2: %d%n", (fileNum1 + fileNum2));

      // Done with file, so try to close it
         out.println("Closing file numFile.txt.");
      }
   }
}