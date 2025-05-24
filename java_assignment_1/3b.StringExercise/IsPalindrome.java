/*3.b Q2. Write a Java Program for Counting how many times a substring appears in a main string
 using user defined function countOccurrences()*/


import java.util.Scanner;

public class IsPalindrome {
    public static boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Is palindrome? " + isPalindrome(input));
        sc.close();
    }
}
