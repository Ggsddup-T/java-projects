import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingToOutputFile {
  public static void main(String[] args) throws IOException {
    Scanner scnr = new Scanner(System.in);
    String name = scnr.next();
    int age = scnr.nextInt();
    String city = scnr.next();
    String state = scnr.next();
    String zip = scnr.next();
    String country = scnr.next();
    String email = scnr.next();
    
    FileOutputStream fileStream = null;
     PrintWriter outFS = null;

     // Try to open file
     fileStream = new FileOutputStream("myoutfile.txt");
     outFS = new PrintWriter(fileStream);

     // Arriving here implies that the file can now be written
     // to, otherwise an exception would have been thrown.
     outFS.println("Hello");
     outFS.println("1 2 3");
     outFS.println(name + " " + age + " " + city + " " + state + " " + zip + " " + country + " " + email);

     // Done with file, so try to close
     // Note that close() may throw an IOException on failure
     outFS.close();
  }
}
