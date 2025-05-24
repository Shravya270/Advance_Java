/*
4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour
Glass is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is
pressed by implementing the event handling mechanism with addActionListener( ).
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonDemo {

    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Button with Image");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold the buttons and label
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new FlowLayout());

        // Create JLabel to display the result
        JLabel label = new JLabel("Press a button");
        panel.add(label);

        // Load images for buttons
        ImageIcon digitalClockIcon = new ImageIcon("src/main/java/java_assignment_4/images/digital_clock.jpg");
        ImageIcon hourGlassIcon = new ImageIcon("src/main/java/java_assignment_4/images/hour_glass.jpg");

        // Check if images are loaded correctly
        System.out.println(digitalClockIcon.getImageLoadStatus()); // Should return 0 for successful load
        System.out.println(hourGlassIcon.getImageLoadStatus());    // Should return 0 for successful load

        // Resize images if necessary
        Image imgDigitalClock = digitalClockIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        digitalClockIcon = new ImageIcon(imgDigitalClock);

        Image imgHourGlass = hourGlassIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        hourGlassIcon = new ImageIcon(imgHourGlass);

        // Create JButtons with images
        JButton digitalClockButton = new JButton("Digital Clock", digitalClockIcon);
        JButton hourGlassButton = new JButton("Hour Glass", hourGlassIcon);

        // Add action listener for Digital Clock button
        digitalClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Digital Clock is pressed");
            }
        });

        // Add action listener for Hour Glass button
        hourGlassButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hour Glass is pressed");
            }
        });

        // Add buttons to panel
        panel.add(digitalClockButton);
        panel.add(hourGlassButton);

        // Make frame visible
        frame.setVisible(true);
    }
}
