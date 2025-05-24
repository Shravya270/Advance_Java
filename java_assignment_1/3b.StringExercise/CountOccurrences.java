/*3.b Q2. Write a Java Program for Counting how many times a substring appears in a main string
 using user defined function countOccurrences()*/


import java.util.Scanner;

public class CountOccurrences {
    public static int countOccurrences(String main, String sub) {
        int count = 0, index = 0;
        while ((index = main.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter main string: ");
        String main = sc.nextLine();
        System.out.print("Enter substring: ");
        String sub = sc.nextLine();
        System.out.println("Occurrences: " + countOccurrences(main, sub));
        sc.close();
    }
}
