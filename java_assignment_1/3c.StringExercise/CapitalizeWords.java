/*3.c Q6. Write a Java Program for  Capitalizing the first letter of each word. using user defined function 
capitalizeWords()*/


import java.util.Scanner;

public class CapitalizeWords {
    public static String capitalizeWords(String input) {
        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty())
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.println("Capitalized: " + capitalizeWords(sentence));
        sc.close();
    }
}
