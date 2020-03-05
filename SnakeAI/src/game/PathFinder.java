package game;

import java.util.ArrayList;;

public class PathFinder {

    private ArrayList<String> path;
    private Body source;
    private Food food;
    private String stPath;

    public PathFinder() {

    }

    // Shortest Path Finder, based on Breadth-First Searching Algorithm
    public void shortestPath(Body source, Food food) {
        path = new ArrayList<>();
        path.add("");
        String[] moves = { "U", "R", "L", "D" };
        String add = "";
        String put = "";

        while (!foundPath(source, food, put)) {
            add = path.get(0);
            for (String move : moves) {
                put = add + move;
                if (valid(source, food, put)) {
                    path.add(put);
                }
            }
            
            if (foundPath(source, food, put)) {
                stPath = put;
            }
            path.remove(0);
        }

    }

    // Check if found the food
    private boolean foundPath(Body source, Food food, String move) {
        int xSpeed = 0;
        int ySpeed = 0;
        int sX = source.getX();
        int sY = source.getY();
        int fX = food.getX();
        int fY = food.getY();

        this.source = source;
        this.food = food;

        for (char direction : move.toCharArray()) {
            if (direction == 'U') {
                ySpeed = -10;
            } else if (direction == 'D') {
                ySpeed = 10;
            } else if (direction == 'L') {
                xSpeed = -10;
            } else if (direction == 'R') {
                xSpeed = 10;
            }

            sX += xSpeed;
            sY += ySpeed;
            
            xSpeed = 0;
            ySpeed = 0;
        }
        
//        System.out.println("Head:" + sX + sY);
//        System.out.println("Food:" + fX + fY);
//        System.out.println();

        return sX == fX && sY == fY;

    }

    // Check if Path is valid
    private boolean valid(Body source, Food food, String move) {
        int xSpeed = 0;
        int ySpeed = 0;
        int sX = source.getX();
        int sY = source.getY();

        for (char direction : move.toCharArray()) {
            if (direction == 'U') {
                ySpeed = -10;
            } else if (direction == 'D') {
                ySpeed = 10;
            } else if (direction == 'L') {
                xSpeed = -10;
            } else if (direction == 'R') {
                xSpeed = 10;
            }

            sX += xSpeed;
            sY += ySpeed;

            if (sX > Main.WIDTH || sY > Main.HEIGHT) {
                return false;
            }

        }

        return true;
    }

    public void printPath() {
        System.out.println(path.get(path.size() - 1));
    }

    public String getPath() {
        return stPath;
    }
}
