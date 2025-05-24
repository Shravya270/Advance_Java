/*3.c Q6. Write a Java Program for  Capitalizing the first letter of each word. using user defined function 
capitalizeWords()*/


import java.util.Scanner;

public class TruncateString {
    public static String truncate(String input, int length) {
        if (input == null || input.length() <= length) {
            return input;
        }
        return input.substring(0, length) + "...";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter maximum length: ");
        int len = sc.nextInt();
        System.out.println("Truncated: " + truncate(str, len));
        sc.close();
    }
}
