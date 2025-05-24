/*3.b Q2. Write a Java Program for Counting how many times a substring appears in a main string
 using user defined function countOccurrences()*/


import java.util.Scanner;

public class IsNullOrEmpty {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Is null or empty? " + isNullOrEmpty(input));
        sc.close();
    }
}
