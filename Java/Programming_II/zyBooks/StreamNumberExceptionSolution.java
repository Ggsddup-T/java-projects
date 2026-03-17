import java.util.Scanner;

public class StreamNumberExceptionSolution {

   public static void main(String [] args) {   
      // Describe the format of a row of input. There are four fields in a row
      // separate by commas: last name, first name, department, salary
      final String SEPARATOR   = ",";  // Field separator in each row of data
      final int INDEX_LAST_NAME  = 0;  // # of the last name field
      final int INDEX_FIRST_NAME = 1;  // # of the first name field
      final int INDEX_DEPT       = 2;  // # of the department name field
      final int INDEX_SALARY     = 3;  // # of the salary field
      Scanner scnr = new Scanner(System.in);
      
      String [] field;        // Fields on one row in the input file
      String row;             // One row of the input file
      int nRows;              // Counts # of rows in the input file
      int totalSalaries;      // Total of all salaries read
      
      nRows = 0;
      totalSalaries = 0;
      
      while (scnr.hasNext()) { // Loop while input data exists
        row = scnr.nextLine();
         ++nRows;
         System.out.println();
         System.out.println(nRows + ") " + row);
         field = row.split(SEPARATOR);

         try { // Ensure an integer was input
            totalSalaries += Integer.parseInt(field[INDEX_SALARY]);
            System.out.println("       " +
                               field[INDEX_FIRST_NAME] + SEPARATOR +
                               field[INDEX_LAST_NAME]  + SEPARATOR +
                               field[INDEX_SALARY   ]  + SEPARATOR +
                               field[INDEX_DEPT]);
         }
         catch (NumberFormatException e) {
            System.out.println(
                  "The salary entry for " + field[INDEX_FIRST_NAME] + " "
                  + field[INDEX_LAST_NAME] + ", " + field[INDEX_SALARY]
                  + ", is not an integer.\n"
                  + "This info won't be added to the salary running total.\n");
         } 
      } 

      System.out.println();      
      System.out.printf("Total salaries: $%,8d", totalSalaries);
   } 
} 