package de.firecreeper82.window.states;

import de.firecreeper82.main.Main;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(Main.name);
        this.setUndecorated(true);
        this.add(Main.instance);
    }

    public void openWindow() {
        this.setVisible(true);
    }

    public void closeWindow() {

    }

}
