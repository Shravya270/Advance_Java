
/*
 3a. Develop a java program for performing various string operations with different string
handling functions directed as follows:
String Creation and Basic Operations, Length and Character Access, String Comparison, String
Searching, Substring Operations , String Modification, Whitespace Handling, String Concatenation,
String Splitting, StringBuilder Demo, String Formatting , Validate Email with contains( ) and
startsWith() and endsWith()
 */


public class StringHandlingExample {
    public static void main(String[] args) {
        // String Creation and Basic Operations
        String s1 = "Hello";
        String s2 = "World";
        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);

        // Length and Character Access
        System.out.println("Length of s1: " + s1.length());
        System.out.println("Character at index 2 in s1: " + s1.charAt(2));

        // String Comparison
        System.out.println("s1 equals 'Hello': " + s1.equals("Hello"));
        System.out.println("s1 equalsIgnoreCase 'hello': " + s1.equalsIgnoreCase("hello"));
        System.out.println("s1 compareTo s2: " + s1.compareTo(s2));

        // String Searching
        String message = "Welcome to AIET College";
        System.out.println("\nMessage: " + message);
        System.out.println("Contains 'AIET': " + message.contains("AIET"));
        System.out.println("Index of 'to': " + message.indexOf("to"));
        System.out.println("Last index of 'e': " + message.lastIndexOf('e'));

        // Substring Operations
        System.out.println("Substring from index 11: " + message.substring(11));
        System.out.println("Substring from 11 to 16: " + message.substring(11, 16));

        // String Modification
        String modified = message.replace("AIET", "NITK");
        System.out.println("After replacement: " + modified);

        // Whitespace Handling
        String spaced = "   Welcome AIET   ";
        System.out.println("Before trim: '" + spaced + "'");
        System.out.println("After trim: '" + spaced.trim() + "'");

        // String Concatenation
        String combined = s1 + " " + s2;
        System.out.println("Concatenated: " + combined);

        // String Splitting
        String items = "Red,Green,Blue";
        String[] colors = items.split(",");
        System.out.println("Splitted colors:");
        for (String color : colors) {
            System.out.println(color);
        }

        // StringBuilder Demo
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(0, "Hi! ");
        sb.replace(0, 3, "Hey");
        sb.delete(3, 4);
        System.out.println("StringBuilder result: " + sb.toString());

        // String Formatting
        String name = "Sharvya";
        int marks = 95;
        String formatted = String.format("Name: %s, Marks: %d", name, marks);
        System.out.println("Formatted String: " + formatted);

        // Email Validation
        String email = "student@aiet.edu.in";
        System.out.println("\nEmail: " + email);
        System.out.println("Contains '@': " + email.contains("@"));
        System.out.println("Starts with 'student': " + email.startsWith("student"));
        System.out.println("Ends with '.in': " + email.endsWith(".in"));
    }
}
