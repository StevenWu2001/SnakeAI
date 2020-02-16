package game;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameInterface extends JPanel implements ActionListener, KeyListener {
    private Snake snake;
    private static final long serialVersionUID = 1L;
    private Timer timer = new Timer(5, this);
    private int xVel;
    private int yVel;

    public GameInterface() {
        timer.start();
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        snake = new Snake();
        xVel = 0;
        yVel = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (int i = 0; i < snake.getSnake().size(); i++) {
            g.fillRect(snake.getSnake().get(i).getX(), snake.getSnake().get(i).getY(), 10, 10);
        }
        
    }

    public void actionPerformed(ActionEvent e) {
        snake.move(xVel, yVel);
        repaint();
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            xVel = -10;
            yVel = 0;
        }else if (c == KeyEvent.VK_RIGHT) {
            xVel = 10;
            yVel = 0;
        }else if (c == KeyEvent.VK_UP) {
            xVel = 0;
            yVel = -10;
        }else if (c == KeyEvent.VK_DOWN) {
            xVel = 0;
            yVel = 10;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
