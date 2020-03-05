package game;

import java.util.ArrayList;

public class Snake {
    /*
     * The Snake object, which contains an ArrayList of Bodies that represent each
     * component of the Snake.
     * 
     * The head of the Snake is created separately, because the only component that
     * we directly modify is the head.
     */

    private ArrayList<Body> snakeBodies = new ArrayList<Body>();

    // Snake head
    private Body head;

    public Snake() {
        head = new Body(100, 100, 10);
        snakeBodies.add(head);
    }

    public ArrayList<Body> getSnake() {
        return snakeBodies;
    }

    public Body head() {
        return head;
    }

    /*
     * Moving the Snake based on the the parameters speedX and speedY. We
     * only move the head directly, while shifting the rest of the Snake Bodies based
     * on the previous index.
     */
    public void move(int speedX, int speedY) {

        for (int i = snakeBodies.size() - 1; i > 0; i--) {
            snakeBodies.get(i).setX(snakeBodies.get(i - 1).getX());
            snakeBodies.get(i).setY(snakeBodies.get(i - 1).getY());
        }

//        System.out.println("Head:");
//        System.out.println(head.getX());
//        System.out.println(head.getY());
        head.moveX(speedX);
        head.moveY(speedY);

    }

    /*
     * Determine if the Snake collides with the food.
     */
    public boolean collide(Food food) {
        return food.getX() == head.getX() && food.getY() == head.getY();
    }

    /*
     * Add a new Snake Body at the Snake tail.
     */
    public void add() {
        Body newBody = new Body(snakeBodies.get(snakeBodies.size() - 1).getX(),
                snakeBodies.get(snakeBodies.size() - 1).getY(), 10);

        snakeBodies.add(newBody);
    }

    /*
     * Remove the last Snake Body.
     */
    public void remove() {
        snakeBodies.remove(snakeBodies.size() - 1);
    }

    /*
     * Determine if the game is over (either out of bound, or collides with itself).
     */
    public boolean dead() {
        for (int i = 1; i < snakeBodies.size(); i++) {
            if (head.getX() == snakeBodies.get(i).getX() && head.getY() == snakeBodies.get(i).getY()) {
                return true;
            }
        }
        return head.getX() > Main.WIDTH || head.getY() > Main.HEIGHT || head.getX() < 0 || head.getY() < 0;
    }

}
