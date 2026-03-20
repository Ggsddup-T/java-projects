import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReading {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);
      FileInputStream fileByteStream = null;
      Scanner dataFS = null;
      String nameOfFile;
      int cradleQuantity;
		int remainingCradles;

      System.out.println(System.getProperty("user.dir"));

      nameOfFile = scnr.next();

      fileByteStream = new FileInputStream("filereading/" + nameOfFile);
      dataFS = new Scanner(fileByteStream);
		remainingCradles = 300;
		System.out.println("Started with: " + remainingCradles);

      while (dataFS.hasNextInt()) {
         cradleQuantity = dataFS.nextInt();

         System.out.println(cradleQuantity);
			remainingCradles = remainingCradles - cradleQuantity;
      }

      if (dataFS.hasNext()) {
         System.out.println("Reading stopped at " + dataFS.next());
      }
      else {
         System.out.println("Reached end of file");
      }

		System.out.println("Unsold: " + remainingCradles);

      fileByteStream.close();
   }
}