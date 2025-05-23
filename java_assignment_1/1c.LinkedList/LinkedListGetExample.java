import java.util.*;

public class LinkedListGetExample {
    public static void main(String[] args) {
        LinkedList<String> colorList = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));

        System.out.println("Displaying elements with their positions:");
        for (int i = 0; i < colorList.size(); i++) {
            System.out.println("Index " + i + ": " + colorList.get(i));
        }
    }
}
