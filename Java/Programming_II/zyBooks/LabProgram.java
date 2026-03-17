import java.util.Scanner;

public class LabProgram {
    public static void main(String[] args) {
        String[] names = { "Ryley", "Edan", "Reagan", "Henry", "Caius", "Jane", "Guto", "Sonya", "Tyrese", "Johnny" };
        int index;

        try (Scanner scnr = new Scanner(System.in)) {
            while (scnr.hasNextInt()) {
                index = scnr.nextInt();
                if (index == -1) {
                    break;
                }
                try {
                    System.out.println("Name: " + names[index]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    if (index < 0) {
                        System.out.println("Exception! " + ex.getMessage()
                                + "\nThe closest name is: " + names[0]);
                    } else {
                        System.out.println("Exception! " + ex.getMessage()
                                + "\nThe closest name is: " + names[9]);
                    }
                }
            }
        }
    }      
}

