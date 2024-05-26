import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 public class Boxes{
    public static void main(String[] args){
    JFrame frame= new JFrame("SPACESHIP");
    frame.setSize(500,500);
    
    JButton left= new JButton("Left");
    JButton right= new JButton("Right");
    Spaceship space= new Spaceship();
    left.addActionListener(new ActionListener() {
        
    public void actionPerformed(ActionEvent e){
        System.out.println("Left");
        space.moveleft();
     }
    });

    right.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e){
            System.out.println("Right");
            space.moveright();
         }
        });
    
    JPanel actionpanel=new JPanel();
    
    space.setPreferredSize(new Dimension(500,380));
    actionpanel.add(left);
    actionpanel.add(right);
    frame.add(space,BorderLayout.NORTH);
    frame.add(actionpanel);
    frame.setVisible(true);
    }
}
      
