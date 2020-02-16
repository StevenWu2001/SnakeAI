package game;

import java.util.ArrayList;

public class Snake {
    private ArrayList<Body> snakeBodies = new ArrayList<Body>();
    private Body head;
    
    public Snake() {
        head = new Body(100, 100, 10);
        snakeBodies.add(head);
    }
    
    public ArrayList<Body> getSnake(){
        return snakeBodies;
    }
    
    public void move(int speedX, int speedY) {
        for (int i = 0; i < snakeBodies.size(); i++) {
            snakeBodies.get(i).moveX(speedX);
            snakeBodies.get(i).moveY(speedY);
        }
    }
    
}
