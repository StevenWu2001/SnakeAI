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
    
    public Test() {
        this.addKeyListener(new Key());
    }
    
    class Key extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            if(e.getExtendedKeyCode() == KeyEvent.VK_A) {
                System.out.println("up");
            }
        }
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setFocusable(true);
    }
    
    
}
