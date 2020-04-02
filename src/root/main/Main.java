package root.main;

import root.graphics.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Main {


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Reaction test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        GamePanel panel = new GamePanel();

        frame.setContentPane(panel);

        frame.pack();
//        frame.getContentPane().add(panel);



        frame.setVisible(true);
        panel.start();
    }
}
