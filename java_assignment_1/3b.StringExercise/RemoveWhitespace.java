/*3.b Q2. Write a Java Program for Counting how many times a substring appears in a main string
 using user defined function countOccurrences()*/


import java.util.Scanner;

public class RemoveWhitespace {
    public static String removeWhitespace(String input) {
        return input.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Without whitespace: " + removeWhitespace(input));
        sc.close();
    }
}
