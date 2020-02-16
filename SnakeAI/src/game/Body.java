package game;

public class Body {
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
}
