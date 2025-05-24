/* 1c. Linked List Programs
 * 4. Write a Java program to display elements and their positions in a linked list ( using 
l_listobj.get(p) )*/


import java.util.*;

public class LinkedListOfferLast {
    public static void main(String[] args) {
        LinkedList<String> colorList = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));

        System.out.println("Before inserting 'Pink': " + colorList);
        colorList.offerLast("Pink");
        System.out.println("After inserting 'Pink': " + colorList);
    }
}
