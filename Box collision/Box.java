import java.awt.*;
import javax.swing.*;


public class Box extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(10,10, 80, 80);
        g.fillRect(490,10, 80, 80);
    }
}
