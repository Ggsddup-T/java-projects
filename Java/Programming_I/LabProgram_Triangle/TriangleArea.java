import java.util.Scanner;

public class TriangleArea {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      Triangle triangle1 = new Triangle();
      Triangle triangle2 = new Triangle();

      double base1 = scnr.nextDouble();// TODO: Read and set base and height for triangle1 (use setBase() and setHeight())
      double height1 = scnr.nextDouble();
      triangle1.setBase(base1);
      triangle1.setHeight(height1);

      // TODO: Read and set base and height for triangle2 (use setBase() and setHeight())
      double base2 = scnr.nextDouble();
      double height2 = scnr.nextDouble();
      triangle2.setBase(base2);
      triangle2.setHeight(height2);
      
      System.out.println("Triangle with smaller area:");
      
      double area1 = triangle1.getArea();// TODO: Determine smaller triangle (use getArea())
      double area2 = triangle2.getArea();
      if (area1 < area2) {
         triangle1.printInfo();
      }
      else {
         triangle2.printInfo();
      }
      
      //       and output smaller triangle's info (use printInfo())
      
   }
}
