/* 1c. Linked List Programs
 * 4. Write a Java program to display elements and their positions in a linked list ( using 
l_listobj.get(p) )*/


import java.util.*;

public class LinkedListReverse {
    public static void main(String[] args) {
        LinkedList<String> colorList = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));

        System.out.println("Iterating in reverse order:");
        Iterator<String> reverseIterator = colorList.descendingIterator();
        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
    }
}
