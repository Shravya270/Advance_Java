/* 1b.  Array List programs  
   2. Write a java program for getting different colors through ArrayList interface and remove the 
   2nd element and color "Blue" from the ArrayList */

import java.util.*;

public class SortColors {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Orange", "Red", "Blue", "Green"));
        System.out.println("Before Sorting: " + colors);

        Collections.sort(colors);
        System.out.println("After Sorting: " + colors);
    }
}
