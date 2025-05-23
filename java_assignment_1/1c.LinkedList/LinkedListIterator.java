import java.util.*;

public class LinkedListIterator {
    public static void main(String[] args) {
        LinkedList<String> colorList = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));

        System.out.println("Iterating from 2nd position:");
        Iterator<String> iterator = colorList.listIterator(1);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
