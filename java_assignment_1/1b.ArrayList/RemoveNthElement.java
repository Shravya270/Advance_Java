import java.util.*;

public class RemoveNthElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        System.out.println("Before Deletion: " + colors);

        int n = 2; // Index of element to remove (3rd element)
        if (n < colors.size()) {
            colors.remove(n);
        }

        System.out.println("After deleting element at index " + n + ": " + colors);
    }
}
