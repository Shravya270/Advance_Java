import java.util.*;

public class LinkedListSwap {
    public static void main(String[] args) {
        LinkedList<String> colorList = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));

        System.out.println("Before swapping first and third elements: " + colorList);
        Collections.swap(colorList, 0, 2);
        System.out.println("After swapping: " + colorList);
    }
}
