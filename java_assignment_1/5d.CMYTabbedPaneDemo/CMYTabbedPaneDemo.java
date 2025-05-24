
/*
 5d. Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and
display the concerned color whenever the specific tab is selected in the Pan
*/


import javax.swing.*;
import java.awt.*;

public class CMYTabbedPaneDemo extends JFrame {

    public CMYTabbedPaneDemo() {
        setTitle("CMY Tabbed Pane");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // CYAN panel
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);
        tabbedPane.addTab("CYAN", cyanPanel);

        // MAGENTA panel
        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);
        tabbedPane.addTab("MAGENTA", magentaPanel);

        // YELLOW panel
        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);
        tabbedPane.addTab("YELLOW", yellowPanel);

        // Add tabbedPane to the frame
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CMYTabbedPaneDemo());
    }
}
