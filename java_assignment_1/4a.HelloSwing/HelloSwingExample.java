
/*
 4a. Basic hello program of Swing displaying the message Hello! VI C , Welcome to Swing
Programming in Blue color plain font with font size of 32 using Jframe and Jlabel
 */

import javax.swing.*;
import java.awt.*;

public class HelloSwingExample {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Swing Hello Program");
        frame.setSize(600, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JLabel with the desired message
        JLabel label = new JLabel("Hello! VI C , Welcome to Swing Programming", SwingConstants.CENTER);
        label.setForeground(Color.BLUE); // Set text color to blue
        label.setFont(new Font("SansSerif", Font.PLAIN, 32)); // Set font style and size

        // Add label to frame
        frame.add(label);
        frame.setVisible(true);
    }
}
