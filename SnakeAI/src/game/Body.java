package game;

public class Body {
    /*
     * Each component of a Snake is a Body, which is basically a 10*10 cube.
     */
    
    private int x;
    private int y;
    private int size;

    public Body(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveX(int speed) {
        x += speed;
    }

    public void moveY(int speed) {
        y += speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
