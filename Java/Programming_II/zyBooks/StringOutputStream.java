import java.util.Scanner;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StringOutputStream {
  public static void main(String[] args) {
     Scanner scnr = new Scanner(System.in);

     // Basic character stream for age
     StringWriter ageStream = new StringWriter();
     // Augments character stream with print()
     PrintWriter ageOSS = new PrintWriter(ageStream);

     int userAge;           // Age (int)

     // Gets user's age from input
     userAge = scnr.nextInt();

     // Writes userAge as characters to
     // output string stream buffer (PrintWriter)
     ageOSS.print(userAge);

     // Appends " (minor)" to stream buffer
     // if the user's age is less than 21
     if (userAge < 21) {
        ageOSS.print(" (minor)");
     }

     // Copies the stream's buffer to a String
     // and outputs string to the screen
     System.out.println("User's age: " + ageStream.toString());
  }
}