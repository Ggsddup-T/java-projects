import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class ReviewSystem {
   public static void main(String [] args) throws IOException {
      FileInputStream fileByteStream = null; // Input file stream
      Scanner inFS = null;                   // Scanner object
      String restaurantName;
      String userName;
      int userRating;
      int userRatingSum = 0;
      int userRatingCount = 0;

      // Open file
      System.out.println("Opening file Trattoria_Reviews.txt.");
      fileByteStream = new FileInputStream("Trattoria_Reviews.txt");
      inFS = new Scanner(fileByteStream);

      // Read and display the restaurant's name
      restaurantName = inFS.nextLine();
      System.out.println("\n" + restaurantName);
      System.out.println("--------------------");

      // Loop to read all user reviews
      while(inFS.hasNext()) {
         userName = inFS.next();
         userRating = inFS.nextInt();

         // Display user's name and rating
         System.out.println("User name: " + userName);
         System.out.println("   Rating: " + userRating);
         System.out.println();

         // Add to the sum of all ratings so far
         userRatingSum += userRating;

         // Increment the number of ratings read
         userRatingCount++;
      }

      // Display the restaurant's average rating
      System.out.println("--------------------");
      System.out.println("Average rating: " + (double)userRatingSum / userRatingCount);

      fileByteStream.close(); // close() may throw IOException if fails
   }
}