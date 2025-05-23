import java.util.*;

public class RemoveElements {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        System.out.println("Original List: " + colors);

        if (colors.size() > 1) {
            colors.remove(1); // Remove 2nd element (index 1)
        }

        colors.remove("Blue"); // Remove "Blue"
        System.out.println("After removing 2nd element and 'Blue': " + colors);
    }
}
