/*
 4b. Develop a Swing program in Java to display a message “Srilanka is pressed” or “India is
pressed” depending upon the Jbutton either Srilanka or India is pressed by implementing the
event handling mechanism with addActionListener( ).
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountryButtonDemo {

    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Country Pressed");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold the buttons and label
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new FlowLayout());

        // Create JLabel to display the result
        JLabel label = new JLabel("Press a button");
        panel.add(label);

        // Create JButtons
        JButton sriLankaButton = new JButton("Srilanka");
        JButton indiaButton = new JButton("India");

        // Add action listener for Srilanka button
        sriLankaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Srilanka is pressed");
            }
        });

        // Add action listener for India button
        indiaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("India is pressed");
            }
        });

        // Add buttons to panel
        panel.add(sriLankaButton);
        panel.add(indiaButton);

        // Make frame visible
        frame.setVisible(true);
    }
}
