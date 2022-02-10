package Gobblegum_Pack_Generator;

import javax.swing.*;
import java.awt.*;

public class Window {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Gobblegum pack generator");
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.setUndecorated(true);
        jFrame.add(new Generator());
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
