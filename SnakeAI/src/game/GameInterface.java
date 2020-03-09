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

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

public class GameInterface extends JPanel implements ActionListener, KeyListener {
    /*
     * Main game panel.
     */
    private Snake snake;
    private static final long serialVersionUID = 1L;
    private Timer timer = new Timer(25, this);
    private int xVel;
    private int yVel;
    private Food food;
    private int score = 0;
    private AStar aStar;

    private ArrayList<Node> path;
    private int pathIndex = 0;

    public GameInterface() {
        timer.start();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        snake = new Snake();
        food = new Food(Main.WIDTH, Main.HEIGHT);

        Node start = new Node(snake.head().getX(), snake.head().getY(), null);
        Node goal = new Node(food.getX(), food.getY(), null);
        aStar = new AStar();
        aStar.initialize(start, goal);
        aStar.setSnake(snake);
        path = aStar.getPath();
        for (Node n : path) {
            System.out.println(n.getX());
            System.out.println(n.getY());
            System.out.println();
        }

        xVel = 0;
        yVel = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (int i = 0; i < snake.getSnake().size(); i++) {
            g.fillRect(snake.getSnake().get(i).getX(), snake.getSnake().get(i).getY(), 10, 10);
        }

        g.setColor(Color.RED);
        g.fillRect(food.getX(), food.getY(), food.getSize(), food.getSize());

    }

    public void moveAI() {
        Node dir = path.get(pathIndex);
        Node nextDir = path.get(pathIndex + 1);

        xVel = nextDir.getX() - dir.getX();
        yVel = nextDir.getY() - dir.getY();
        pathIndex++;
    }

    public void actionPerformed(ActionEvent e) {
        if (snake.collide(food)) {
            food = new Food(Main.WIDTH, Main.HEIGHT);
            score++;

            snake.add();
            pathIndex = 0;

            Node start = new Node(snake.head().getX(), snake.head().getY(), null);
            Node goal = new Node(food.getX(), food.getY(), null);
            aStar.initialize(start, goal);
            aStar.setSnake(snake);
            path = aStar.getPath();
            for (Node n : path) {
                System.out.println(n.getX());
                System.out.println(n.getY());
                System.out.println();
            }
        }

        moveAI();
        snake.move(xVel, yVel);

        // Troll
//        if (snake.getSnake().get(0).getX() < food.getX()) {
//            xVel = 10;
//            yVel = 0;
//        } else if (snake.getSnake().get(0).getX() > food.getX()) {
//            xVel = -10;
//            yVel = 0;
//        }
//
//        if (snake.getSnake().get(0).getX() == food.getX()) {
//            xVel = 0;
//            if (snake.getSnake().get(0).getY() > food.getY()) {
//                yVel = -10;
//            } else if (snake.getSnake().get(0).getY() < food.getY()) {
//                yVel = 10;
//            }
//        }

        if (snake.dead()) {
            System.out.println("game over.");
        }

        repaint();
        revalidate();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {
            if (xVel == 0 || snake.getSnake().size() == 1) {
                xVel = -10;
                yVel = 0;
            }
        } else if (c == KeyEvent.VK_RIGHT) {
            if (xVel == 0 || snake.getSnake().size() == 1) {
                xVel = 10;
                yVel = 0;
            }
        } else if (c == KeyEvent.VK_UP) {
            if (yVel == 0 || snake.getSnake().size() == 1) {
                xVel = 0;
                yVel = -10;
            }
        } else if (c == KeyEvent.VK_DOWN) {
            if (yVel == 0 || snake.getSnake().size() == 1) {
                xVel = 0;
                yVel = 10;
            }
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
