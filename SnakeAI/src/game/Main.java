package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main{
    
    public static int WIDTH = 500;
    public static int HEIGHT = 500;
    
    public static void main(String[] args) {
        GameInterface game = new GameInterface();
        JFrame jf = new JFrame();
        jf.setSize(WIDTH, HEIGHT);
       
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.add(game);

    }
}
