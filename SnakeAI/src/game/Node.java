package game;

public class Node {
    private int f;
    private int g;
    private int h;
    private Node parent;

    private int x;
    private int y;


    public Node(int x, int y, Node parent) {

        f = 0;
        g = 0;
        h = 0;

        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getF() {
        return f;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setF() {
        f = g + h;
    }
    
    public Node getParent() {
        return parent;
    }
}
