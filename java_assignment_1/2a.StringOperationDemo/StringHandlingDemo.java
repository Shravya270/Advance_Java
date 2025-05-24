/*
 2 a. Develop a java program for performing various string operations with different string
handling functions directed as follows
String Creation and Basic Operations, Length and Character Access, String Comparison, String
Searching, Substring Operations , String Modification, Whitespace Handling, String
Concatenation, String Splitting, StringBuilder Demo, String Formatting , Validate Email with
contains( ) and startsWith() and endsWith()
 */


public class StringHandlingDemo {
    public static void main(String[] args) {
        // String Creation and Basic Operations
        String str1 = "Hello";
        String str2 = "World";
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        // Length and Character Access
        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 1 of str1: " + str1.charAt(1));

        // String Comparison
        System.out.println("str1 equals 'Hello': " + str1.equals("Hello"));
        System.out.println("str1 equalsIgnoreCase 'hello': " + str1.equalsIgnoreCase("hello"));
        System.out.println("str1 compareTo str2: " + str1.compareTo(str2));

        // String Searching
        String sample = "Welcome to Java Programming";
        System.out.println("\nSample: " + sample);
        System.out.println("Contains 'Java': " + sample.contains("Java"));
        System.out.println("Index of 'to': " + sample.indexOf("to"));
        System.out.println("Last index of 'a': " + sample.lastIndexOf('a'));

        // Substring Operations
        System.out.println("Substring from index 11: " + sample.substring(11));
        System.out.println("Substring from 11 to 15: " + sample.substring(11, 15));

        // String Modification
        String modified = sample.replace("Java", "Python");
        System.out.println("After replace: " + modified);

        // Whitespace Handling
        String spaced = "   Hello World   ";
        System.out.println("\nOriginal: '" + spaced + "'");
        System.out.println("After trim: '" + spaced.trim() + "'");

        // String Concatenation
        String concat = str1.concat(" ").concat(str2);
        System.out.println("Concatenated: " + concat);

        // String Splitting
        String csv = "Apple,Banana,Orange";
        String[] fruits = csv.split(",");
        System.out.println("\nSplitted fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // StringBuilder Demo
        StringBuilder sb = new StringBuilder("Welcome");
        sb.append(" to Java");
        sb.insert(0, "Hello! ");
        sb.replace(0, 6, "Hi!");
        sb.delete(3, 6);
        System.out.println("\nStringBuilder result: " + sb.toString());

        // String Formatting
        String name = "Sharvya";
        int age = 21;
        String formatted = String.format("Name: %s, Age: %d", name, age);
        System.out.println("Formatted String: " + formatted);

        // Validate Email
        String email = "user@example.com";
        System.out.println("\nEmail: " + email);
        System.out.println("Contains '@': " + email.contains("@"));
        System.out.println("Starts with 'user': " + email.startsWith("user"));
        System.out.println("Ends with '.com': " + email.endsWith(".com"));
    }
}
