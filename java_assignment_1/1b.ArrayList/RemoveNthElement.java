/* 1b.  Array List programs  
   2. Write a java program for getting different colors through ArrayList interface and remove the 
   2nd element and color "Blue" from the ArrayList */


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
