import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class Spaceship extends JPanel{
    int x=200;
    int y=150;
    private Image spaceshipimage;
    Spaceship(){
        super();
        try{
            spaceshipimage= ImageIO.read(new File("./ship1.png"));
                    }
                    catch(IOException e){
                        System.out.println(e);
                    }
        
    }

    public void moveleft(){
        x=x-20;
        repaint();
    }
    public void moveright(){
        x=x+20;
        repaint();
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawImage (spaceshipimage,x, y, 90, 90,this);
       
    }  
}
