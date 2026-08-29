import java.util.Scanner;

public class StockTotal {
   public static void purchases(int totalWeek, int week, int inventory) {
      if (week == totalWeek) {
         System.out.println("Week: " + totalWeek + ", inventory: " + inventory);
      }
      else {

         if (week % 3 == 0) {
          purchases(totalWeek, week + 1, inventory - 6);
         }
         else {
          purchases(totalWeek, week + 1, inventory - 17);
         }
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int totalWeek;
		int inventory;

      totalWeek = scnr.nextInt();
		inventory = scnr.nextInt();
      purchases(totalWeek, 1, inventory);
   }
}