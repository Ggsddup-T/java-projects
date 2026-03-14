import java.util.Scanner;

public class ShoppingCartPrinter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      int i;
      ItemToPurchase[] items = new ItemToPurchase[2];

      for (i = 0; i < 2; ++i) {
         items[i] = new ItemToPurchase();

         System.out.println("Item " + (i + 1));

         System.out.println("Enter the item name:");
         items[i].setName(scnr.nextLine());

         System.out.println("Enter the item price:");
         items[i].setPrice(scnr.nextInt());

         System.out.println("Enter the item quantity:");
         items[i].setQuantity(scnr.nextInt());

         if (i == 0) {
            scnr.nextLine();
         }
         System.out.println();
      }
      System.out.println("TOTAL COST");
      items[0].print();
      items[1].print();

      int total = items[0].getPrice() * items[0].getQuantity() + items[1].getPrice() * items[1].getQuantity();
      System.out.println();
      System.out.println("Total: $" + total);
   }
}
