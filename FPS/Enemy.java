import java.awt.*;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Enemy extends JPanel {
    Random randomnumber=new Random();
    int x=randomnumber.nextInt(500);
    int y=randomnumber.nextInt(500);
    Image image;
    Enemy(){
        try{
            image=ImageIO.read(new File("./asteroid.png"));
        }
        catch (Exception e){

        }
           
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawImage(image,x,y,50,50,this);
        //g.fillRect(x,y, 80, 80);
    }
    public void update(){
        y+=1; 
    }
        
    }

