import java.util.Scanner;

public class AlphaFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();
        
        String result = filterAlphabetic(input);
        
        System.out.println("Original: " + input);
        System.out.println("Filtered: " + result);
        
        scanner.close();
    }
    
    public static String filterAlphabetic(String input) {
        StringBuilder result = new StringBuilder();
        
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
