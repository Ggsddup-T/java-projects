import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class CabinetWriter {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);
      FileOutputStream fileStream = null;
      PrintWriter cabinetWriter = null;
      int cabinetCount;
      String friendName;

      cabinetCount = scnr.nextInt();
      friendName = scnr.next();
  
      fileStream = new FileOutputStream("data.txt");
      cabinetWriter = new PrintWriter(fileStream);

      cabinetWriter.println("Do not forget:");
      cabinetWriter.println(cabinetCount + " cabinets for " + friendName);
      
      cabinetWriter.close();

   }
}