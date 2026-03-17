import java.util.Scanner;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StringOutputStream {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // Basic stream for fullname
      StringWriter fullnameStream = new StringWriter();
      // Augments stream (fullname) with print()
      PrintWriter fullnameOSS = new PrintWriter(fullnameStream);
      // Basic stream for age
      StringWriter ageStream = new StringWriter();
      // Augments stream (age) with print()
      PrintWriter ageOSS = new PrintWriter(ageStream);

      String firstName;      // First name
      String lastName;       // Last name
      String fullName;       // Full name (first and last)
      int userAge;           // Age

      firstName = scnr.next();
      lastName = scnr.next();
      userAge = scnr.nextInt();

      // Writes formatted string to buffer, copies from underlying buffer
      fullnameOSS.print(lastName + ", " + firstName);
      fullName = fullnameStream.toString();

      // Output parsed input
      System.out.println("Full name: " + fullName);

      // Writes int age as characters to buffer
      ageOSS.print(userAge);

      // Appends (minor) to object if less than 21, then
      // copies buffer into string
      if (userAge < 21) {
         ageOSS.print(" (minor)");
      }

      // Output string
      System.out.println("Age: " + ageStream.toString());
   }
}
