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
