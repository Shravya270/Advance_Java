/* 1c. Linked List Programs
 * 4. Write a Java program to display elements and their positions in a linked list ( using 
l_listobj.get(p) )*/


import java.util.*;

public class LinkedListSwap {
    public static void main(String[] args) {
        LinkedList<String> colorList = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));

        System.out.println("Before swapping first and third elements: " + colorList);
        Collections.swap(colorList, 0, 2);
        System.out.println("After swapping: " + colorList);
    }
}
