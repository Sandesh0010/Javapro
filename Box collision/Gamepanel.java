import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Gamepanel extends JPanel implements Runnable{
    Thread thread;
    int x=10,y=0,a=490,b=0;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(x,y, 80, 80);
        g.fillRect(a,b, 80, 80);
    }
    public void StartGame(){
        thread=new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
    double DrawInterval=1000000000/100;
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
        repaint();
        x++;
        a--;
        DeltaTime--;
       }
    }    
    }
}

