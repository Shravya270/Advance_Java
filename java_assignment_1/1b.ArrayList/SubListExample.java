import java.util.*;

public class SubListExample {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        System.out.println("Original List: " + colors);

        List<String> subList = colors.subList(0, 2); // index 0 and 1
        System.out.println("Extracted elements (1st and 2nd): " + subList);
    }
}
