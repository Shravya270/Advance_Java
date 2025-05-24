/*3.c Q6. Write a Java Program for  Capitalizing the first letter of each word. using user defined function 
capitalizeWords()*/


import java.util.Random;
import java.util.Scanner;

public class RandomStringGenerator {
    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the desired length of the random string: ");
        int len = sc.nextInt();
        System.out.println("Random String: " + generateRandomString(len));
        sc.close();
    }
}
