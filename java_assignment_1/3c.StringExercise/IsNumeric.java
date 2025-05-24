/*3.c Q6. Write a Java Program for  Capitalizing the first letter of each word. using user defined function 
capitalizeWords()*/


import java.util.Scanner;

public class IsNumeric {
    public static boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Is numeric? " + isNumeric(input));
        sc.close();
    }
}
