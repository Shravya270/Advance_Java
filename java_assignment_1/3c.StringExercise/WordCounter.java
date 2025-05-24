/*3.c Q6. Write a Java Program for  Capitalizing the first letter of each word. using user defined function 
capitalizeWords()*/


import java.util.Scanner;

public class WordCounter {
    public static int countWords(String input) {
        if (input == null || input.trim().isEmpty()) return 0;
        return input.trim().split("\\s+").length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.println("Word count: " + countWords(sentence));
        sc.close();
    }
}
