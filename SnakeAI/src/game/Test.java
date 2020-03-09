package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JPanel{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 5; j < 8; j++) {
                System.out.println(j);
                if (j > 6) {
                    continue;
                }
            }
        }
    }
    
    
}
