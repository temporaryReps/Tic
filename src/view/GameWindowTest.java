package view;

import javax.swing.*;
import java.awt.*;

public class GameWindowTest extends JFrame {
    public void init() {
        setSize(400, 400);
        setTitle("XO Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3, 3));

        add(jPanel);

        setVisible(true);
    }

}
