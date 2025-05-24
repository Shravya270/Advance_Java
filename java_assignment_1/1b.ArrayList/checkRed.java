/* 1b.  Array List programs  
   2. Write a java program for getting different colors through ArrayList interface and remove the 
   2nd element and color "Blue" from the ArrayList */

import java.util.*;

public class checkRed {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow"));
        System.out.println("Colors List: " + colors);

        if (colors.contains("Red")) {
            System.out.println("Color 'Red' is available.");
        } else {
            System.out.println("Color 'Red' is not available.");
        }
    }
}
