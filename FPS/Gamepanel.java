import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class Gamepanel extends JPanel implements Runnable{
  
    Thread thread;
    //Enemy enemy=new Enemy();
    Enemy[] enemies=new Enemy[10];
    Gamepanel(){
        super();
        this.setPreferredSize (new Dimension(500,500));
        this.setBackground(Color.black);
        for(int i=0;i<enemies.length;i++){
            enemies[i]=new Enemy();
        }

        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0;i<enemies.length;i++){
            enemies[i].paintComponent(g);
        }
      
    }
public void StartGame(){
    thread=new Thread(this);
    thread.start();
}
public void update(){
    for(int i=0;i<enemies.length;i++){
     
    enemies[i].update();

}
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
       update();
        repaint();
        DeltaTime--;
       }
    }    
    }
}