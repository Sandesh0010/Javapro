import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class Gamepanel extends JPanel implements Runnable{
    int x=0;
    int y=0;
    Thread thread;
    Gamepanel(){
        super();
        this.setPreferredSize (new Dimension(500,500));
        this.setBackground(Color.BLACK);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(x, y , 90, 90);
    }
public void StartGame(){
    thread=new Thread(this);
    thread.start();
}
public void Update(){

}

    @Override
    public void run() {
    double DrawInterval=1000000000/90;
    double DeltaTime=0;
    long LastpassTime=System.nanoTime();
    long CurrentTime=0;

        while (thread!=null){
        //long  time= System.nanoTime();
       //System.out.println("Game Loop"+ time);
       //x=x+1;
       CurrentTime=System.nanoTime();
       DeltaTime+=(CurrentTime-LastpassTime)/DrawInterval;
       LastpassTime=CurrentTime;
       if(DeltaTime>=1){
        x+=1;
        repaint();
        DeltaTime--;
       }
    }    
    }
}