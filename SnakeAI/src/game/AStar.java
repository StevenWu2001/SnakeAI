package game;

import java.util.ArrayList;
import java.util.Collections;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

public class AStar {
    private ArrayList<Node> open;
    private ArrayList<Node> close;
    private ArrayList<Node> invalid;
    private Node start;
    private Node goal;
    private ArrayList<Node> path;
    private Snake snake;

    public AStar() {

    }

    public void setSnake(Snake snake) {
        this.snake = snake;

        invalid = new ArrayList<>();
        for (int i = 1; i < snake.getSnake().size(); i++) {
            invalid.add(new Node(snake.getSnake().get(i).getX(), snake.getSnake().get(i).getY(), null));
        }

    }

    public void initialize(Node start, Node goal) {
        this.start = start;
        this.goal = goal;

        open = new ArrayList<>();
        close = new ArrayList<>();
        path = new ArrayList<>();

        open.add(this.start);

    }

    public ArrayList<Node> getPath() {
        Node current;
        ArrayList<Node> children;

        while (open.size() > 0) {
            children = new ArrayList<>();
            current = leastF();
            open.remove(open.indexOf(current));
            close.add(current);

            if (current.getX() == goal.getX() && current.getY() == goal.getY()) {
                while (!(current == null)) {
                    path.add(current);
                    current = current.getParent();
                }

                Collections.reverse(path);
                return path;
            }

            children.add(new Node(current.getX() + 10, current.getY(), current));
            children.add(new Node(current.getX() - 10, current.getY(), current));
            children.add(new Node(current.getX(), current.getY() + 10, current));
            children.add(new Node(current.getX(), current.getY() - 10, current));

            for (int l = 0; l < invalid.size(); l++) {
                for (int k = 0; k < children.size(); k++) {
                    if (children.get(k).getX() == invalid.get(l).getX()
                            && children.get(k).getY() == invalid.get(l).getY()) {
                        System.out.println(1);
                        children.remove(k);
                    }

                }
            }

            OUTER_LOOP: for (int i = 0; i < children.size(); i++) {
                Node child = children.get(i);

//                for (int j = 0; j < invalid.size(); j++) {
//                    if (child.getX() == invalid.get(j).getX() && child.getY() == invalid.get(j).getY()) {
//                        System.out.println(1);
//                        i++;
//                        continue OUTER_LOOP;
//                    }
//                }

                for (int j = 0; j < close.size(); j++) {
                    if (child.getX() == close.get(j).getX() && child.getY() == close.get(j).getY()) {
                        continue OUTER_LOOP;
                    }
                }

                child.setG(current.getG() + 10);

                int pathDis = (child.getX() - goal.getX()) * (child.getX() - goal.getX())
                        + (child.getY() - goal.getY()) * (child.getY() - goal.getY());
                child.setH(pathDis);
                child.setF();

                for (int j = 0; j < open.size(); j++) {
                    if (child.getX() == open.get(j).getX() && child.getY() == open.get(j).getY()) {
                        if (child.getG() > open.get(j).getG()) {
                            continue OUTER_LOOP;
                        }
                    }
                }

                open.add(child);
            }
        }

        return null;
    }

    private Node leastF() {
        Node result = open.get(0);

        for (int i = 1; i < open.size(); i++) {
            if (open.get(i).getF() < result.getF()) {
                result = open.get(i);
            }
        }

        return result;
    }

}
