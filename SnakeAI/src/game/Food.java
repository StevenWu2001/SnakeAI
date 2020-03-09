package game;

import java.util.Random;

public class Food {
    /*
     * Food class. Position is randomly generated.
     */
    private int x;
    private int y;
    private int size;
    
    public Food(int width, int height) {
        Random r = new Random();
        x = r.nextInt(((int)(width * 0.7) + 10) + 1) + 10;
        y = r.nextInt(((int)(height * 0.7) + 10) + 1) + 10;
        
        x = (int)(x / 10) * 10;
        y = (int)(y / 10) * 10;
//        System.out.println("Food:");
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println();
        
        size = 10;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getSize() {
        return size;
    }
    
}
