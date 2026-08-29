/**
 * Demonstrates replacing a word in a string using StringBuilder.
 * StringBuilder is mutable, so replace() modifies the text in place without creating a new string each time.
 */
public class StringBuilderReplaceWord {

    public static void main(String args[]) {
        String statement = "The more you memorize, the more you learn.";

        String oldElement = "memorize";  // word to find
        String newElement = "practice";    // replacement word
        StringBuilder sb;

        // Wrap the string in a StringBuilder for in-place editing
        sb = new StringBuilder(statement);

        System.out.println("String: " + sb);

        // replace(start, end, str): overwrites characters from start (inclusive) to end (exclusive)
        int start = sb.indexOf(oldElement);
        sb.replace(start, start + oldElement.length(), newElement);

        System.out.println("Modified String: " + sb);
    }
}
