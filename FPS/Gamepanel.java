import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Gamepanel extends JPanel implements Runnable{
  
    Thread thread;
    //Enemy enemy=new Enemy();
    Enemy[] enemies=new Enemy[10];
    Player player = new Player();

    Gamepanel(){
        super();
        this.setPreferredSize (new Dimension(500,500));
        this.setBackground(Color.black);
        for(int i=0;i<enemies.length;i++){
            enemies[i]=new Enemy();
        }
        setFocusable(true);
        addKeyListener(new KeyAdapter() {

          public void keyPressed(KeyEvent e){
          //  System.out.println("User have pressed the key");
            player.update(e);
          }
          public void keyReleased(KeyEvent e){
            player.stop();
          }
        });

        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.paintComponent(g);
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
player.move();
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